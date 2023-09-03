package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Doctor;
import com.allianz.meliorator.model.dto.DoctorDTO;
import com.allianz.meliorator.model.requestDTO.DoctorRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper extends IBaseMapper<Doctor, DoctorDTO, DoctorRequestDTO> {
}
