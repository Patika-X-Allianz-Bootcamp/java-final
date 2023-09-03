package com.allianz.HealthTourismSpringBoot.controller;

import com.allianz.HealthTourismSpringBoot.database.entities.AirlineEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.AirlineRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.AirlineSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.AirlineMapper;
import com.allianz.HealthTourismSpringBoot.model.AirlineDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.AirlineRequestDTO;
import com.allianz.HealthTourismSpringBoot.service.AirlineService;
import com.allianz.HealthTourismSpringBoot.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airline")
public class AirlineController extends BaseController<AirlineEntity,
        AirlineDTO,
        AirlineRequestDTO,
        AirlineMapper,
        AirlineRepository,
        AirlineSpecification,
        AirlineService> {

    @Autowired
    AirlineService airlineService;

    @Override
    protected AirlineService getService() {
        return airlineService;
    }
}
