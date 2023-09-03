package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.City;
import com.allianz.meliorator.database.repository.CityRepository;
import com.allianz.meliorator.mapper.CityMapper;
import com.allianz.meliorator.model.dto.CityDTO;
import com.allianz.meliorator.model.requestDTO.CityRequestDTO;
import com.allianz.meliorator.service.CityService;
import com.allianz.meliorator.util.BaseController;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController extends BaseController<City, CityDTO, CityRequestDTO,
        CityMapper, CityRepository, CityService> {
    @Autowired
    CityService cityService;

    @Override
    protected CityService getService() {
        return this.cityService;
    }
}
