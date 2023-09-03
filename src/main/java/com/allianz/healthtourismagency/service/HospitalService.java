package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.HospitalEntity;
import com.allianz.healthtourismagency.database.repository.HospitalRepository;
import com.allianz.healthtourismagency.database.specification.HospitalSpecification;
import com.allianz.healthtourismagency.mapper.HospitalMapper;
import com.allianz.healthtourismagency.model.HospitalDTO;
import com.allianz.healthtourismagency.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class HospitalService extends BaseService<HospitalEntity, HospitalDTO, HospitalRequestDTO, HospitalMapper,
        HospitalRepository, HospitalSpecification> {

    private final HospitalMapper hospitalMapper;
    private final HospitalRepository hospitalRepository;
    private final HospitalSpecification hospitalSpecification;

    public HospitalService(HospitalMapper hospitalMapper, HospitalRepository hospitalRepository, HospitalSpecification hospitalSpecification) {
        this.hospitalMapper = hospitalMapper;
        this.hospitalRepository = hospitalRepository;
        this.hospitalSpecification = hospitalSpecification;
    }


    @Override
    protected HospitalMapper getMapper() {
        return hospitalMapper;
    }

    @Override
    protected HospitalRepository getRepository() {
        return hospitalRepository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return hospitalSpecification;
    }
}
