package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.SeatEntity;
import com.allianz.medicaltourismapp.database.repository.SeatEntityRepository;
import com.allianz.medicaltourismapp.database.repository.SeatEntityRepository;

import com.allianz.medicaltourismapp.database.specification.SeatSpecification;
import com.allianz.medicaltourismapp.database.specification.SeatSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.SeatDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SeatService extends BaseService<
        SeatDTO,
        SeatEntity,
        SeatEntityRepository,
        SeatMapper,
        SeatSpecification> {

    private final SeatEntityRepository seatEntityRepository;
    private final SeatMapper mapper;



    private final SeatSpecification seatSpecification;

    @Override
    protected SeatMapper getMapper() {
        return mapper;    }

    @Override
    protected SeatEntityRepository getRepository() {
        return seatEntityRepository;
    }

    @Override
    protected SeatSpecification getSpecification() {
        return seatSpecification;
    }
}