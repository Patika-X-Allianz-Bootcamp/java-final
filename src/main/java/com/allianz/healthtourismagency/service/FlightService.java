package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.FlightEntity;
import com.allianz.healthtourismagency.database.repository.FlightRepository;
import com.allianz.healthtourismagency.database.specification.FlightSpecification;
import com.allianz.healthtourismagency.mapper.FlightMapper;
import com.allianz.healthtourismagency.model.FlightDTO;
import com.allianz.healthtourismagency.model.SeatDTO;
import com.allianz.healthtourismagency.model.TravelPlanDTO;
import com.allianz.healthtourismagency.model.enums.OccupancyStatusEnum;
import com.allianz.healthtourismagency.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class FlightService extends BaseService<FlightEntity, FlightDTO, FlightRequestDTO, FlightMapper, FlightRepository,
        FlightSpecification> {

    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;
    private final FlightSpecification flightSpecification;

    public FlightService(FlightMapper flightMapper, FlightRepository flightRepository,
                         FlightSpecification flightSpecification) {
        this.flightMapper = flightMapper;
        this.flightRepository = flightRepository;
        this.flightSpecification = flightSpecification;
    }

    @Override
    protected FlightMapper getMapper() {
        return flightMapper;
    }

    @Override
    protected FlightRepository getRepository() {
        return flightRepository;
    }

    @Override
    protected FlightSpecification getSpecification() {
        return flightSpecification;
    }

    @Override
    public FlightDTO save(FlightRequestDTO flightRequestDTO) {
        flightRequestDTO.setSeatList(null);
        flightRequestDTO.setFlightDuration(null);

        FlightDTO flightDTO = flightMapper.entityToDto(flightMapper.requestDtoToEntity(flightRequestDTO));
        addSeatListToFlight(flightDTO);
        addFlightDurationToFlight(flightDTO);

        flightRepository.save(flightMapper.dtoToEntity(flightDTO));
        return flightDTO;
    }

    public void addSeatListToFlight(FlightDTO flightDTO) {
        List<SeatDTO> seatList = new ArrayList<>();
        for (int seatNumber = 1; seatNumber <= flightDTO.getCapacity(); seatNumber++) {
            SeatDTO seat = new SeatDTO();
            seat.setSeatNumber(seatNumber);
            seat.setOccupancyStatus(OccupancyStatusEnum.AVAILABLE);
            seatList.add(seat);
        }
        flightDTO.setSeatList(seatList);
    }

    public void addFlightDurationToFlight(FlightDTO flightDTO) {
        Duration duration = Duration.between(flightDTO.getDepartingTime(), flightDTO.getArrivingTime());
        if (duration.isNegative()) {
            duration = duration.plusDays(1);
        }
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();

        flightDTO.setFlightDuration(String.format("%02d:%02d", hours, minutes));
    }

    public SeatDTO selectRandomSeat(FlightDTO flightDTO) {
        List<SeatDTO> availableSeats = flightDTO.getSeatList();
        List<SeatDTO> availableSeatsCopy = new ArrayList<>(availableSeats);

        Iterator<SeatDTO> iterator = availableSeatsCopy.iterator();
        while (iterator.hasNext()) {
            SeatDTO seat = iterator.next();
            if (seat.getOccupancyStatus() != OccupancyStatusEnum.AVAILABLE) {
                iterator.remove();
            }
        }

        if (availableSeatsCopy.isEmpty()) {
            throw new IllegalStateException("No available seats on this flight.");
        }

        Random randomSeat = new Random();
        int selectedIndex = randomSeat.nextInt(availableSeatsCopy.size());
        SeatDTO selectedSeat = availableSeatsCopy.get(selectedIndex);

        selectedSeat.setOccupancyStatus(OccupancyStatusEnum.PENDING);
        return selectedSeat;
    }


}
