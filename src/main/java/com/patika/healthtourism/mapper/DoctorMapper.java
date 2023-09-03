package com.patika.healthtourism.mapper;

import com.patika.healthtourism.database.entity.DoctorEntity;
import com.patika.healthtourism.model.DoctorDTO;
import com.patika.healthtourism.model.requestDTO.DoctorCreateRequestDTO;
import com.patika.healthtourism.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper extends IBaseMapper<DoctorEntity, DoctorDTO, DoctorCreateRequestDTO> {
}
