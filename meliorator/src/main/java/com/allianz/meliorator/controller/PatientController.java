package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Patient;
import com.allianz.meliorator.database.repository.PatientRepository;
import com.allianz.meliorator.mapper.PatientMapper;
import com.allianz.meliorator.model.dto.PatientDTO;
import com.allianz.meliorator.model.requestDTO.PatientRequestDTO;
import com.allianz.meliorator.service.PatientService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController extends BaseController<Patient, PatientDTO, PatientRequestDTO,
        PatientMapper, PatientRepository, PatientService> {
    @Autowired
    PatientService patientService;
    @Override
    protected PatientService getService() {
        return this.patientService;
    }
}
