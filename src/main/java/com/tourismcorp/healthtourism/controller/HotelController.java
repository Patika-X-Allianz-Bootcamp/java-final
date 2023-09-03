package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.HotelEntity;
import com.tourismcorp.healthtourism.database.repositories.HotelRepository;
import com.tourismcorp.healthtourism.database.specification.HotelSpecification;
import com.tourismcorp.healthtourism.mapper.HotelMapper;
import com.tourismcorp.healthtourism.model.HotelDTO;
import com.tourismcorp.healthtourism.model.requestDTO.HotelRequestDTO;
import com.tourismcorp.healthtourism.service.HotelService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    HotelService hotelService;

    @Override
    protected HotelService getService() {
        return this.hotelService;
    }
}

