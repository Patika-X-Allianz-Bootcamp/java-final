package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.ReservationEntity;
import com.allianz.medicaltourismapp.database.repository.ReservationEntityRepository;
import com.allianz.medicaltourismapp.database.repository.ReservationEntityRepository;

import com.allianz.medicaltourismapp.database.specification.ReservationSpecification;
import com.allianz.medicaltourismapp.database.specification.ReservationSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.ReservationMapper;
import com.allianz.medicaltourismapp.mapper.ReservationMapper;

import com.allianz.medicaltourismapp.model.ReservationDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService extends BaseService<
        ReservationDTO,
        ReservationEntity,
        ReservationEntityRepository,
        ReservationMapper,
        ReservationSpecification> {

    private final ReservationEntityRepository reservationEntityRepository;
    private final ReservationMapper mapper;



    private final ReservationSpecification reservationSpecification;

    @Override
    protected ReservationMapper getMapper() {
        return mapper;    }

    @Override
    protected ReservationEntityRepository getRepository() {
        return reservationEntityRepository;
    }

    @Override
    protected ReservationSpecification getSpecification() {
        return reservationSpecification;
    }
}
