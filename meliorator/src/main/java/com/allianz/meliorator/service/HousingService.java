package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Housing;
import com.allianz.meliorator.database.repository.HousingRepository;
import com.allianz.meliorator.database.specification.HousingSpecification;
import com.allianz.meliorator.mapper.HousingMapper;
import com.allianz.meliorator.model.dto.HousingDTO;
import com.allianz.meliorator.model.requestDTO.HousingRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HousingService extends BaseService<Housing, HousingDTO, HousingRequestDTO,
        HousingMapper, HousingRepository, HousingSpecification> {
    @Autowired
    HousingSpecification housingSpecification;
    @Autowired
    HousingMapper housingMapper;
    @Autowired
    HousingRepository housingRepository;
    @Override
    protected HousingMapper getMapper() {
        return this.housingMapper;
    }
    @Override
    protected HousingRepository getRepository() {
        return this.housingRepository;
    }

    @Override
    protected HousingSpecification getSpecification() {
        return this.housingSpecification;
    }
}
