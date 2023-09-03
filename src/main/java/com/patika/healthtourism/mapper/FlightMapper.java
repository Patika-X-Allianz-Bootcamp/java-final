package com.patika.healthtourism.mapper;

import com.patika.healthtourism.database.entity.FlightEntity;
import com.patika.healthtourism.model.FlightDTO;
import com.patika.healthtourism.model.requestDTO.FlightRequestDTO;
import com.patika.healthtourism.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper extends IBaseMapper<FlightEntity, FlightDTO, FlightRequestDTO> {
}
