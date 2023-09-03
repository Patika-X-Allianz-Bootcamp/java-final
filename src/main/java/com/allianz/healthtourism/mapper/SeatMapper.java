package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.SeatEntity;
import com.allianz.healthtourism.model.requestDTO.SeatRequestDTO;
import com.allianz.healthtourism.model.responseDTO.SeatResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeatMapper extends BaseMapper<SeatEntity, SeatResponseDTO, SeatRequestDTO> {
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);
}
