package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.FlightSeatEntity;
import com.example.healthtourismapp.database.repositories.FlightSeatRepository;
import com.example.healthtourismapp.database.specification.FlightSeatSpecification;
import com.example.healthtourismapp.mapper.FlightSeatMapper;
import com.example.healthtourismapp.model.FlightSeatDTO;
import com.example.healthtourismapp.model.requestDTO.FlightSeatRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class FlightSeatService extends BaseService<
        FlightSeatEntity,
        FlightSeatDTO,
        FlightSeatRequestDTO,
        FlightSeatMapper,
        FlightSeatRepository, FlightSeatSpecification> {

    private final FlightSeatMapper flightSeatMapper;
    private final FlightSeatRepository flightSeatRepository;
    private final FlightSeatSpecification flightSeatSpecification;

    public FlightSeatService(FlightSeatMapper flightSeatMapper, FlightSeatRepository flightSeatRepository, FlightSeatSpecification flightSeatSpecification) {
        this.flightSeatMapper = flightSeatMapper;
        this.flightSeatRepository = flightSeatRepository;
        this.flightSeatSpecification = flightSeatSpecification;
    }

    @Override
    public FlightSeatMapper getMapper() {
        return flightSeatMapper;
    }

    @Override
    public FlightSeatRepository getRepository() {
        return flightSeatRepository;
    }

    @Override
    protected FlightSeatSpecification getSpecification() {
        return flightSeatSpecification;
    }
}
