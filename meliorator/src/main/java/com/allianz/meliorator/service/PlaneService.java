package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Plane;
import com.allianz.meliorator.database.repository.PlaneRepository;
import com.allianz.meliorator.database.specification.PlaneSpecification;
import com.allianz.meliorator.mapper.PlaneMapper;
import com.allianz.meliorator.model.dto.PlaneDTO;
import com.allianz.meliorator.model.requestDTO.PlaneRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService extends BaseService<Plane, PlaneDTO, PlaneRequestDTO,
        PlaneMapper, PlaneRepository, PlaneSpecification> {
    @Autowired
    PlaneSpecification planeSpecification;
    @Autowired
    PlaneMapper planeMapper;
    @Autowired
    PlaneRepository planeRepository;
    @Override
    protected PlaneMapper getMapper() {
        return this.planeMapper;
    }

    @Override
    protected PlaneRepository getRepository() {
        return this.planeRepository;
    }

    @Override
    protected PlaneSpecification getSpecification() {
        return this.planeSpecification;
    }
}
