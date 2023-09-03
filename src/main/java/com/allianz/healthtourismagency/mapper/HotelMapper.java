package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.HotelEntity;
import com.allianz.healthtourismagency.model.HotelDTO;
import com.allianz.healthtourismagency.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper extends IBaseMapper<HotelEntity, HotelDTO, HotelRequestDTO> {

}
