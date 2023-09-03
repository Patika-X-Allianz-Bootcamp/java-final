package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.RoomEntity;
import com.allianz.healthtourismagency.database.repository.RoomRepository;
import com.allianz.healthtourismagency.database.specification.RoomSpecification;
import com.allianz.healthtourismagency.mapper.RoomMapper;
import com.allianz.healthtourismagency.model.RoomDTO;
import com.allianz.healthtourismagency.model.requestDTO.RoomRequestDTO;
import com.allianz.healthtourismagency.service.RoomService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController extends BaseController<
        RoomEntity,
        RoomDTO,
        RoomRequestDTO,
        RoomMapper,
        RoomRepository,
        RoomSpecification,
        RoomService> {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    protected RoomService getService() {
        return roomService;
    }
}
