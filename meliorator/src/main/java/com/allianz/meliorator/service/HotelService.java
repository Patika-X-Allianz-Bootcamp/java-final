package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Hotel;
import com.allianz.meliorator.database.repository.HotelRepository;
import com.allianz.meliorator.database.specification.HotelSpecification;
import com.allianz.meliorator.mapper.HotelMapper;
import com.allianz.meliorator.model.dto.HotelDTO;
import com.allianz.meliorator.model.requestDTO.HotelRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends BaseService<Hotel, HotelDTO, HotelRequestDTO,
        HotelMapper, HotelRepository, HotelSpecification> {
    @Autowired
    HotelMapper hotelMapper;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    HotelSpecification hotelSpecification;
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
