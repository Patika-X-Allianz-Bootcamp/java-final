package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.repository.CityRepository;
import com.allianz.healthtourism.mapper.CityMapper;
import com.allianz.healthtourism.model.DTO.CityDTO;
import com.allianz.healthtourism.model.requestDTO.CityRequestDTO;
import com.allianz.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CityService extends BaseService<CityEntity, CityDTO, CityRequestDTO, CityMapper, CityRepository> {

    private final CityRepository cityRepository;

    private final CityMapper cityMapper;

    public CityService(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    protected CityMapper getMapper() {
        return cityMapper;
    }

    @Override
    protected CityRepository getRepository() {
        return cityRepository;
    }
}
