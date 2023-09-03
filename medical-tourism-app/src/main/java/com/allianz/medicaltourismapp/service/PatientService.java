package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.PatientEntity;
import com.allianz.medicaltourismapp.database.repository.PatientEntityRepository;
import com.allianz.medicaltourismapp.database.repository.PatientEntityRepository;

import com.allianz.medicaltourismapp.database.specification.PatientSpecification;
import com.allianz.medicaltourismapp.database.specification.PatientSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.PatientMapper;
import com.allianz.medicaltourismapp.mapper.PatientMapper;

import com.allianz.medicaltourismapp.model.PatientDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PatientService extends BaseService<
        PatientDTO,
        PatientEntity,
        PatientEntityRepository,
        PatientMapper,
        PatientSpecification> {
    private final PatientEntityRepository patientEntityRepository;


    private final PatientSpecification patientSpecification;
    private final PatientMapper mapper;


    @Override
    protected PatientMapper getMapper() {
        return mapper;    }

    @Override
    protected PatientEntityRepository getRepository() {
        return patientEntityRepository;
    }

    @Override
    protected PatientSpecification getSpecification() {
        return patientSpecification;
    }
}