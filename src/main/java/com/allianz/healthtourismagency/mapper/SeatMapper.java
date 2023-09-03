package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.SeatEntity;
import com.allianz.healthtourismagency.model.SeatDTO;
import com.allianz.healthtourismagency.model.requestDTO.SeatRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper extends IBaseMapper<SeatEntity, SeatDTO, SeatRequestDTO> {

}
