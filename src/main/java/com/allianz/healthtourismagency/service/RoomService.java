package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.HotelReservationEntity;
import com.allianz.healthtourismagency.database.entity.RoomEntity;
import com.allianz.healthtourismagency.database.repository.RoomRepository;
import com.allianz.healthtourismagency.database.specification.RoomSpecification;
import com.allianz.healthtourismagency.mapper.RoomMapper;
import com.allianz.healthtourismagency.model.HotelReservationDTO;
import com.allianz.healthtourismagency.model.RoomDTO;
import com.allianz.healthtourismagency.model.requestDTO.HotelReservationRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.RoomRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomService extends BaseService<RoomEntity, RoomDTO, RoomRequestDTO, RoomMapper, RoomRepository,
        RoomSpecification> {

    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;
    private final RoomSpecification roomSpecification;

    public RoomService(RoomMapper roomMapper, RoomRepository roomRepository, RoomSpecification roomSpecification) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
        this.roomSpecification = roomSpecification;
    }

    @Override
    protected RoomMapper getMapper() {
        return roomMapper;
    }

    @Override
    protected RoomRepository getRepository() {
        return roomRepository;
    }

    @Override
    protected RoomSpecification getSpecification() {
        return roomSpecification;
    }


    public boolean isRoomAvailable(List<HotelReservationDTO> reservationList, HotelReservationRequestDTO hotelReservationRequestDTO) {
        for (HotelReservationDTO reservation : reservationList) {
            if (reservation.getStartDate().before(hotelReservationRequestDTO.getEndDate())
                    && reservation.getEndDate().after(hotelReservationRequestDTO.getStartDate())) {
                return false;
            }
        }
        return true;
    }

}
