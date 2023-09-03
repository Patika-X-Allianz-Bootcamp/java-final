package com.tourismcorp.healthtourism.service;

import com.tourismcorp.healthtourism.database.entities.HospitalEntity;
import com.tourismcorp.healthtourism.database.repositories.HospitalRepository;
import com.tourismcorp.healthtourism.database.specification.HospitalSpecification;
import com.tourismcorp.healthtourism.mapper.HospitalMapper;
import com.tourismcorp.healthtourism.model.HospitalDTO;
import com.tourismcorp.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.tourismcorp.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService extends BaseService<
        HospitalEntity,
        HospitalDTO,
        HospitalRequestDTO,
        HospitalMapper,
        HospitalRepository,
        HospitalSpecification> {


    private final HospitalRepository hospitalRepository;

    private final HospitalMapper hospitalMapper;

    private final HospitalSpecification hospitalSpecification;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository, HospitalMapper hospitalMapper, HospitalSpecification hospitalSpecification) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalMapper = hospitalMapper;
        this.hospitalSpecification = hospitalSpecification;
    }

    @Override
    protected HospitalMapper getMapper() {
        return this.hospitalMapper;
    }

    @Override
    protected HospitalRepository getRepository() {
        return this.hospitalRepository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return this.hospitalSpecification;
    }
}
