package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Clinic;
import com.allianz.meliorator.database.repository.ClinicRepository;
import com.allianz.meliorator.database.specification.ClinicSpecification;
import com.allianz.meliorator.mapper.ClinicMapper;
import com.allianz.meliorator.model.dto.ClinicDTO;
import com.allianz.meliorator.model.requestDTO.ClinicRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicService extends BaseService<Clinic, ClinicDTO, ClinicRequestDTO,
        ClinicMapper, ClinicRepository, ClinicSpecification> {
    @Autowired
    ClinicSpecification clinicSpecification;
    @Autowired
    ClinicMapper clinicMapper;
    @Autowired
    ClinicRepository clinicRepository;
    @Override
    protected ClinicMapper getMapper() {
        return this.clinicMapper;
    }

    @Override
    protected ClinicRepository getRepository() {
        return this.clinicRepository;
    }

    @Override
    protected ClinicSpecification getSpecification() {
        return this.clinicSpecification;
    }
}
