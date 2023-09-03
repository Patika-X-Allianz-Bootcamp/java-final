package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.HospitalEntity;
import com.burakcanciftci.healthtourism.database.repository.HospitalEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.HospitalSpecification;
import com.burakcanciftci.healthtourism.mapper.HospitalMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.HospitalResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HospitalService extends BaseService<HospitalEntity, HospitalResponseDTO, HospitalRequestDTO> {

    private final HospitalEntityRepository hospitalEntityRepository;
    private final HospitalMapper hospitalMapper;
    private final HospitalSpecification hospitalSpecification;

    @Override
    protected HospitalMapper getMapper() {
        return this.hospitalMapper;
    }

    @Override
    protected HospitalEntityRepository getRepository() {
        return this.hospitalEntityRepository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return hospitalSpecification;
    }
}