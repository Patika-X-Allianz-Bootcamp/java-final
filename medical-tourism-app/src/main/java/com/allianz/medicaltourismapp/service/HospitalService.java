package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.HospitalEntity;
import com.allianz.medicaltourismapp.database.repository.HospitalEntityRepository;
import com.allianz.medicaltourismapp.database.repository.HospitalEntityRepository;

import com.allianz.medicaltourismapp.database.specification.HospitalSpecification;
import com.allianz.medicaltourismapp.database.specification.HospitalSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.HospitalMapper;
import com.allianz.medicaltourismapp.mapper.HospitalMapper;

import com.allianz.medicaltourismapp.model.HospitalDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HospitalService extends BaseService<
        HospitalDTO,
        HospitalEntity,
        HospitalEntityRepository,
        HospitalMapper,
        HospitalSpecification> {

    private final HospitalEntityRepository hospitalEntityRepository;


    private final HospitalSpecification hospitalSpecification;
    private final HospitalMapper mapper;


    @Override
    protected HospitalMapper getMapper() {
        return mapper;    }

    @Override
    protected HospitalEntityRepository getRepository() {
        return hospitalEntityRepository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return hospitalSpecification;
    }
}