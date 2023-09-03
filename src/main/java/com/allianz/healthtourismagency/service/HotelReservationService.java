package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.HotelReservationEntity;
import com.allianz.healthtourismagency.database.repository.HotelReservationRepository;
import com.allianz.healthtourismagency.database.specification.HotelReservationSpecification;
import com.allianz.healthtourismagency.mapper.HotelReservationMapper;
import com.allianz.healthtourismagency.model.HotelReservationDTO;
import com.allianz.healthtourismagency.model.requestDTO.HotelReservationRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class HotelReservationService extends BaseService<HotelReservationEntity, HotelReservationDTO, HotelReservationRequestDTO,
        HotelReservationMapper, HotelReservationRepository, HotelReservationSpecification> {

    private final HotelReservationMapper hotelReservationMapper;
    private final HotelReservationRepository hotelReservationRepository;
    private final HotelReservationSpecification hotelReservationSpecification;

    public HotelReservationService(HotelReservationMapper hotelReservationMapper, HotelReservationRepository hotelReservationRepository,
                                   HotelReservationSpecification hotelReservationSpecification) {
        this.hotelReservationMapper = hotelReservationMapper;
        this.hotelReservationRepository = hotelReservationRepository;
        this.hotelReservationSpecification = hotelReservationSpecification;
    }


    @Override
    protected HotelReservationMapper getMapper() {
        return hotelReservationMapper;
    }

    @Override
    protected HotelReservationRepository getRepository() {
        return hotelReservationRepository;
    }

    @Override
    protected HotelReservationSpecification getSpecification() {
        return hotelReservationSpecification;
    }
}
