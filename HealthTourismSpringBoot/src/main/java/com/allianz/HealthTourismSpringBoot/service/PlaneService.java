package com.allianz.HealthTourismSpringBoot.service;

import com.allianz.HealthTourismSpringBoot.database.entities.PlaneEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.PlaneRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.PlaneSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.PlaneMapper;
import com.allianz.HealthTourismSpringBoot.model.PlaneDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.PlaneRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService extends BaseService<
        PlaneEntity,
        PlaneDTO,
        PlaneRequestDTO,
        PlaneMapper,
        PlaneRepository,
        PlaneSpecification> {

    @Autowired
    PlaneMapper planeMapper;

    @Autowired
    PlaneRepository planeRepository;

    @Autowired
    PlaneSpecification planeSpecification;

    @Override
    public PlaneMapper getMapper() {
        return planeMapper;
    }

    @Override
    public PlaneRepository getRepository() {
        return planeRepository;
    }

    @Override
    protected PlaneSpecification getSpecification() {
        return planeSpecification;
    }
}
