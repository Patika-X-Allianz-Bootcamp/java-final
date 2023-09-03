package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.MedicalDepartmentEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.MedicalDepartmentRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.MedicalDepartmentResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MedicalDepartmentMapper
        extends BaseMapper<MedicalDepartmentResponseDTO, MedicalDepartmentEntity, MedicalDepartmentRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(MedicalDepartmentEntity.class, MedicalDepartmentResponseDTO.class);
    }
}