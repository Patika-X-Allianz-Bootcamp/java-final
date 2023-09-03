package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.DoctorEntity;
import com.allianz.medicaltourismapp.model.DoctorDTO;

import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class DoctorMapper extends BaseMapper<DoctorDTO, DoctorEntity> {
    @Autowired
    @Lazy
    AppointmentMapper appointmentMapper;

    @Autowired
    @Lazy
    DepartmentMapper departmentMapper;

    @Override
    public DoctorDTO toDTO(DoctorEntity entity) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setAppointmentCodes(appointmentMapper.toDTOList(entity.getAppointments()));
        dto.setDepartmentName(departmentMapper.toDTO(entity.getDepartment()));
        return dto;
    }

    @Override
    public DoctorEntity toEntity(DoctorDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setAppointments(appointmentMapper.toEntityList(dto.getAppointmentCodes()));
        entity.setDepartment(departmentMapper.toEntity(dto.getDepartmentName()));
        return entity;
    }

}
