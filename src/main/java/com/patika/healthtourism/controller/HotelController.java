package com.patika.healthtourism.controller;

import com.patika.healthtourism.database.entity.HotelEntity;
import com.patika.healthtourism.database.repository.HotelEntityRepository;
import com.patika.healthtourism.mapper.HotelMapper;
import com.patika.healthtourism.model.HotelDTO;
import com.patika.healthtourism.model.requestDTO.HotelRequestDTO;
import com.patika.healthtourism.service.HotelService;
import com.patika.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController extends BaseController<HotelEntity, HotelDTO, HotelRequestDTO, HotelMapper,
        HotelEntityRepository, HotelService> {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    protected HotelService getService() {
        return hotelService;
    }
}
