package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.PatientEntity;
import com.allianz.healthtourismagency.model.PatientDTO;
import com.allianz.healthtourismagency.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper extends IBaseMapper<PatientEntity, PatientDTO, PatientRequestDTO> {

}
