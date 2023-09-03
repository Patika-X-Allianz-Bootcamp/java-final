package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.GuestEntity;
import com.allianz.medicaltourismapp.database.repository.GuestEntityRepository;
import com.allianz.medicaltourismapp.database.repository.GuestEntityRepository;

import com.allianz.medicaltourismapp.database.specification.GuestSpecification;
import com.allianz.medicaltourismapp.database.specification.GuestSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.GuestMapper;
import com.allianz.medicaltourismapp.mapper.GuestMapper;

import com.allianz.medicaltourismapp.model.GuestDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GuestService extends BaseService<
        GuestDTO,
        GuestEntity,
        GuestEntityRepository,
        GuestMapper,
        GuestSpecification> {

    private final GuestEntityRepository guestEntityRepository;
    private final GuestMapper mapper;



    private final GuestSpecification guestSpecification;

    @Override
    protected GuestMapper getMapper() {
        return mapper;    }
    @Override
    protected GuestEntityRepository getRepository() {
        return guestEntityRepository;
    }

    @Override
    protected GuestSpecification getSpecification() {
        return guestSpecification;
    }
}