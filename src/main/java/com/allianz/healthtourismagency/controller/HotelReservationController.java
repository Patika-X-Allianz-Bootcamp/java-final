package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.HotelReservationEntity;
import com.allianz.healthtourismagency.database.repository.HotelReservationRepository;
import com.allianz.healthtourismagency.database.specification.HotelReservationSpecification;
import com.allianz.healthtourismagency.mapper.HotelReservationMapper;
import com.allianz.healthtourismagency.model.HotelReservationDTO;
import com.allianz.healthtourismagency.model.requestDTO.HotelReservationRequestDTO;
import com.allianz.healthtourismagency.service.HotelReservationService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservation")
public class HotelReservationController extends BaseController<
        HotelReservationEntity,
        HotelReservationDTO,
        HotelReservationRequestDTO,
        HotelReservationMapper,
        HotelReservationRepository,
        HotelReservationSpecification,
        HotelReservationService> {

    private final HotelReservationService hotelReservationService;

    public HotelReservationController(HotelReservationService hotelReservationService) {
        this.hotelReservationService = hotelReservationService;
    }

    @Override
    protected HotelReservationService getService() {
        return hotelReservationService;
    }
}
