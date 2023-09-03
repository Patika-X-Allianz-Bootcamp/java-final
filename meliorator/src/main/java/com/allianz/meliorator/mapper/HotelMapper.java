package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Hotel;
import com.allianz.meliorator.model.dto.HotelDTO;
import com.allianz.meliorator.model.requestDTO.HotelRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper extends IBaseMapper<Hotel, HotelDTO, HotelRequestDTO> {
}
