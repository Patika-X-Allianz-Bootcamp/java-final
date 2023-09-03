package com.allianz.HealthTourismSpringBoot.service;

import com.allianz.HealthTourismSpringBoot.database.entities.DoctorEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.DoctorRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.DoctorSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.DoctorMapper;
import com.allianz.HealthTourismSpringBoot.model.DoctorDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.DoctorRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends BaseService<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification> {

    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorSpecification doctorSpecification;

    @Override
    public DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    public DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return doctorSpecification;
    }
}
