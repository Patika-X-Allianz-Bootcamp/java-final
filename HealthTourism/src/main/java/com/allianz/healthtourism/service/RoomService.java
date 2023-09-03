package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.RoomEntity;
import com.allianz.healthtourism.database.repository.RoomRepository;
import com.allianz.healthtourism.mapper.RoomMapper;
import com.allianz.healthtourism.model.DTO.RoomDTO;
import com.allianz.healthtourism.model.requestDTO.RoomRequestDTO;

import com.allianz.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends BaseService<RoomEntity, RoomDTO, RoomRequestDTO,
        RoomMapper, RoomRepository> {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    protected RoomMapper getMapper() {
        return roomMapper;
    }

    @Override
    protected RoomRepository getRepository() {
        return roomRepository;
    }
}
