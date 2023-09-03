package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Flight;
import com.allianz.meliorator.database.repository.FlightRepository;
import com.allianz.meliorator.mapper.FlightMapper;
import com.allianz.meliorator.model.dto.FlightDTO;
import com.allianz.meliorator.model.requestDTO.FlightRequestDTO;
import com.allianz.meliorator.service.FlightService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController extends BaseController<Flight, FlightDTO, FlightRequestDTO, FlightMapper,
        FlightRepository, FlightService> {
    @Autowired
    FlightService flightService;
    @Override
    protected FlightService getService() {
        return this.flightService;
    }
}
