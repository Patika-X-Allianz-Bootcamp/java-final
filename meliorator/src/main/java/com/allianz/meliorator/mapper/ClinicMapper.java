package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Clinic;
import com.allianz.meliorator.model.dto.ClinicDTO;
import com.allianz.meliorator.model.requestDTO.ClinicRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import lombok.Data;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClinicMapper extends IBaseMapper<Clinic, ClinicDTO, ClinicRequestDTO> {
}
