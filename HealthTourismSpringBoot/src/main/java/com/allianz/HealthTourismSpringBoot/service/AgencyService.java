package com.allianz.HealthTourismSpringBoot.service;

import com.allianz.HealthTourismSpringBoot.database.entities.AgencyEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.AgencyRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.AgencySpecification;
import com.allianz.HealthTourismSpringBoot.mapper.AgencyMapper;
import com.allianz.HealthTourismSpringBoot.model.AgencyDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.AgencyRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgencyService extends BaseService<
        AgencyEntity,
        AgencyDTO,
        AgencyRequestDTO,
        AgencyMapper,
        AgencyRepository,
        AgencySpecification> {

    @Autowired
    private AgencyMapper agencyMapper;

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private AgencySpecification agencySpecification;

    @Override
    public AgencyMapper getMapper() {
        return agencyMapper;
    }

    @Override
    public AgencyRepository getRepository() {
        return agencyRepository;
    }

    @Override
    protected AgencySpecification getSpecification() {
        return agencySpecification;
    }
}
