package com.demo.medicaltourismapp.service;

import com.demo.medicaltourismapp.database.entity.HospitalEntity;
import com.demo.medicaltourismapp.database.repository.HospitalRepository;
import com.demo.medicaltourismapp.mapper.HospitalMapper;
import com.demo.medicaltourismapp.model.HospitalDTO;
import com.demo.medicaltourismapp.model.requestDTO.HospitalRequestDTO;
import com.demo.medicaltourismapp.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HospitalService extends BaseService<HospitalEntity, HospitalDTO, HospitalRequestDTO,
        HospitalMapper, HospitalRepository> {

    private final HospitalRepository hospitalRepository;
    private final HospitalMapper hospitalMapper;


    @Override
    protected HospitalMapper getMapper() {
        return hospitalMapper;
    }

    @Override
    protected HospitalRepository getRepository() {
        return hospitalRepository;
    }
}
