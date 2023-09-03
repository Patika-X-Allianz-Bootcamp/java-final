package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Flight;
import com.allianz.meliorator.model.dto.FlightDTO;
import com.allianz.meliorator.model.requestDTO.FlightRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper extends IBaseMapper<Flight, FlightDTO, FlightRequestDTO> {
}
