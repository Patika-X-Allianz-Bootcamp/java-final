package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.MedicalDepartmentEntity;
import com.burakcanciftci.healthtourism.database.repository.MedicalDepartmentEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.MedicalDepartmentSpecification;
import com.burakcanciftci.healthtourism.mapper.MedicalDepartmentMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.MedicalDepartmentRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.MedicalDepartmentResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MedicalDepartmentService extends BaseService<MedicalDepartmentEntity, MedicalDepartmentResponseDTO, MedicalDepartmentRequestDTO> {

    private final MedicalDepartmentEntityRepository medicalDepartmentEntityRepository;
    private final MedicalDepartmentMapper medicalDepartmentMapper;
    private final MedicalDepartmentSpecification medicalDepartmentSpecification;

    @Override
    protected MedicalDepartmentMapper getMapper() {
        return this.medicalDepartmentMapper;
    }

    @Override
    protected MedicalDepartmentEntityRepository getRepository() {
        return this.medicalDepartmentEntityRepository;
    }

    @Override
    protected MedicalDepartmentSpecification getSpecification() {
        return medicalDepartmentSpecification;
    }
}