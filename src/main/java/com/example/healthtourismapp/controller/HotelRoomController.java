package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.HotelRoomEntity;
import com.example.healthtourismapp.database.repositories.HotelRoomRepository;
import com.example.healthtourismapp.database.specification.HotelRoomSpecification;
import com.example.healthtourismapp.mapper.HotelRoomMapper;
import com.example.healthtourismapp.model.HotelRoomDTO;
import com.example.healthtourismapp.model.requestDTO.HotelRoomRequestDTO;
import com.example.healthtourismapp.service.HotelRoomService;
import com.example.healthtourismapp.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel-rooms")
public class HotelRoomController extends BaseController<HotelRoomEntity, HotelRoomDTO, HotelRoomRequestDTO,
        HotelRoomMapper, HotelRoomRepository, HotelRoomSpecification, HotelRoomService> {

    private final HotelRoomService hotelRoomService;

    public HotelRoomController(HotelRoomService hotelRoomService) {
        this.hotelRoomService = hotelRoomService;
    }

    @Override
    protected HotelRoomService getService() {
        return hotelRoomService;
    }
}
