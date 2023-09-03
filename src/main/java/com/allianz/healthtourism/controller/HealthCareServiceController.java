package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.HealthCareServiceEntity;
import com.allianz.healthtourism.database.repository.HealthCareServiceRepository;
import com.allianz.healthtourism.database.specification.HealthCareServiceSpecification;
import com.allianz.healthtourism.mapper.HealthCareServiceMapper;
import com.allianz.healthtourism.model.requestDTO.HealthCareServiceRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HealthCareServiceResponseDTO;
import com.allianz.healthtourism.service.HealthCareServiceService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health-care-service")
@RequiredArgsConstructor
public class HealthCareServiceController extends BaseController<HealthCareServiceRequestDTO, HealthCareServiceResponseDTO, HealthCareServiceEntity, HealthCareServiceMapper, HealthCareServiceRepository, HealthCareServiceSpecification, HealthCareServiceService> {
    private final HealthCareServiceService service;

    @Override
    protected HealthCareServiceService getService() {
        return service;
    }
}
