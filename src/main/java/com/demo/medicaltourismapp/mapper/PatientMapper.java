package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.PatientEntity;
import com.demo.medicaltourismapp.model.PatientDTO;
import com.demo.medicaltourismapp.model.requestDTO.PatientRequestDTO;
import com.demo.medicaltourismapp.util.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper extends BaseMapper<PatientEntity, PatientDTO, PatientRequestDTO> {
}
