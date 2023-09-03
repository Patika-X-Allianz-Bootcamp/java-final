package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Patient;
import com.allianz.meliorator.model.dto.PatientDTO;
import com.allianz.meliorator.model.requestDTO.PatientRequestDTO;
import com.allianz.meliorator.util.BaseService;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper extends IBaseMapper<Patient, PatientDTO, PatientRequestDTO> {
}
