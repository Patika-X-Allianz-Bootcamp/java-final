package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.entity.HealthCareServiceEntity;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.database.repository.HealthCareServiceRepository;
import com.allianz.healthtourism.database.specification.FlightSpecification;
import com.allianz.healthtourism.database.specification.HealthCareServiceSpecification;
import com.allianz.healthtourism.mapper.FlightMapper;
import com.allianz.healthtourism.mapper.HealthCareServiceMapper;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.model.requestDTO.HealthCareServiceRequestDTO;
import com.allianz.healthtourism.model.responseDTO.FlightResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HealthCareServiceResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HealthCareServiceService extends BaseService<HealthCareServiceResponseDTO, HealthCareServiceRequestDTO, HealthCareServiceEntity, HealthCareServiceMapper, HealthCareServiceRepository, HealthCareServiceSpecification> {
    private final HealthCareServiceRepository repository;
    private final HealthCareServiceSpecification specification;
    @Override
    protected HealthCareServiceMapper getMapper() {
        return HealthCareServiceMapper.INSTANCE;
    }
    @Override
    protected HealthCareServiceRepository getRepository() {
        return repository;
    }
    @Override
    protected HealthCareServiceSpecification getSpecification() {
        return specification;
    }
}
