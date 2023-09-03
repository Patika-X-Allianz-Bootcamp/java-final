package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.FlightEntity;
import com.allianz.medicaltourismapp.database.repository.FlightEntityRepository;
import com.allianz.medicaltourismapp.database.specification.FlightSpecification;
import com.allianz.medicaltourismapp.mapper.FlightMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.FlightDTO;
import com.allianz.medicaltourismapp.service.FlightService;
import com.allianz.medicaltourismapp.util.BaseController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
@RequiredArgsConstructor
public class FlightController extends BaseController<
        FlightEntity,
        FlightDTO,
        FlightMapper,
        FlightEntityRepository,
        FlightSpecification, FlightService
        > {

    @Autowired
    FlightMapper flightMapper;
    @Override
    protected FlightMapper getMapper() {
        return flightMapper;
    }
    @Autowired
    FlightService flightService;
    @Override
    protected FlightService getService() {
        return flightService;
    }
}