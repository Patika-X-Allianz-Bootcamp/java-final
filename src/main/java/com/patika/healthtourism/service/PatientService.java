package com.patika.healthtourism.service;

import com.patika.healthtourism.database.entity.PatientEntity;
import com.patika.healthtourism.database.repository.PatientEntityRepository;
import com.patika.healthtourism.mapper.PatientMapper;
import com.patika.healthtourism.model.PatientDTO;
import com.patika.healthtourism.model.requestDTO.PatientRequestDTO;
import com.patika.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<PatientEntity, PatientDTO, PatientRequestDTO, PatientMapper, PatientEntityRepository> {
    private final PatientMapper patientMapper;
    private final PatientEntityRepository patientEntityRepository;

    public PatientService(PatientMapper patientMapper, PatientEntityRepository patientEntityRepository) {
        this.patientMapper = patientMapper;
        this.patientEntityRepository = patientEntityRepository;
    }

    @Override
    protected PatientMapper getMapper() {
        return patientMapper;
    }

    @Override
    protected PatientEntityRepository getRepository() {
        return patientEntityRepository;
    }
}
