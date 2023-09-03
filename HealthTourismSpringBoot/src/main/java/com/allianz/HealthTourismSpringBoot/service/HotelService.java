package com.allianz.HealthTourismSpringBoot.service;

import com.allianz.HealthTourismSpringBoot.database.entities.HotelEntity;
import com.allianz.HealthTourismSpringBoot.database.repositories.HotelRepository;
import com.allianz.HealthTourismSpringBoot.database.specification.HotelSpecification;
import com.allianz.HealthTourismSpringBoot.mapper.HotelMapper;
import com.allianz.HealthTourismSpringBoot.model.HotelDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.HotelRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends BaseService<
        HotelEntity,
        HotelDTO,
        HotelRequestDTO,
        HotelMapper,
        HotelRepository,
        HotelSpecification> {

    @Autowired
    HotelMapper hotelMapper;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelSpecification hotelSpecification;

    @Override
    public HotelMapper getMapper() {
        return hotelMapper;
    }

    @Override
    public HotelRepository getRepository() {
        return hotelRepository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return hotelSpecification;
    }
}
