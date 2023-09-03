package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.DoctorEntity;
import com.burakcanciftci.healthtourism.database.entity.ExaminationEntity;
import com.burakcanciftci.healthtourism.database.entity.HospitalEntity;
import com.burakcanciftci.healthtourism.database.entity.TravelPlanEntity;
import com.burakcanciftci.healthtourism.database.repository.*;
import com.burakcanciftci.healthtourism.database.specification.ExaminationSpecification;
import com.burakcanciftci.healthtourism.mapper.ExaminationMapper;
import com.burakcanciftci.healthtourism.mapper.HospitalMapper;
import com.burakcanciftci.healthtourism.mapper.MedicalDepartmentMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.ExaminationAddCardRequestDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.ExaminationRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.ExaminationResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ExaminationService extends BaseService<ExaminationEntity, ExaminationResponseDTO, ExaminationRequestDTO> {

    private final ExaminationEntityRepository examinationEntityRepository;
    private final ExaminationMapper examinationMapper;
    private final ExaminationSpecification examinationSpecification;

    private final DoctorEntityRepository doctorEntityRepository;
    private final CustomerEntityRepository customerEntityRepository;

    private final HospitalEntityRepository hospitalEntityRepository;
    private final MedicalDepartmentEntityRepository medicalDepartmentEntityRepository;
    private final ExaminationCardEntityRepository examinationCardEntityRepository;

    private final TravelPlanService travelPlanService;

    @Override
    protected ExaminationMapper getMapper() {
        return this.examinationMapper;
    }

    @Override
    protected ExaminationEntityRepository getRepository() {
        return this.examinationEntityRepository;
    }

    @Override
    protected ExaminationSpecification getSpecification() {
        return examinationSpecification;
    }

    public ExaminationResponseDTO createAppointment(ExaminationRequestDTO examinationRequestDTO) {
        String examinationCode = "";

        if (examinationRequestDTO.getDoctor() != null && examinationRequestDTO.getExaminationTime() != null) {
            examinationCode = ExaminationEntity.generateCode(examinationRequestDTO.getDoctor().getName(),
                    examinationRequestDTO.getExaminationTime().toString());
        }

        // Check if examination is already taken and customer is added to DTO
        if (examinationCode != "" && examinationEntityRepository.findByCode(examinationCode).isEmpty()
                && examinationRequestDTO.getCustomer() != null) {
            ExaminationEntity examinationEntity = new ExaminationEntity();

            DoctorEntity doctor = doctorEntityRepository
                    .findByUuid(examinationRequestDTO.getDoctor().getUuid()).orElse(null);

            examinationEntity.setDoctor(doctor);
            examinationEntity.setCustomer(
                    customerEntityRepository
                            .findByUuid(examinationRequestDTO.getCustomer().getUuid()).orElse(null));

            examinationEntity.setExaminationTime(examinationRequestDTO.getExaminationTime());
            examinationEntity.setCode(examinationCode);

            if(examinationRequestDTO.getHospital() != null){
                examinationEntity.setHospital(
                        hospitalEntityRepository
                                .findByUuid(examinationRequestDTO.getHospital().getUuid()).orElse(null));
            }

            if(examinationRequestDTO.getMedicalDepartment() != null){
                examinationEntity.setMedicalDepartment(
                    medicalDepartmentEntityRepository
                            .findByUuid(examinationRequestDTO.getMedicalDepartment().getUuid()).orElse(null));
            }

            examinationEntityRepository.save(examinationEntity);

            travelPlanService.addExaminationToTravelPlan(examinationEntity);
            return examinationMapper.entityToDTO(examinationEntity);
        }

        return null;
    }

    public ExaminationResponseDTO addCard(UUID uuid, ExaminationAddCardRequestDTO examinationAddCardRequestDTO){
        ExaminationEntity examinationEntity = examinationEntityRepository.findByUuid(uuid).orElse(null);

        if(examinationEntity != null){
            examinationEntity.setExaminationCard(
                    examinationCardEntityRepository
                            .findByUuid(examinationAddCardRequestDTO.getExaminationCardUuid()).orElse(null));

            examinationEntityRepository.save(examinationEntity);
            return examinationMapper.entityToDTO(examinationEntity);
        }

        return null;
    }
}