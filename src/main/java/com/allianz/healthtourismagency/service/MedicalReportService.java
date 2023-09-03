package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.MedicalReportEntity;
import com.allianz.healthtourismagency.database.repository.MedicalReportRepository;
import com.allianz.healthtourismagency.database.specification.MedicalReportSpecification;
import com.allianz.healthtourismagency.mapper.MedicalReportMapper;
import com.allianz.healthtourismagency.mapper.MedicationMapper;
import com.allianz.healthtourismagency.mapper.TestResultMapper;
import com.allianz.healthtourismagency.model.MedicalReportDTO;
import com.allianz.healthtourismagency.model.MedicationDTO;
import com.allianz.healthtourismagency.model.TestResultDTO;
import com.allianz.healthtourismagency.model.requestDTO.MedicalReportRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.MedicationRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.TestResultRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MedicalReportService extends BaseService<MedicalReportEntity, MedicalReportDTO, MedicalReportRequestDTO,
        MedicalReportMapper, MedicalReportRepository, MedicalReportSpecification> {

    private final MedicalReportMapper medicalReportMapper;
    private final MedicalReportRepository medicalReportRepository;
    private final MedicalReportSpecification medicalReportSpecification;
    private final MedicationMapper medicationMapper;
    private final TestResultMapper testResultMapper;

    public MedicalReportService(MedicalReportMapper medicalReportMapper, MedicalReportRepository medicalReportRepository,
                                MedicalReportSpecification medicalReportSpecification, MedicationMapper medicationMapper, TestResultMapper testResultMapper) {
        this.medicalReportMapper = medicalReportMapper;
        this.medicalReportRepository = medicalReportRepository;
        this.medicalReportSpecification = medicalReportSpecification;
        this.medicationMapper = medicationMapper;
        this.testResultMapper = testResultMapper;
    }


    @Override
    protected MedicalReportMapper getMapper() {
        return medicalReportMapper;
    }

    @Override
    protected MedicalReportRepository getRepository() {
        return medicalReportRepository;
    }

    @Override
    protected MedicalReportSpecification getSpecification() {
        return medicalReportSpecification;
    }

    @Transactional
    public MedicalReportDTO addMedicationToMedicalReport(UUID uuid, MedicationRequestDTO medicationRequestDTO) {
        MedicalReportEntity medicalReportEntity = getRepository().findByUuid(uuid).orElse(null);
        if (medicalReportEntity != null) {
                MedicalReportDTO medicalReportDTO = getMapper().entityToDto(medicalReportEntity);
                MedicationDTO medicationDTO = medicationMapper.entityToDto(medicationMapper.requestDtoToEntity(medicationRequestDTO));
                medicalReportDTO.getMedicationList().add(medicationDTO);

                medicalReportEntity = getMapper().dtoToEntity(medicalReportDTO);
                getRepository().save(medicalReportEntity);
                return medicalReportDTO;
         } else {
            throw new NullPointerException("Medical report not found.");
        }
    }

    @Transactional
    public MedicalReportDTO addTestResultToMedicalReport(UUID uuid, TestResultRequestDTO testResultRequestDTO) {
        MedicalReportEntity medicalReportEntity = getRepository().findByUuid(uuid).orElse(null);
        if (medicalReportEntity != null) {
            MedicalReportDTO medicalReportDTO = getMapper().entityToDto(medicalReportEntity);
            TestResultDTO testResultDTO = testResultMapper.entityToDto(testResultMapper.requestDtoToEntity(testResultRequestDTO));
            medicalReportDTO.getTestResultList().add(testResultDTO);

            medicalReportEntity = getMapper().dtoToEntity(medicalReportDTO);
            getRepository().save(medicalReportEntity);
            return medicalReportDTO;
        } else {
            throw new NullPointerException("Medical report not found.");
        }
    }
}
