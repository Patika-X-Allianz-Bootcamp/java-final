package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.database.entity.RoomEntity;
import com.allianz.healthtourism.database.repository.HotelRepository;
import com.allianz.healthtourism.database.repository.RoomRepository;
import com.allianz.healthtourism.database.specification.HotelSpecification;
import com.allianz.healthtourism.database.specification.RoomSpecification;
import com.allianz.healthtourism.mapper.HotelMapper;
import com.allianz.healthtourism.mapper.RoomMapper;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.model.requestDTO.RoomRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HotelResponseDTO;
import com.allianz.healthtourism.model.responseDTO.RoomResponseDTO;
import com.allianz.healthtourism.service.HotelService;
import com.allianz.healthtourism.service.RoomService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
@RequiredArgsConstructor
public class RoomController extends BaseController<RoomRequestDTO, RoomResponseDTO, RoomEntity, RoomMapper, RoomRepository, RoomSpecification, RoomService> {
    private final RoomService service;

    @Override
    protected RoomService getService() {
        return service;
    }
}
