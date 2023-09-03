package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.*;
import com.allianz.healthtourism.database.repository.PatientRepository;
import com.allianz.healthtourism.database.repository.PlaneRepository;
import com.allianz.healthtourism.database.specification.PatientSpecification;
import com.allianz.healthtourism.database.specification.PlaneSpecification;
import com.allianz.healthtourism.mapper.PatientMapper;
import com.allianz.healthtourism.mapper.PlaneMapper;
import com.allianz.healthtourism.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourism.model.requestDTO.PlaneRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PlaneService extends BaseService<PlaneResponseDTO, PlaneRequestDTO, PlaneEntity, PlaneMapper, PlaneRepository, PlaneSpecification> {
    private final PlaneRepository repository;
    private final PlaneSpecification specification;

    @Override
    protected PlaneMapper getMapper() {
        return PlaneMapper.INSTANCE;
    }

    @Override
    protected PlaneRepository getRepository() {
        return repository;
    }

    @Override
    protected PlaneSpecification getSpecification() {
        return specification;
    }

    public PlaneEntity findById(Long id){
        return getRepository().findById(id).orElse(null);
    }


}
