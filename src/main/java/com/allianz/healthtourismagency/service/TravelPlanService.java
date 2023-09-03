package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.FlightEntity;
import com.allianz.healthtourismagency.database.entity.HotelEntity;
import com.allianz.healthtourismagency.database.entity.TravelPlanEntity;
import com.allianz.healthtourismagency.database.repository.FlightRepository;
import com.allianz.healthtourismagency.database.repository.HotelRepository;
import com.allianz.healthtourismagency.database.repository.TravelPlanRepository;
import com.allianz.healthtourismagency.database.specification.TravelPlanSpecification;
import com.allianz.healthtourismagency.mapper.FlightMapper;
import com.allianz.healthtourismagency.mapper.HotelMapper;
import com.allianz.healthtourismagency.mapper.TravelPlanMapper;
import com.allianz.healthtourismagency.model.FlightDTO;
import com.allianz.healthtourismagency.model.HotelDTO;
import com.allianz.healthtourismagency.model.SeatDTO;
import com.allianz.healthtourismagency.model.TravelPlanDTO;
import com.allianz.healthtourismagency.model.enums.FlightTypeEnum;
import com.allianz.healthtourismagency.model.enums.OccupancyStatusEnum;
import com.allianz.healthtourismagency.model.requestDTO.HotelReservationRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.TravelPlanRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class TravelPlanService extends BaseService<TravelPlanEntity, TravelPlanDTO, TravelPlanRequestDTO, TravelPlanMapper,
        TravelPlanRepository, TravelPlanSpecification> {

    private final TravelPlanMapper travelPlanMapper;
    private final TravelPlanRepository travelPlanRepository;
    private final TravelPlanSpecification travelPlanSpecification;
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final FlightService flightService;
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;
    private final HotelService hotelService;
    private final ConcurrentMap<UUID, Timer> travelPlanTimers = new ConcurrentHashMap<>();

    public TravelPlanService(TravelPlanMapper travelPlanMapper, TravelPlanRepository travelPlanRepository,
                             TravelPlanSpecification travelPlanSpecification, FlightRepository flightRepository,
                             FlightMapper flightMapper, FlightService flightService, HotelRepository hotelRepository,
                             HotelMapper hotelMapper, HotelService hotelService) {
        this.travelPlanMapper = travelPlanMapper;
        this.travelPlanRepository = travelPlanRepository;
        this.travelPlanSpecification = travelPlanSpecification;
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
        this.flightService = flightService;
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
        this.hotelService = hotelService;
    }


    @Override
    protected TravelPlanMapper getMapper() {
        return travelPlanMapper;
    }

    @Override
    protected TravelPlanRepository getRepository() {
        return travelPlanRepository;
    }

    @Override
    protected TravelPlanSpecification getSpecification() {
        return travelPlanSpecification;
    }


    @Transactional
    public TravelPlanDTO addFlightToTravelPlan(UUID travelPlanUUID, UUID flightUUID) {
        TravelPlanEntity travelPlanEntity = getRepository().findByUuid(travelPlanUUID).orElse(null);

        if(travelPlanEntity != null){
            FlightEntity flightEntity = flightRepository.findByUuid(flightUUID).orElse(null);
            if (flightEntity != null){
                TravelPlanDTO travelPlanDTO = travelPlanMapper.entityToDto(travelPlanEntity);
                FlightDTO flightDTO = flightMapper.entityToDto(flightEntity);
                travelPlanDTO.getFlightList().add(flightDTO);
                travelPlanDTO.getSeatList().add(flightService.selectRandomSeat(flightDTO));

                getRepository().save(getMapper().dtoToEntity(travelPlanDTO));

                if (travelPlanDTO.getFlightType() == FlightTypeEnum.ONE_WAY && travelPlanDTO.getFlightList().size() == 1) {

                    startTravelPlanTimer(travelPlanUUID);
                } else if (travelPlanDTO.getFlightType() == FlightTypeEnum.TWO_WAY && travelPlanDTO.getFlightList().size() == 2) {

                    startTravelPlanTimer(travelPlanUUID);
                }
                return travelPlanDTO;
            } else {
                throw new NullPointerException("Flight not found.");
            }
        } else{
            throw new NullPointerException("Travel plan not found.");
        }
    }

    @Transactional
    public TravelPlanDTO addHotelToTravelPlan(UUID travelPlanUUID, UUID hotelUUID,
                                              HotelReservationRequestDTO hotelReservationRequestDTO) {
        TravelPlanEntity travelPlanEntity = getRepository().findByUuid(travelPlanUUID).orElse(null);
        if (travelPlanEntity != null) {
            HotelEntity hotelEntity = hotelRepository.findByUuid(hotelUUID).orElse(null);
            if (hotelEntity != null) {
                TravelPlanDTO travelPlanDTO = travelPlanMapper.entityToDto(travelPlanEntity);
                HotelDTO hotelDTO = hotelMapper.entityToDto(hotelEntity);
                travelPlanDTO.setHotel(hotelMapper.entityToDto(hotelEntity));
                travelPlanDTO.setRoom(hotelService.selectRandomRoom(hotelDTO, hotelReservationRequestDTO));

                getRepository().save(getMapper().dtoToEntity(travelPlanDTO));
                cancelTravelPlanTimer(travelPlanUUID);

                return travelPlanDTO;
            } else {
                throw new NullPointerException("Hotel not found.");

            }

        } else {
            throw new NullPointerException("Travel plan not found.");
        }

    }


    private void startTravelPlanTimer(UUID travelPlanUUID) {
        Timer timer = new Timer("TravelPlanTimer-" + travelPlanUUID.toString());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                boolean isCompleted = isTravelPlanCompleted(travelPlanUUID);

                if (!isCompleted) {
                    handleIncompleteTravelPlan(travelPlanUUID);
                    throw new IllegalStateException("The travel plan is incomplete.");
                }
            }
        }, 10 * 60 * 1000);
        travelPlanTimers.put(travelPlanUUID, timer);
    }

    private void cancelTravelPlanTimer(UUID travelPlanUUID) {
        Timer timer = travelPlanTimers.remove(travelPlanUUID);
        if (timer != null) {
            timer.cancel();
        }
    }

    public boolean isTravelPlanCompleted(UUID travelPlanUUID) {
        TravelPlanEntity travelPlanEntity = getRepository().findByUuid(travelPlanUUID).orElse(null);

        if (travelPlanEntity != null) {
            if (travelPlanEntity.getHotel() != null) {
                return true;
            }
            return false;
        } else return false;
    }


    private void handleIncompleteTravelPlan(UUID travelPlanUUID) {
        TravelPlanEntity travelPlanEntity = getRepository().findByUuid(travelPlanUUID).orElse(null);
        if (travelPlanEntity != null && travelPlanEntity.getHotel() == null) {
            resetSeatStatuses(travelPlanUUID);
        }
    }

    private void resetSeatStatuses(UUID travelPlanUUID) {
        TravelPlanEntity travelPlanEntity = getRepository().findByUuid(travelPlanUUID).orElse(null);
        TravelPlanDTO travelPlanDTO = getMapper().entityToDto(travelPlanEntity);

        for (SeatDTO seat : travelPlanDTO.getSeatList()) {
            if (seat.getOccupancyStatus() == OccupancyStatusEnum.PENDING) {
                seat.setOccupancyStatus(OccupancyStatusEnum.AVAILABLE);
            }
        }
        getRepository().save(getMapper().dtoToEntity(travelPlanDTO));
    }

}
