package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.database.repository.HotelRepository;
import com.allianz.healthtourism.mapper.HotelMapper;
import com.allianz.healthtourism.model.DTO.HotelDTO;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends BaseService<HotelEntity, HotelDTO, HotelRequestDTO,
        HotelMapper, HotelRepository> {
    private final HotelMapper hotelMapper;
    private final HotelRepository hotelRepository;

    public HotelService(HotelMapper hotelMapper,
                        HotelRepository hotelRepository) {
        this.hotelMapper = hotelMapper;
        this.hotelRepository = hotelRepository;
    }

    @Override
    protected HotelMapper getMapper() {
        return hotelMapper;
    }

    @Override
    protected HotelRepository getRepository() {
        return hotelRepository;
    }
}
