package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.DoctorEntity;
import com.allianz.medicaltourismapp.database.repository.DoctorEntityRepository;
import com.allianz.medicaltourismapp.database.specification.DoctorSpecification;
import com.allianz.medicaltourismapp.mapper.DoctorMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.DoctorDTO;
import com.allianz.medicaltourismapp.service.DoctorService;
import com.allianz.medicaltourismapp.util.BaseController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("doctor")
@RequiredArgsConstructor
public class DoctorController extends BaseController<
        DoctorEntity,
        DoctorDTO,
        DoctorMapper,
        DoctorEntityRepository,
        DoctorSpecification, DoctorService
        > {

    @Autowired
    DoctorMapper doctorMapper;
    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Autowired
    DoctorService doctorService;
    @Override
    protected DoctorService getService() {
        return doctorService;
    }
}