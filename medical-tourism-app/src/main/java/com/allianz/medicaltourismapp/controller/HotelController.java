package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.HotelEntity;
import com.allianz.medicaltourismapp.database.repository.HotelEntityRepository;
import com.allianz.medicaltourismapp.database.specification.HotelSpecification;
import com.allianz.medicaltourismapp.mapper.HotelMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.HotelDTO;
import com.allianz.medicaltourismapp.service.HotelService;
import com.allianz.medicaltourismapp.util.BaseController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("hotel")
@RequiredArgsConstructor
public class HotelController extends BaseController<
        HotelEntity,
        HotelDTO,
        HotelMapper,
        HotelEntityRepository,
        HotelSpecification, HotelService
        > {

    @Autowired
    HotelMapper hotelMapper;
    @Override
    protected HotelMapper getMapper() {
        return hotelMapper;
    }
    @Autowired
    HotelService hotelService;
    @Override
    protected HotelService getService() {
        return hotelService;
    }
}