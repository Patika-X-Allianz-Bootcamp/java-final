package com.allianz.HealthTourismSpringBoot.controller;

import com.allianz.HealthTourismSpringBoot.database.entities.AgencyEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.AgencyRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.AgencySpecification;
import com.allianz.HealthTourismSpringBoot.mapper.AgencyMapper;
import com.allianz.HealthTourismSpringBoot.model.AgencyDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.AgencyRequestDTO;
import com.allianz.HealthTourismSpringBoot.service.AgencyService;
import com.allianz.HealthTourismSpringBoot.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agency")
public class AgencyController extends BaseController<AgencyEntity,
        AgencyDTO,
        AgencyRequestDTO,
        AgencyMapper,
        AgencyRepository,
        AgencySpecification,
        AgencyService> {

    @Autowired
    AgencyService agencyService;

    @Override
    protected AgencyService getService() {
        return agencyService;
    }
}
