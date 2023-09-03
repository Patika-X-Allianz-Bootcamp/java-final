package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.City;
import com.allianz.meliorator.database.repository.CityRepository;
import com.allianz.meliorator.database.specification.CitySpecification;
import com.allianz.meliorator.mapper.CityMapper;
import com.allianz.meliorator.model.dto.CityDTO;
import com.allianz.meliorator.model.requestDTO.CityRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService extends BaseService<City, CityDTO, CityRequestDTO, CityMapper, CityRepository, CitySpecification> {

    @Autowired
    CitySpecification citySpecification;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    CityRepository cityRepository;
    @Override
    protected CityMapper getMapper() {
        return this.cityMapper;
    }

    @Override
    protected CityRepository getRepository() {
        return this.cityRepository;
    }

    @Override
    protected CitySpecification getSpecification() {
        return null;
    }
}
