package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.DoctorEntity;
import com.allianz.medicaltourismapp.database.repository.DoctorEntityRepository;
import com.allianz.medicaltourismapp.database.repository.DoctorEntityRepository;

import com.allianz.medicaltourismapp.database.specification.DoctorSpecification;
import com.allianz.medicaltourismapp.database.specification.DoctorSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.DoctorMapper;
import com.allianz.medicaltourismapp.mapper.DoctorMapper;

import com.allianz.medicaltourismapp.model.DoctorDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DoctorService extends BaseService<
        DoctorDTO,
        DoctorEntity,
        DoctorEntityRepository,
        DoctorMapper,
        DoctorSpecification> {

    private final DoctorEntityRepository doctorEntityRepository;


    private final DoctorSpecification doctorSpecification;
    private final DoctorMapper mapper;


    @Override
    protected DoctorMapper getMapper() {
        return mapper;    }

    @Override
    protected DoctorEntityRepository getRepository() {
        return doctorEntityRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return doctorSpecification;
    }
}