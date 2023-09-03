package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.mapper.FlightMapper;
import com.allianz.healthtourism.model.DTO.FlightDTO;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.service.FlightService;
import com.allianz.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController extends BaseController<FlightEntity, FlightDTO, FlightRequestDTO,
        FlightMapper, FlightRepository, FlightService> {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    protected FlightService getService() {
        return flightService;
    }
}
