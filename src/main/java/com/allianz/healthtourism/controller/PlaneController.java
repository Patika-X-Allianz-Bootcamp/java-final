package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.database.repository.PlaneRepository;
import com.allianz.healthtourism.database.specification.PlaneSpecification;
import com.allianz.healthtourism.mapper.PlaneMapper;
import com.allianz.healthtourism.model.requestDTO.PlaneRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneResponseDTO;
import com.allianz.healthtourism.service.PlaneService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("plane")
@RequiredArgsConstructor
public class PlaneController extends BaseController<PlaneRequestDTO, PlaneResponseDTO, PlaneEntity, PlaneMapper, PlaneRepository, PlaneSpecification, PlaneService> {
    private final PlaneService service;

    @Override
    protected PlaneService getService() {
        return service;
    }
}
