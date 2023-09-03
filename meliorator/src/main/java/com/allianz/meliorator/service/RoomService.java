package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Room;
import com.allianz.meliorator.database.repository.RoomRepository;
import com.allianz.meliorator.database.specification.RoomSpecification;
import com.allianz.meliorator.mapper.RoomMapper;
import com.allianz.meliorator.model.dto.RoomDTO;
import com.allianz.meliorator.model.requestDTO.RoomRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends BaseService<Room, RoomDTO, RoomRequestDTO,
        RoomMapper, RoomRepository, RoomSpecification> {
    @Autowired
    RoomSpecification roomSpecification;
    @Autowired
    RoomMapper roomMapper;

    @Autowired
    RoomRepository roomRepository;

    @Override
    protected RoomMapper getMapper() {
        return this.roomMapper;
    }

    @Override
    protected RoomRepository getRepository() {
        return this.roomRepository;
    }

    @Override
    protected RoomSpecification getSpecification() {
        return this.roomSpecification;
    }
}
