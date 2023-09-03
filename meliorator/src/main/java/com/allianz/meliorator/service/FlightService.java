package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Flight;
import com.allianz.meliorator.database.repository.FlightRepository;
import com.allianz.meliorator.database.specification.FlightSpecification;
import com.allianz.meliorator.mapper.FlightMapper;
import com.allianz.meliorator.model.dto.FlightDTO;
import com.allianz.meliorator.model.requestDTO.FlightRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends BaseService<Flight, FlightDTO, FlightRequestDTO,
        FlightMapper, FlightRepository, FlightSpecification> {
    @Autowired
    FlightSpecification flightSpecification;
    @Autowired
    FlightMapper flightMapper;
    @Autowired
    FlightRepository flightRepository;
    @Override
    protected FlightMapper getMapper() {
        return this.flightMapper;
    }

    @Override
    protected FlightRepository getRepository() {
        return this.flightRepository;
    }

    @Override
    protected FlightSpecification getSpecification() {
        return this.flightSpecification;
    }
}
