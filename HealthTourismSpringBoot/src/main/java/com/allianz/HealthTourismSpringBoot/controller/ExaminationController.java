package com.allianz.HealthTourismSpringBoot.controller;

import com.allianz.HealthTourismSpringBoot.database.entities.ExaminationEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.ExaminationRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.ExaminationSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.ExaminationMapper;
import com.allianz.HealthTourismSpringBoot.model.ExaminationDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.ExaminationRequestDTO;
import com.allianz.HealthTourismSpringBoot.service.ExaminationService;
import com.allianz.HealthTourismSpringBoot.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examination")
public class ExaminationController extends BaseController<ExaminationEntity,
        ExaminationDTO,
        ExaminationRequestDTO,
        ExaminationMapper,
        ExaminationRepository,
        ExaminationSpecification,
        ExaminationService> {

    @Autowired
    ExaminationService examinationService;

    @Override
    protected ExaminationService getService() {
        return examinationService;
    }
}
