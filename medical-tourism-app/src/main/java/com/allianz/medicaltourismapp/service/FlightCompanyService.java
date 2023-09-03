package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.FlightCompanyEntity;
import com.allianz.medicaltourismapp.database.repository.FlightCompanyEntityRepository;
import com.allianz.medicaltourismapp.database.repository.FlightCompanyEntityRepository;

import com.allianz.medicaltourismapp.database.specification.FlightCompanySpecification;
import com.allianz.medicaltourismapp.database.specification.FlightCompanySpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.FlightCompanyMapper;
import com.allianz.medicaltourismapp.mapper.FlightCompanyMapper;

import com.allianz.medicaltourismapp.model.FlightCompanyDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FlightCompanyService extends BaseService<
        FlightCompanyDTO,
        FlightCompanyEntity,
        FlightCompanyEntityRepository,
        FlightCompanyMapper,
        FlightCompanySpecification> {

    private final FlightCompanyEntityRepository flightCompanyEntityRepository;


    private final FlightCompanySpecification flightCompanySpecification;
    private final FlightCompanyMapper mapper;


    @Override
    protected FlightCompanyMapper getMapper() {
        return mapper;    }

    @Override
    protected FlightCompanyEntityRepository getRepository() {
        return flightCompanyEntityRepository;
    }

    @Override
    protected FlightCompanySpecification getSpecification() {
        return flightCompanySpecification;
    }
}