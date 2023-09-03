package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.repository.HospitalRepository;
import com.allianz.healthtourism.mapper.HospitalMapper;
import com.allianz.healthtourism.model.DTO.HospitalDTO;
import com.allianz.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class HospitalService extends BaseService<HospitalEntity, HospitalDTO, HospitalRequestDTO,
        HospitalMapper, HospitalRepository> {
    private final HospitalMapper hospitalMapper;
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalMapper hospitalMapper, HospitalRepository hospitalRepository) {
        this.hospitalMapper = hospitalMapper;
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    protected HospitalMapper getMapper() {
        return hospitalMapper;
    }

    @Override
    protected HospitalRepository getRepository() {
        return hospitalRepository;
    }
}
