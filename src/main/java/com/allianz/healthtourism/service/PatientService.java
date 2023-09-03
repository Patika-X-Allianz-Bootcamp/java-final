package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.repository.PatientRepository;
import com.allianz.healthtourism.mapper.PatientMapper;
import com.allianz.healthtourism.model.DTO.PatientDTO;
import com.allianz.healthtourism.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<PatientEntity, PatientDTO, PatientRequestDTO,
        PatientMapper, PatientRepository> {
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    public PatientService(PatientMapper patientMapper, PatientRepository patientRepository) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
    }

    @Override
    protected PatientMapper getMapper() {
        return patientMapper;
    }

    @Override
    protected PatientRepository getRepository() {
        return patientRepository;
    }
}
