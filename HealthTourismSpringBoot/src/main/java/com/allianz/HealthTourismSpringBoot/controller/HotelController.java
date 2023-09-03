package com.allianz.HealthTourismSpringBoot.controller;

import com.allianz.HealthTourismSpringBoot.database.entities.HotelEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.HotelRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.HotelSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.HotelMapper;
import com.allianz.HealthTourismSpringBoot.model.HotelDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.HotelRequestDTO;
import com.allianz.HealthTourismSpringBoot.service.HotelService;
import com.allianz.HealthTourismSpringBoot.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController extends BaseController<HotelEntity,
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
        return hotelService;
    }
}
