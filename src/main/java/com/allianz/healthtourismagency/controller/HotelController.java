package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.HotelEntity;
import com.allianz.healthtourismagency.database.repository.HotelRepository;
import com.allianz.healthtourismagency.database.specification.HotelSpecification;
import com.allianz.healthtourismagency.mapper.HotelMapper;
import com.allianz.healthtourismagency.model.HotelDTO;
import com.allianz.healthtourismagency.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourismagency.service.HotelService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<
        HotelEntity,
        HotelDTO,
        HotelRequestDTO,
        HotelMapper,
        HotelRepository,
        HotelSpecification,
        HotelService> {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    protected HotelService getService() {
        return hotelService;
    }
}
