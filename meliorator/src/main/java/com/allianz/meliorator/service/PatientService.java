package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Patient;
import com.allianz.meliorator.database.repository.PatientRepository;
import com.allianz.meliorator.database.specification.PatientSpecification;
import com.allianz.meliorator.mapper.PatientMapper;
import com.allianz.meliorator.model.dto.PatientDTO;
import com.allianz.meliorator.model.requestDTO.PatientRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<Patient, PatientDTO, PatientRequestDTO, PatientMapper,
        PatientRepository, PatientSpecification> {
    @Autowired
    PatientSpecification patientSpecification;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    PatientRepository patientRepository;

    @Override
    protected PatientMapper getMapper() {
        return this.patientMapper;
    }

    @Override
    protected PatientRepository getRepository() {
        return this.patientRepository;
    }

    @Override
    protected PatientSpecification getSpecification() {
        return this.patientSpecification;
    }
}
