package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.FlightEntity;
import com.tourismcorp.healthtourism.database.repositories.FlightRepository;
import com.tourismcorp.healthtourism.database.specification.FlightSpecification;
import com.tourismcorp.healthtourism.mapper.FlightMapper;
import com.tourismcorp.healthtourism.model.FlightDTO;
import com.tourismcorp.healthtourism.model.requestDTO.FlightRequestDTO;
import com.tourismcorp.healthtourism.service.FlightService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController extends BaseController<
        FlightEntity,
        FlightDTO,
        FlightRequestDTO,
        FlightMapper,
        FlightRepository,
        FlightSpecification,
        FlightService> {

    @Autowired
    FlightService flightService;

    @Override
    protected FlightService getService() {
        return this.flightService;
    }
}
