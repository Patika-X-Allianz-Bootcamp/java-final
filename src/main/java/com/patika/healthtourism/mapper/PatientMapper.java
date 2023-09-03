package com.patika.healthtourism.mapper;

import com.patika.healthtourism.database.entity.PatientEntity;
import com.patika.healthtourism.model.PatientDTO;
import com.patika.healthtourism.model.requestDTO.PatientRequestDTO;
import com.patika.healthtourism.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper extends IBaseMapper<PatientEntity, PatientDTO, PatientRequestDTO> {
}
