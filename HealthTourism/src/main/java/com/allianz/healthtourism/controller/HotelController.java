package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.database.repository.HotelRepository;
import com.allianz.healthtourism.mapper.HotelMapper;
import com.allianz.healthtourism.model.DTO.HotelDTO;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.service.HotelService;
import com.allianz.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<HotelEntity, HotelDTO, HotelRequestDTO,
        HotelMapper, HotelRepository, HotelService> {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    protected HotelService getService() {
        return hotelService;
    }
}
