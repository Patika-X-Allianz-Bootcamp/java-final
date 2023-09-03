package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.RoomEntity;
import com.allianz.medicaltourismapp.database.repository.RoomEntityRepository;
import com.allianz.medicaltourismapp.database.repository.RoomEntityRepository;

import com.allianz.medicaltourismapp.database.specification.RoomSpecification;
import com.allianz.medicaltourismapp.database.specification.RoomSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.RoomMapper;
import com.allianz.medicaltourismapp.mapper.RoomMapper;

import com.allianz.medicaltourismapp.model.RoomDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService extends BaseService<
        RoomDTO,
        RoomEntity,
        RoomEntityRepository,
        RoomMapper,
        RoomSpecification> {

    private final RoomEntityRepository roomEntityRepository;


    private final RoomSpecification roomSpecification;
    private final RoomMapper mapper;


    @Override
    protected RoomMapper getMapper() {
        return mapper;    }

    @Override
    protected RoomEntityRepository getRepository() {
        return roomEntityRepository;
    }

    @Override
    protected RoomSpecification getSpecification() {
        return roomSpecification;
    }
}