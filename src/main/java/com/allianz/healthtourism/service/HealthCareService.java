package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.HealthCareEntity;
import com.allianz.healthtourism.database.repository.HealthCareRepository;
import com.allianz.healthtourism.mapper.HealthCareMapper;
import com.allianz.healthtourism.model.DTO.HealthCareDTO;
import com.allianz.healthtourism.model.requestDTO.HealthCareRequestDTO;
import com.allianz.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class HealthCareService extends BaseService<HealthCareEntity, HealthCareDTO, HealthCareRequestDTO,
        HealthCareMapper, HealthCareRepository> {

    private final HealthCareMapper healthCareMapper;

    private final HealthCareRepository healthCareRepository;

    public HealthCareService(HealthCareMapper healthCareMapper, HealthCareRepository healthCareRepository) {
        this.healthCareMapper = healthCareMapper;
        this.healthCareRepository = healthCareRepository;
    }

    @Override
    protected HealthCareMapper getMapper() {
        return healthCareMapper;
    }

    @Override
    protected HealthCareRepository getRepository() {
        return healthCareRepository;
    }
}
