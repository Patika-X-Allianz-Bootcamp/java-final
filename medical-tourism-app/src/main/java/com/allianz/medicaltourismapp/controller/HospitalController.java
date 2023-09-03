package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.HospitalEntity;
import com.allianz.medicaltourismapp.database.repository.HospitalEntityRepository;
import com.allianz.medicaltourismapp.database.specification.HospitalSpecification;
import com.allianz.medicaltourismapp.mapper.HospitalMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.HospitalDTO;
import com.allianz.medicaltourismapp.service.HospitalService;
import com.allianz.medicaltourismapp.util.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController<
        
        HospitalEntity,
        HospitalDTO,
        HospitalMapper,
        HospitalEntityRepository,
        HospitalSpecification, HospitalService
        > {

    @Autowired
    HospitalMapper hospitalMapper;

    @Override
    protected HospitalMapper getMapper() {
        return hospitalMapper;
    }
    @Autowired
    HospitalService hospitalService;
    @Override
    protected HospitalService getService() {
        return hospitalService;
    }
}