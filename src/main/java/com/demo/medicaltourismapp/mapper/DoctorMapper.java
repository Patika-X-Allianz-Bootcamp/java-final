package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.DoctorEntity;
import com.demo.medicaltourismapp.model.DoctorDTO;
import com.demo.medicaltourismapp.model.requestDTO.DoctorRequestDTO;
import com.demo.medicaltourismapp.util.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper extends BaseMapper<DoctorEntity, DoctorDTO, DoctorRequestDTO> {
}
