package com.patika.healthtourism.controller;

import com.patika.healthtourism.database.entity.FlightEntity;
import com.patika.healthtourism.database.repository.FlightEntityRepository;
import com.patika.healthtourism.mapper.FlightMapper;
import com.patika.healthtourism.model.FlightDTO;
import com.patika.healthtourism.model.requestDTO.FlightRequestDTO;
import com.patika.healthtourism.service.FlightService;
import com.patika.healthtourism.util.BaseController;
import com.patika.healthtourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController extends BaseController<FlightEntity, FlightDTO, FlightRequestDTO, FlightMapper, FlightEntityRepository, FlightService> {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    protected FlightService getService() {
        return flightService;
    }
}
