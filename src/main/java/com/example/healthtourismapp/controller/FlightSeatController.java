package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.FlightSeatEntity;
import com.example.healthtourismapp.database.repositories.FlightSeatRepository;
import com.example.healthtourismapp.database.specification.FlightSeatSpecification;
import com.example.healthtourismapp.mapper.FlightSeatMapper;
import com.example.healthtourismapp.model.FlightSeatDTO;
import com.example.healthtourismapp.model.requestDTO.FlightSeatRequestDTO;
import com.example.healthtourismapp.service.FlightSeatService;
import com.example.healthtourismapp.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight-seats")
public class FlightSeatController extends BaseController<FlightSeatEntity, FlightSeatDTO, FlightSeatRequestDTO,
        FlightSeatMapper, FlightSeatRepository, FlightSeatSpecification, FlightSeatService> {

    private final FlightSeatService flightSeatService;

    public FlightSeatController(FlightSeatService flightSeatService) {
        this.flightSeatService = flightSeatService;
    }

    @Override
    protected FlightSeatService getService() {
        return flightSeatService;
    }
}
