package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.FlightEntity;
import com.demo.medicaltourismapp.model.FlightDTO;
import com.demo.medicaltourismapp.model.requestDTO.FlightRequestDTO;
import com.demo.medicaltourismapp.util.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper extends BaseMapper<FlightEntity, FlightDTO, FlightRequestDTO> {
}
