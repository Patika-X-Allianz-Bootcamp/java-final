package com.allianz.HealthTourismSpringBoot.controller;

import com.allianz.HealthTourismSpringBoot.database.entities.PlaneEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.PlaneRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.PlaneSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.PlaneMapper;
import com.allianz.HealthTourismSpringBoot.model.PlaneDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.PlaneRequestDTO;
import com.allianz.HealthTourismSpringBoot.service.PlaneService;
import com.allianz.HealthTourismSpringBoot.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plane")
public class PlaneController extends BaseController<PlaneEntity,
        PlaneDTO,
        PlaneRequestDTO,
        PlaneMapper,
        PlaneRepository,
        PlaneSpecification,
        PlaneService> {
    @Autowired
    PlaneService planeService;

    @Override
    protected PlaneService getService() {
        return planeService;
    }
}
