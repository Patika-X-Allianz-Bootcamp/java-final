package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.PatientEntity;
import com.example.healthtourismapp.database.repositories.PatientRepository;
import com.example.healthtourismapp.database.specification.PatientSpecification;
import com.example.healthtourismapp.mapper.PatientMapper;
import com.example.healthtourismapp.model.PatientDTO;
import com.example.healthtourismapp.model.requestDTO.PatientRequestDTO;
import com.example.healthtourismapp.service.PatientService;
import com.example.healthtourismapp.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController extends BaseController<PatientEntity, PatientDTO, PatientRequestDTO,
        PatientMapper, PatientRepository, PatientSpecification, PatientService> {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    protected PatientService getService() {
        return patientService;
    }
}
