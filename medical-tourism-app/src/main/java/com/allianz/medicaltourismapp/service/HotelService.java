package com.allianz.medicaltourismapp.service;

import com.allianz.medicaltourismapp.database.entity.HotelEntity;
import com.allianz.medicaltourismapp.database.repository.HotelEntityRepository;
import com.allianz.medicaltourismapp.database.repository.HotelEntityRepository;

import com.allianz.medicaltourismapp.database.specification.HotelSpecification;
import com.allianz.medicaltourismapp.database.specification.HotelSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.HotelMapper;
import com.allianz.medicaltourismapp.mapper.HotelMapper;

import com.allianz.medicaltourismapp.model.HotelDTO;

import com.allianz.medicaltourismapp.util.BaseService;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HotelService extends BaseService<
        HotelDTO,
        HotelEntity,
        HotelEntityRepository,
        HotelMapper,
        HotelSpecification> {

    private final HotelEntityRepository hotelEntityRepository;


    private final HotelSpecification hotelSpecification;
    private final HotelMapper mapper;


    @Override
    protected HotelMapper getMapper() {
        return mapper;    }

    @Override
    protected HotelEntityRepository getRepository() {
        return hotelEntityRepository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return hotelSpecification;
    }
}