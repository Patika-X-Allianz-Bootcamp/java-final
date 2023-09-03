package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.PlaneTicketEntity;
import com.allianz.healthtourism.database.entity.RoomEntity;
import com.allianz.healthtourism.model.requestDTO.PlaneTicketRequestDTO;
import com.allianz.healthtourism.model.requestDTO.RoomRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneTicketResponseDTO;
import com.allianz.healthtourism.model.responseDTO.RoomResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper extends BaseMapper<RoomEntity, RoomResponseDTO, RoomRequestDTO> {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
}
