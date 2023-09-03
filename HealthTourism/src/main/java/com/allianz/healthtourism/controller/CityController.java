package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.repository.CityRepository;
import com.allianz.healthtourism.mapper.CityMapper;
import com.allianz.healthtourism.model.DTO.CityDTO;
import com.allianz.healthtourism.model.requestDTO.CityRequestDTO;
import com.allianz.healthtourism.service.CityService;
import com.allianz.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("city")
public class CityController extends BaseController<CityEntity, CityDTO, CityRequestDTO, CityMapper,
        CityRepository, CityService> {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    protected CityService getService() {
        return cityService;
    }
}
