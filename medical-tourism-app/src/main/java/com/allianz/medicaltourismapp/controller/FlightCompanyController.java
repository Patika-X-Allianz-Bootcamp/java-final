package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.FlightCompanyEntity;
import com.allianz.medicaltourismapp.database.repository.FlightCompanyEntityRepository;
import com.allianz.medicaltourismapp.database.specification.FlightCompanySpecification;
import com.allianz.medicaltourismapp.mapper.FlightCompanyMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.FlightCompanyDTO;
import com.allianz.medicaltourismapp.service.FlightCompanyService;
import com.allianz.medicaltourismapp.util.BaseController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("flightCompany")
@RequiredArgsConstructor
public class FlightCompanyController extends BaseController<
        FlightCompanyEntity,
        FlightCompanyDTO,
        FlightCompanyMapper,
        FlightCompanyEntityRepository,
        FlightCompanySpecification, 
        FlightCompanyService
        > {

    @Autowired
    FlightCompanyMapper flightCompanyMapper;

    @Override
    protected FlightCompanyMapper getMapper() {
        return flightCompanyMapper;
    }

    @Autowired
    FlightCompanyService flightCompanyService;
    @Override
    protected FlightCompanyService getService() {
        return flightCompanyService;
    }
}