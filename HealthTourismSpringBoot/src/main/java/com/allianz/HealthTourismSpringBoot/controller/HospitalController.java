package com.allianz.HealthTourismSpringBoot.controller;

import com.allianz.HealthTourismSpringBoot.database.entities.HospitalEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.HospitalRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.HospitalSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.HospitalMapper;
import com.allianz.HealthTourismSpringBoot.model.HospitalDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.HospitalRequestDTO;
import com.allianz.HealthTourismSpringBoot.service.HospitalService;
import com.allianz.HealthTourismSpringBoot.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
public class HospitalController extends BaseController<HospitalEntity,
        HospitalDTO,
        HospitalRequestDTO,
        HospitalMapper,
        HospitalRepository,
        HospitalSpecification,
        HospitalService> {

    @Autowired
    HospitalService hospitalService;

    @Override
    protected HospitalService getService() {
        return hospitalService;
    }
}
