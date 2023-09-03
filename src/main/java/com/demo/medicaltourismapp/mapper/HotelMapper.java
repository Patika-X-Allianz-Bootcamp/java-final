package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.HotelEntity;
import com.demo.medicaltourismapp.model.HotelDTO;
import com.demo.medicaltourismapp.model.requestDTO.HotelRequestDTO;
import com.demo.medicaltourismapp.util.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper extends BaseMapper<HotelEntity, HotelDTO, HotelRequestDTO> {
}