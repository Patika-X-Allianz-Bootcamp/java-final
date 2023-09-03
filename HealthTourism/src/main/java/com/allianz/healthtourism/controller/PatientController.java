package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.repository.PatientRepository;
import com.allianz.healthtourism.mapper.PatientMapper;
import com.allianz.healthtourism.model.DTO.PatientDTO;
import com.allianz.healthtourism.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourism.service.PatientService;
import com.allianz.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<PatientEntity, PatientDTO, PatientRequestDTO,
        PatientMapper, PatientRepository, PatientService> {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    protected PatientService getService() {
        return patientService;
    }
}
