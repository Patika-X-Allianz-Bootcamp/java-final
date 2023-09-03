package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.DoctorEntity;
import com.burakcanciftci.healthtourism.database.repository.DoctorEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.DoctorSpecification;
import com.burakcanciftci.healthtourism.mapper.DoctorMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.DoctorResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DoctorService extends BaseService<DoctorEntity, DoctorResponseDTO, DoctorRequestDTO> {

    private final DoctorEntityRepository doctorEntityRepository;
    private final DoctorMapper doctorMapper;
    private final DoctorSpecification doctorSpecification;

    @Override
    protected DoctorMapper getMapper() {
        return this.doctorMapper;
    }

    @Override
    protected DoctorEntityRepository getRepository() {
        return this.doctorEntityRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return doctorSpecification;
    }
}