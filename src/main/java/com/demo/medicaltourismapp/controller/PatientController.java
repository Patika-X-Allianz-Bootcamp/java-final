package com.demo.medicaltourismapp.controller;

import com.demo.medicaltourismapp.database.entity.PatientEntity;
import com.demo.medicaltourismapp.database.repository.PatientRepository;
import com.demo.medicaltourismapp.mapper.PatientMapper;
import com.demo.medicaltourismapp.model.PatientDTO;
import com.demo.medicaltourismapp.model.requestDTO.PatientRequestDTO;
import com.demo.medicaltourismapp.service.PatientService;
import com.demo.medicaltourismapp.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<PatientEntity, PatientDTO, PatientRequestDTO,
        PatientMapper, PatientRepository, PatientService> {
    private final PatientService patientService;


    @Override
    protected PatientService getService() {
        return patientService;
    }
}
