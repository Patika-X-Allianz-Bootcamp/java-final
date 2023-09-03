package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.AirlineCompanyEntity;
import com.tourismcorp.healthtourism.database.repositories.AirlineCompanyRepository;
import com.tourismcorp.healthtourism.database.specification.AirlineCompanySpecification;
import com.tourismcorp.healthtourism.mapper.AirlineCompanyMapper;
import com.tourismcorp.healthtourism.model.AirlineCompanyDTO;
import com.tourismcorp.healthtourism.model.requestDTO.AirlineCompanyRequestDTO;
import com.tourismcorp.healthtourism.service.AirlineCompanyService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("airline-company")
public class AirlineCompanyController extends BaseController<
        AirlineCompanyEntity,
        AirlineCompanyDTO,
        AirlineCompanyRequestDTO,
        AirlineCompanyMapper,
        AirlineCompanyRepository,
        AirlineCompanySpecification,
        AirlineCompanyService> {

    private final AirlineCompanyService airlineCompanyService;

    @Autowired
    public AirlineCompanyController(AirlineCompanyService airlineCompanyService) {
        this.airlineCompanyService = airlineCompanyService;
    }

    @Override
    protected AirlineCompanyService getService() {
        return airlineCompanyService;
    }
}
