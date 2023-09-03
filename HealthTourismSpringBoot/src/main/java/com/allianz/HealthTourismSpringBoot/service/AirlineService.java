package com.allianz.HealthTourismSpringBoot.service;

import com.allianz.HealthTourismSpringBoot.database.entities.AirlineEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.AirlineRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.AirlineSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.AirlineMapper;
import com.allianz.HealthTourismSpringBoot.model.AirlineDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.AirlineRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService extends BaseService<
        AirlineEntity,
        AirlineDTO,
        AirlineRequestDTO,
        AirlineMapper,
        AirlineRepository,
        AirlineSpecification> {

    @Autowired
    AirlineMapper airlineMapper;

    @Autowired
    AirlineRepository airlineRepository;

    @Autowired
    AirlineSpecification airlineSpecification;

    @Override
    public AirlineMapper getMapper() {
        return airlineMapper;
    }

    @Override
    public AirlineRepository getRepository() {
        return airlineRepository;
    }

    @Override
    protected AirlineSpecification getSpecification() {
        return airlineSpecification;
    }
}
