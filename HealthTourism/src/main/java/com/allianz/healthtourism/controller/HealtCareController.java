package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.HealthCareEntity;
import com.allianz.healthtourism.database.repository.HealthCareRepository;
import com.allianz.healthtourism.mapper.HealthCareMapper;
import com.allianz.healthtourism.model.DTO.HealthCareDTO;
import com.allianz.healthtourism.model.requestDTO.HealthCareRequestDTO;
import com.allianz.healthtourism.service.HealthCareService;
import com.allianz.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("healthcare")
public class HealtCareController extends BaseController<HealthCareEntity, HealthCareDTO, HealthCareRequestDTO,
        HealthCareMapper, HealthCareRepository, HealthCareService> {

    private final HealthCareService healthCareService;

    public HealtCareController(HealthCareService healthCareService) {
        this.healthCareService = healthCareService;
    }

    @Override
    protected HealthCareService getService() {
        return healthCareService;
    }
}
