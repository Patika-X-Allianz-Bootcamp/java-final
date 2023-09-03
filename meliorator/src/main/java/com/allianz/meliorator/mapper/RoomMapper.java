package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Room;
import com.allianz.meliorator.model.dto.RoomDTO;
import com.allianz.meliorator.model.requestDTO.RoomRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends IBaseMapper<Room, RoomDTO, RoomRequestDTO> {
}
