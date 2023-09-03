package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.ExaminationRecordEntity;
import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.model.requestDTO.ExaminationRecordRequestDTO;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationRecordResponseDTO;
import com.allianz.healthtourism.model.responseDTO.FlightForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.FlightResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FlightMapper extends BaseMapper<FlightEntity, FlightResponseDTO, FlightRequestDTO> {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);
    @Override
    @Mapping(source = "cityToId", target = "cityTo.id")
    @Mapping(source = "cityFromId", target = "cityFrom.id")
    @Mapping(source = "planeId", target = "plane.id")
    FlightEntity requestDtoToEntity(FlightRequestDTO requestDTO);


    List<FlightForPatientResponseDTO> entityListToResponseDtoListForPatient(List<FlightEntity> flightEntities);
}
