package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.Room;
import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.RoomRequestDTO;
import com.allianz.patienttourism.model.responseDTO.RoomResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends BaseService<Room, RoomResponseDTO, RoomRequestDTO> {


    public RoomService(IBaseRepository<Room> repository, MapperService mapperService, BaseSpecification<Room> specification) {
        super(repository, mapperService, specification);
    }

    @Override
    protected Class<Room> getEntityClass() {
        return Room.class;
    }

    @Override
    protected Class<RoomResponseDTO> getResponseDTOClass() {
        return RoomResponseDTO.class;
    }
}
