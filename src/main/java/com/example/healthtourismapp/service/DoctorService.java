package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.DoctorEntity;
import com.example.healthtourismapp.database.repositories.DoctorRepository;
import com.example.healthtourismapp.database.specification.DoctorSpecification;
import com.example.healthtourismapp.mapper.DoctorMapper;
import com.example.healthtourismapp.model.DoctorDTO;
import com.example.healthtourismapp.model.requestDTO.DoctorRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends BaseService<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository, DoctorSpecification> {

    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;
    private final DoctorSpecification doctorSpecification;

    public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository, DoctorSpecification doctorSpecification) {
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
        this.doctorSpecification = doctorSpecification;
    }


    @Override
    public DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    public DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return doctorSpecification;
    }
}
