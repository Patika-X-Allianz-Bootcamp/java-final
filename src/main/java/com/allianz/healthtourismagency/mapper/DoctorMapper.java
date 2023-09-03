package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.DoctorEntity;
import com.allianz.healthtourismagency.model.DoctorDTO;
import com.allianz.healthtourismagency.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface DoctorMapper extends IBaseMapper<DoctorEntity, DoctorDTO, DoctorRequestDTO> {

}
