package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.AppointmentEntity;
import com.demo.medicaltourismapp.model.AppointmentDTO;
import com.demo.medicaltourismapp.model.requestDTO.AppointmentRequestDTO;
import com.demo.medicaltourismapp.util.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper extends BaseMapper<AppointmentEntity, AppointmentDTO,
        AppointmentRequestDTO> {
}
