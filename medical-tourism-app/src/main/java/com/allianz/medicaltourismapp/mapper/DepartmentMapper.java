package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.DepartmentEntity;
import com.allianz.medicaltourismapp.model.DepartmentDTO;

import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class DepartmentMapper extends BaseMapper<DepartmentDTO, DepartmentEntity> {

    @Autowired
    @Lazy
    DoctorMapper doctorMapper;
    @Override
    public DepartmentDTO toDTO(DepartmentEntity entity) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setDepartmentName(entity.getDepartmentName());
       dto.setDoctors(doctorMapper.toDTOList(entity.getDoctors()));
        return dto;

    }

    @Override
    public DepartmentEntity toEntity(DepartmentDTO dto) {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setDepartmentName(dto.getDepartmentName());
        entity.setDoctors(doctorMapper.toEntityList(dto.getDoctors()));

        return entity;

    }
}
