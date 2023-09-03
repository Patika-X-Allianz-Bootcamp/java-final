package com.patika.healthtourism.mapper;

import com.patika.healthtourism.database.entity.AppointmentEntity;
import com.patika.healthtourism.model.AppointmentDTO;
import com.patika.healthtourism.model.requestDTO.AppointmentCreateRequestDTO;
import com.patika.healthtourism.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper extends IBaseMapper<AppointmentEntity, AppointmentDTO, AppointmentCreateRequestDTO> {
}
