package com.allianz.HealthTourismSpringBoot.service;

import com.allianz.HealthTourismSpringBoot.database.entities.ExaminationEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.ExaminationRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.ExaminationSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.ExaminationMapper;
import com.allianz.HealthTourismSpringBoot.model.ExaminationDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.ExaminationRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExaminationService extends BaseService<
        ExaminationEntity,
        ExaminationDTO,
        ExaminationRequestDTO,
        ExaminationMapper,
        ExaminationRepository,
        ExaminationSpecification> {

    @Autowired
    ExaminationMapper examinationMapper;

    @Autowired
    ExaminationRepository examinationRepository;

    @Autowired
    ExaminationSpecification examinationSpecification;

    @Override
    public ExaminationMapper getMapper() {
        return examinationMapper;
    }

    @Override
    public ExaminationRepository getRepository() {
        return examinationRepository;
    }

    @Override
    protected ExaminationSpecification getSpecification() {
        return examinationSpecification;
    }

}
