package com.patika.healthtourism.mapper;

import com.patika.healthtourism.database.entity.HotelEntity;
import com.patika.healthtourism.model.HotelDTO;
import com.patika.healthtourism.model.requestDTO.HotelRequestDTO;
import com.patika.healthtourism.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper extends IBaseMapper<HotelEntity, HotelDTO, HotelRequestDTO> {
}
