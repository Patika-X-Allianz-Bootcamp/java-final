package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Seat;
import com.allianz.meliorator.model.dto.SeatDTO;
import com.allianz.meliorator.model.requestDTO.SeatRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper extends IBaseMapper<Seat, SeatDTO, SeatRequestDTO> {
}
