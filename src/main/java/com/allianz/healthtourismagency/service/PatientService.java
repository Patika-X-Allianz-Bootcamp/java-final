package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.MedicalReportEntity;
import com.allianz.healthtourismagency.database.entity.PatientEntity;
import com.allianz.healthtourismagency.database.repository.MedicalReportRepository;
import com.allianz.healthtourismagency.database.repository.PatientRepository;
import com.allianz.healthtourismagency.database.specification.PatientSpecification;
import com.allianz.healthtourismagency.mapper.MedicalReportMapper;
import com.allianz.healthtourismagency.mapper.PatientMapper;
import com.allianz.healthtourismagency.model.MedicalReportDTO;
import com.allianz.healthtourismagency.model.PatientDTO;
import com.allianz.healthtourismagency.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PatientService extends BaseService<PatientEntity, PatientDTO, PatientRequestDTO, PatientMapper, PatientRepository,
        PatientSpecification> {

    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;
    private final PatientSpecification patientSpecification;
    private final MedicalReportRepository medicalReportRepository;
    private final MedicalReportMapper medicalReportMapper;

    public PatientService(PatientMapper patientMapper, PatientRepository patientRepository, PatientSpecification patientSpecification, MedicalReportRepository medicalReportRepository, MedicalReportMapper medicalReportMapper) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
        this.patientSpecification = patientSpecification;
        this.medicalReportRepository = medicalReportRepository;
        this.medicalReportMapper = medicalReportMapper;
    }


    @Override
    protected PatientMapper getMapper() {
        return patientMapper;
    }

    @Override
    protected PatientRepository getRepository() {
        return patientRepository;
    }

    @Override
    protected PatientSpecification getSpecification() {
        return patientSpecification;
    }

    @Transactional
    public PatientDTO addMedicalReportToPatient(UUID patientUuid, UUID medicalReportUuid) {
        PatientEntity patientEntity = getRepository().findByUuid(patientUuid).orElse(null);
       MedicalReportEntity medicalReportEntity = medicalReportRepository.findByUuid(medicalReportUuid).orElse(null);

        if (patientEntity != null) {
            PatientDTO patientDTO = getMapper().entityToDto(patientEntity);
            MedicalReportDTO medicalReportDTO = medicalReportMapper.entityToDto(medicalReportEntity);
            patientDTO.getMedicalReportList().add(medicalReportDTO);

            patientEntity = getMapper().dtoToEntity(patientDTO);
            getRepository().save(patientEntity);
            return patientDTO;
        } else {
            return null;
        }
    }
}
