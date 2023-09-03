package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.RoomEntity;
import com.allianz.healthtourismagency.model.RoomDTO;
import com.allianz.healthtourismagency.model.requestDTO.RoomRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends IBaseMapper<RoomEntity, RoomDTO, RoomRequestDTO> {

}
