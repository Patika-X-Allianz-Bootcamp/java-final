package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Doctor;
import com.allianz.meliorator.database.repository.DoctorRepository;
import com.allianz.meliorator.database.specification.DoctorSpecification;
import com.allianz.meliorator.mapper.DoctorMapper;
import com.allianz.meliorator.model.dto.DoctorDTO;
import com.allianz.meliorator.model.requestDTO.DoctorRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends BaseService<Doctor, DoctorDTO, DoctorRequestDTO,
        DoctorMapper, DoctorRepository, DoctorSpecification> {
    @Autowired
    DoctorSpecification doctorSpecification;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    DoctorRepository doctorRepository;
    @Override
    protected DoctorMapper getMapper() {
        return this.doctorMapper;
    }

    @Override
    protected DoctorRepository getRepository() {
        return this.doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return this.doctorSpecification;
    }
}
