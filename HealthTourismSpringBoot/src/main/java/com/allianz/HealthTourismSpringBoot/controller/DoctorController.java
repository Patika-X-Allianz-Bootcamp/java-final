package com.allianz.HealthTourismSpringBoot.controller;

import com.allianz.HealthTourismSpringBoot.database.entities.DoctorEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.DoctorRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.DoctorSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.DoctorMapper;
import com.allianz.HealthTourismSpringBoot.model.DoctorDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.DoctorRequestDTO;
import com.allianz.HealthTourismSpringBoot.service.DoctorService;
import com.allianz.HealthTourismSpringBoot.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController extends BaseController<DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification,
        DoctorService> {

    @Autowired
    DoctorService doctorService;

    @Override
    protected DoctorService getService() {
        return doctorService;
    }
}
