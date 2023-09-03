package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Appointment;
import com.allianz.meliorator.model.dto.AppointmentDTO;
import com.allianz.meliorator.model.requestDTO.AppointmentRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper extends IBaseMapper<Appointment, AppointmentDTO, AppointmentRequestDTO> {
}
