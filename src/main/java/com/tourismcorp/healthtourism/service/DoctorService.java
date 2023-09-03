package com.tourismcorp.healthtourism.service;

import com.tourismcorp.healthtourism.database.entities.DoctorEntity;
import com.tourismcorp.healthtourism.database.repositories.DoctorRepository;
import com.tourismcorp.healthtourism.database.specification.DoctorSpecification;
import com.tourismcorp.healthtourism.mapper.DoctorMapper;
import com.tourismcorp.healthtourism.model.DoctorDTO;
import com.tourismcorp.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.tourismcorp.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends BaseService<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification> {

    private final DoctorRepository doctorRepository;

    private final DoctorMapper doctorMapper;

    private final DoctorSpecification doctorSpecification;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper, DoctorSpecification doctorSpecification) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
        this.doctorSpecification = doctorSpecification;
    }

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
