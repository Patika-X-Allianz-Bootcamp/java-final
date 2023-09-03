package com.patika.healthtourism.controller;

import com.patika.healthtourism.database.entity.PatientEntity;
import com.patika.healthtourism.database.repository.PatientEntityRepository;
import com.patika.healthtourism.mapper.PatientMapper;
import com.patika.healthtourism.model.PatientDTO;
import com.patika.healthtourism.model.requestDTO.PatientRequestDTO;
import com.patika.healthtourism.service.PatientService;
import com.patika.healthtourism.util.BaseController;
import com.patika.healthtourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController extends BaseController<PatientEntity, PatientDTO, PatientRequestDTO,
        PatientMapper, PatientEntityRepository, PatientService> {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    protected PatientService getService() {
        return patientService;
    }
}
