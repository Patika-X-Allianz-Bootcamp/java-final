package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.PatientEntity;
import com.allianz.medicaltourismapp.database.repository.PatientEntityRepository;
import com.allianz.medicaltourismapp.database.specification.PatientSpecification;
import com.allianz.medicaltourismapp.mapper.PassengerMapper;
import com.allianz.medicaltourismapp.mapper.PatientMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.PatientDTO;
import com.allianz.medicaltourismapp.service.PatientService;

import com.allianz.medicaltourismapp.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("patient")
@RequiredArgsConstructor
public class PatientController extends BaseController<

        PatientEntity,
        PatientDTO,
        PatientMapper,
        PatientEntityRepository,
        PatientSpecification, PatientService
        > {
    @Autowired
    PatientMapper patientMapper;

    @Override
    protected PatientMapper getMapper() {
        return patientMapper;
    }
    @Autowired
    PatientService patientService;
    @Override
    protected PatientService getService() {
        return patientService;
    }
}