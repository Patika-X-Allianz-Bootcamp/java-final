package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.FlightEntity;
import com.allianz.medicaltourismapp.database.repository.FlightEntityRepository;
import com.allianz.medicaltourismapp.database.repository.FlightEntityRepository;

import com.allianz.medicaltourismapp.database.specification.FlightSpecification;
import com.allianz.medicaltourismapp.database.specification.FlightSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.FlightMapper;
import com.allianz.medicaltourismapp.mapper.FlightMapper;

import com.allianz.medicaltourismapp.model.FlightDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FlightService extends BaseService<
        FlightDTO,
        FlightEntity,
        FlightEntityRepository,
        FlightMapper,
        FlightSpecification> {

    private final FlightEntityRepository flightEntityRepository;


    private final FlightSpecification flightSpecification;
    private final FlightMapper mapper;


    @Override
    protected FlightMapper getMapper() {
        return mapper;    }
    @Override
    protected FlightEntityRepository getRepository() {
        return flightEntityRepository;
    }

    @Override
    protected FlightSpecification getSpecification() {
        return flightSpecification;
    }
}