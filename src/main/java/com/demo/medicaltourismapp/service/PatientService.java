package com.demo.medicaltourismapp.service;

import com.demo.medicaltourismapp.database.entity.PatientEntity;
import com.demo.medicaltourismapp.database.repository.PatientRepository;
import com.demo.medicaltourismapp.mapper.PatientMapper;
import com.demo.medicaltourismapp.model.PatientDTO;
import com.demo.medicaltourismapp.model.requestDTO.PatientRequestDTO;
import com.demo.medicaltourismapp.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService extends BaseService<PatientEntity, PatientDTO, PatientRequestDTO,
        PatientMapper, PatientRepository> {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    @Override
    protected PatientMapper getMapper() {
        return patientMapper;
    }

    @Override
    protected PatientRepository getRepository() {
        return patientRepository;
    }
}
