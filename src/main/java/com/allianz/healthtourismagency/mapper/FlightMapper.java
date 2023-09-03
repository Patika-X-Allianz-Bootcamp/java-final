package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.FlightEntity;
import com.allianz.healthtourismagency.model.FlightDTO;
import com.allianz.healthtourismagency.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper extends IBaseMapper<FlightEntity, FlightDTO, FlightRequestDTO> {

}
