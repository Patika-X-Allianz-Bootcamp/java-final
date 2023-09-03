package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.FlightEntity;
import com.example.healthtourismapp.database.entities.FlightSeatEntity;
import com.example.healthtourismapp.database.repositories.FlightRepository;
import com.example.healthtourismapp.database.repositories.FlightSeatRepository;
import com.example.healthtourismapp.database.specification.FlightSpecification;
import com.example.healthtourismapp.mapper.FlightMapper;
import com.example.healthtourismapp.model.FlightDTO;
import com.example.healthtourismapp.model.requestDTO.FlightRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FlightService extends BaseService<
        FlightEntity,
        FlightDTO,
        FlightRequestDTO,
        FlightMapper,
        FlightRepository, FlightSpecification> {

    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;
    private final FlightSeatRepository flightSeatRepository;
    private final FlightSpecification flightSpecification;

    public FlightService(FlightMapper flightMapper, FlightRepository flightRepository, FlightSeatRepository flightSeatRepository, FlightSpecification flightSpecification) {
        this.flightMapper = flightMapper;
        this.flightRepository = flightRepository;
        this.flightSeatRepository = flightSeatRepository;
        this.flightSpecification = flightSpecification;
    }

    @Override
    public FlightMapper getMapper() {
        return flightMapper;
    }

    @Override
    public FlightRepository getRepository() {
        return flightRepository;
    }

    @Override
    protected FlightSpecification getSpecification() {
        return flightSpecification;
    }

    /*
    public double calculateBill(FlightEntity flightEntity) {

        double distance = flightEntity.getDistance();

        return distance * 10.0;
    }

     */

    public Optional<FlightSeatEntity> selectFlightSeat(UUID flightUuid, UUID flightSeatUuid) {
        Optional<FlightEntity> flightOptional = flightRepository.findByUuid(flightUuid);
        if (flightOptional.isPresent()) {
            FlightEntity flight = flightOptional.get();
            for (FlightSeatEntity flightSeat : flight.getSeat()) {
                if (flight.getUuid().equals(flightSeatUuid)) {
                    return Optional.of(flightSeat);
                }
            }
        }
        return Optional.empty();
    }









}
