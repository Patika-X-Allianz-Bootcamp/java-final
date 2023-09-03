package com.patika.healthtourism.service;

import com.patika.healthtourism.database.entity.DoctorEntity;
import com.patika.healthtourism.database.repository.DoctorEntityRepository;
import com.patika.healthtourism.mapper.DoctorMapper;
import com.patika.healthtourism.model.DoctorDTO;
import com.patika.healthtourism.model.requestDTO.DoctorCreateRequestDTO;
import com.patika.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends BaseService<DoctorEntity, DoctorDTO, DoctorCreateRequestDTO,
        DoctorMapper, DoctorEntityRepository> {
    private final DoctorEntityRepository doctorEntityRepository;
    private final DoctorMapper doctorMapper;

    public DoctorService(DoctorEntityRepository doctorEntityRepository, DoctorMapper doctorMapper) {
        this.doctorEntityRepository = doctorEntityRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    protected DoctorEntityRepository getRepository() {
        return doctorEntityRepository;
    }
}
