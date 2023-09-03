package com.tourismcorp.healthtourism.service;

import com.tourismcorp.healthtourism.database.entities.HotelEntity;
import com.tourismcorp.healthtourism.database.repositories.HotelRepository;
import com.tourismcorp.healthtourism.database.specification.HotelSpecification;
import com.tourismcorp.healthtourism.mapper.HotelMapper;
import com.tourismcorp.healthtourism.model.HotelDTO;
import com.tourismcorp.healthtourism.model.requestDTO.HotelRequestDTO;
import com.tourismcorp.healthtourism.util.BaseService;
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


    private final HotelRepository hotelRepository;

    private final HotelMapper hotelMapper;

    private final HotelSpecification hotelSpecification;

    @Autowired
    public HotelService(HotelRepository hotelRepository, HotelMapper hotelMapper, HotelSpecification hotelSpecification) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
        this.hotelSpecification = hotelSpecification;
    }

    @Override
    protected HotelMapper getMapper() {
        return this.hotelMapper;
    }

    @Override
    protected HotelRepository getRepository() {
        return this.hotelRepository;
    }

    @Override
    protected HotelSpecification getSpecification() {
        return this.hotelSpecification;
    }

}
