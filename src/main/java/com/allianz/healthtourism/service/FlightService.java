package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.mapper.FlightMapper;
import com.allianz.healthtourism.model.DTO.FlightDTO;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends BaseService<FlightEntity, FlightDTO, FlightRequestDTO,
        FlightMapper, FlightRepository> {

    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;

    public FlightService(FlightMapper flightMapper, FlightRepository flightRepository) {
        this.flightMapper = flightMapper;
        this.flightRepository = flightRepository;
    }

    @Override
    protected FlightMapper getMapper() {
        return flightMapper;
    }

    @Override
    protected FlightRepository getRepository() {
        return flightRepository;
    }
}
