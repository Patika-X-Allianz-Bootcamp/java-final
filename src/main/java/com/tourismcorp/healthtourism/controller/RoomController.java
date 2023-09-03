package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.RoomEntity;
import com.tourismcorp.healthtourism.database.repositories.RoomRepository;
import com.tourismcorp.healthtourism.database.specification.RoomSpecification;
import com.tourismcorp.healthtourism.mapper.RoomMapper;
import com.tourismcorp.healthtourism.model.RoomDTO;
import com.tourismcorp.healthtourism.model.requestDTO.RoomRequestDTO;
import com.tourismcorp.healthtourism.service.RoomService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    RoomService roomService;

    @Override
    protected RoomService getService() {
        return this.roomService;
    }
}
