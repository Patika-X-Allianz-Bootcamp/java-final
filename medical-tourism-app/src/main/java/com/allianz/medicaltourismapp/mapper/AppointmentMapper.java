package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.AppointmentEntity;
import com.allianz.medicaltourismapp.database.entity.PatientEntity;
import com.allianz.medicaltourismapp.model.AppointmentDTO;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentMapper extends BaseMapper<AppointmentDTO, AppointmentEntity> {
    @Autowired
    @Lazy
    DoctorMapper doctorMapper;

    @Autowired
    @Lazy
    PatientMapper patientMapper;

    @Override
    protected AppointmentDTO toDTO(AppointmentEntity entity) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setAppointmentCode(entity.getAppointmentCode());
        dto.setDate(entity.getDate());
        dto.setTime(entity.getTime());
        dto.setDoctor(doctorMapper.toDTO(entity.getDoctor()));
        dto.setPatient(patientMapper.toDTO(entity.getPatient()));
        return dto;
    }


    @Override
    protected AppointmentEntity toEntity(AppointmentDTO dto) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setAppointmentCode(dto.getAppointmentCode());
        entity.setDate(dto.getDate());
        entity.setTime(dto.getTime());
        entity.setPatient(patientMapper.toEntity(dto.getPatient()));
        entity.setDoctor(doctorMapper.toEntity(dto.getDoctor()));
        return entity;

    }
}


