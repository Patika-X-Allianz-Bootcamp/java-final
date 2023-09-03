package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper extends BaseMapper<AppointmentEntity, AppointmentResponseDTO, AppointmentRequestDTO> {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    @Override
    @Mapping(source = "patientId", target = "patient.id")
    @Mapping(source = "doctorId", target = "doctor.id")
    @Mapping(source = "healthServiceId", target = "healthService.id")
    @Mapping(source = "hospitalId", target = "hospital.id")
    AppointmentEntity requestDtoToEntity(AppointmentRequestDTO requestDTO);
}
