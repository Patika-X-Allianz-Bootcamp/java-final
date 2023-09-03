package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Hospital;
import com.allianz.meliorator.database.repository.HospitalRepository;
import com.allianz.meliorator.database.specification.HospitalSpecification;
import com.allianz.meliorator.mapper.HospitalMapper;
import com.allianz.meliorator.model.dto.HospitalDTO;
import com.allianz.meliorator.model.requestDTO.HospitalRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService extends BaseService<Hospital, HospitalDTO, HospitalRequestDTO,
        HospitalMapper, HospitalRepository, HospitalSpecification> {
    @Autowired
    HospitalSpecification hospitalSpecification;
    @Autowired
    HospitalMapper hospitalMapper;
    @Autowired
    HospitalRepository hospitalRepository;
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
