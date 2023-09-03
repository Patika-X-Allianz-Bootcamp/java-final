package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.AppointmentEntity;
import com.allianz.healthtourismagency.model.AppointmentDTO;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper extends IBaseMapper<AppointmentEntity, AppointmentDTO, AppointmentRequestDTO> {

}
