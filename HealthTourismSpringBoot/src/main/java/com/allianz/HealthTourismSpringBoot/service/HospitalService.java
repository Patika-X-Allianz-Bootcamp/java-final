package com.allianz.HealthTourismSpringBoot.service;

import com.allianz.HealthTourismSpringBoot.database.entities.HospitalEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.HospitalRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.HospitalSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.HospitalMapper;
import com.allianz.HealthTourismSpringBoot.model.HospitalDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.HospitalRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService extends BaseService<
        HospitalEntity,
        HospitalDTO,
        HospitalRequestDTO,
        HospitalMapper,
        HospitalRepository,
        HospitalSpecification> {

    @Autowired
    HospitalMapper hospitalMapper;

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    HospitalSpecification hospitalSpecification;

    @Override
    public HospitalMapper getMapper() {
        return hospitalMapper;
    }

    @Override
    public HospitalRepository getRepository() {
        return hospitalRepository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return hospitalSpecification;
    }
}
