package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PatientResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper extends BaseMapper<PatientEntity, PatientResponseDTO, PatientRequestDTO> {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
}
