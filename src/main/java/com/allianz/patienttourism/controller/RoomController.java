package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.Room;
import com.allianz.patienttourism.model.requestDTO.RoomRequestDTO;
import com.allianz.patienttourism.model.responseDTO.RoomResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController extends BaseController<Room, RoomResponseDTO, RoomRequestDTO> {
    public RoomController(BaseService<Room, RoomResponseDTO, RoomRequestDTO> service) {
        super(service);
    }
}
