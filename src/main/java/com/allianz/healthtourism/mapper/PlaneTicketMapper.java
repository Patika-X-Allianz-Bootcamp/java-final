package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.PlaneTicketEntity;
import com.allianz.healthtourism.model.requestDTO.PlaneTicketRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneTicketResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlaneTicketMapper extends BaseMapper<PlaneTicketEntity, PlaneTicketResponseDTO, PlaneTicketRequestDTO> {
    PlaneTicketMapper INSTANCE = Mappers.getMapper(PlaneTicketMapper.class);

    @Override
    @Mapping(source = "patientId", target = "patient.id")
    @Mapping(source = "seatId", target = "seat.id")
    @Mapping(source = "flightId", target = "flight.id")
    PlaneTicketEntity requestDtoToEntity(PlaneTicketRequestDTO requestDTO);
}
