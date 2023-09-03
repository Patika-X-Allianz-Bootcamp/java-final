package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.FlightEntity;
import com.allianz.healthtourismagency.database.repository.FlightRepository;
import com.allianz.healthtourismagency.database.specification.FlightSpecification;
import com.allianz.healthtourismagency.mapper.FlightMapper;
import com.allianz.healthtourismagency.model.FlightDTO;
import com.allianz.healthtourismagency.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourismagency.service.FlightService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.web.bind.annotation.*;

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

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    protected FlightService getService() {
        return flightService;
    }



}
