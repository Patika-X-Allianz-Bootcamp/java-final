package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.RoomEntity;
import com.allianz.healthtourism.database.repository.RoomRepository;
import com.allianz.healthtourism.mapper.RoomMapper;
import com.allianz.healthtourism.model.DTO.RoomDTO;
import com.allianz.healthtourism.model.requestDTO.RoomRequestDTO;
import com.allianz.healthtourism.service.RoomService;
import com.allianz.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController extends BaseController<RoomEntity, RoomDTO, RoomRequestDTO,
        RoomMapper, RoomRepository, RoomService> {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @Override
    protected RoomService getService() {
        return roomService;
    }
}
