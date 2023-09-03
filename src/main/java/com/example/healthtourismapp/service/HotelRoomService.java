package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.HotelRoomEntity;
import com.example.healthtourismapp.database.repositories.HotelRoomRepository;
import com.example.healthtourismapp.database.specification.HotelRoomSpecification;
import com.example.healthtourismapp.mapper.HotelRoomMapper;
import com.example.healthtourismapp.model.HotelRoomDTO;
import com.example.healthtourismapp.model.requestDTO.HotelRoomRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class HotelRoomService extends BaseService<
        HotelRoomEntity,
        HotelRoomDTO,
        HotelRoomRequestDTO,
        HotelRoomMapper,
        HotelRoomRepository, HotelRoomSpecification> {

    private final HotelRoomMapper hotelRoomMapper;
    private final HotelRoomRepository hotelRoomRepository;
    private final HotelRoomSpecification hotelRoomSpecification;

    public HotelRoomService(HotelRoomMapper hotelRoomMapper, HotelRoomRepository hotelRoomRepository, HotelRoomSpecification hotelRoomSpecification) {
        this.hotelRoomMapper = hotelRoomMapper;
        this.hotelRoomRepository = hotelRoomRepository;
        this.hotelRoomSpecification = hotelRoomSpecification;
    }

    @Override
    public HotelRoomMapper getMapper() {
        return hotelRoomMapper;
    }

    @Override
    public HotelRoomRepository getRepository() {
        return hotelRoomRepository;
    }

    @Override
    protected HotelRoomSpecification getSpecification() {
        return hotelRoomSpecification;
    }


    public Page<HotelRoomDTO> getPagination(int page, int pageSize) {
        if (page < 0) return null;
        else if (pageSize <= 0) pageSize = 10;
        Page<HotelRoomEntity> hotelRoomEntities = hotelRoomRepository.findAll(PageRequest.of(page, pageSize));
        return hotelRoomEntities.map(hotelRoomMapper::entityToDTO);
    }
}
