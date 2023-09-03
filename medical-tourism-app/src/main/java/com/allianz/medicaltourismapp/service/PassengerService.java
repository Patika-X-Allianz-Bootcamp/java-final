package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.PassengerEntity;
import com.allianz.medicaltourismapp.database.repository.PassengerEntityRepository;
import com.allianz.medicaltourismapp.database.repository.PassengerEntityRepository;

import com.allianz.medicaltourismapp.database.specification.PassengerSpecification;
import com.allianz.medicaltourismapp.database.specification.PassengerSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.PassengerMapper;
import com.allianz.medicaltourismapp.mapper.PassengerMapper;

import com.allianz.medicaltourismapp.model.PassengerDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PassengerService extends BaseService<
        PassengerDTO,
        PassengerEntity,
        PassengerEntityRepository,
        PassengerMapper,
        PassengerSpecification> {

    private final PassengerEntityRepository passengerEntityRepository;


    private final PassengerSpecification passengerSpecification;
    private final PassengerMapper mapper;


    @Override
    protected PassengerMapper getMapper() {
        return mapper;    }

    @Override
    protected PassengerEntityRepository getRepository() {
        return passengerEntityRepository;
    }

    @Override
    protected PassengerSpecification getSpecification() {
        return passengerSpecification;
    }
}