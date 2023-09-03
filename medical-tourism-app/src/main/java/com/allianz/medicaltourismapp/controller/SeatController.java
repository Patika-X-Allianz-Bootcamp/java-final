package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.SeatEntity;
import com.allianz.medicaltourismapp.database.repository.SeatEntityRepository;
import com.allianz.medicaltourismapp.database.specification.SeatSpecification;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.SeatDTO;
import com.allianz.medicaltourismapp.service.SeatService;
import com.allianz.medicaltourismapp.util.BaseController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("seat")
@RequiredArgsConstructor
public class SeatController extends BaseController<
        
        SeatEntity,
        SeatDTO,
        SeatMapper,
        SeatEntityRepository,
        SeatSpecification, SeatService
        > {

    @Autowired
    SeatMapper seatMapper;

    @Override
    protected SeatMapper getMapper() {
        return seatMapper;
    }
    @Autowired
    SeatService seatService;
    @Override
    protected SeatService getService() {
        return seatService;
    }
}