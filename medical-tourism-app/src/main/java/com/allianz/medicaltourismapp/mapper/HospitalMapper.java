package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.HospitalEntity;
import com.allianz.medicaltourismapp.model.HospitalDTO;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class HospitalMapper extends BaseMapper<HospitalDTO, HospitalEntity> {
    @Autowired
    @Lazy
    DepartmentMapper departmentMapper;

    @Override
    public HospitalDTO toDTO(HospitalEntity entity) {
        HospitalDTO dto = new HospitalDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setHospitalName(entity.getHospitalName());
        dto.setHospitalAddress(entity.getHospitalAddress());
        dto.setHospitalPhone(entity.getHospitalPhone());
        dto.setDepartmentName(departmentMapper.toDTOList(entity.getDepartments()));
        return dto;
    }

    @Override
    public HospitalEntity toEntity(HospitalDTO dto) {
        HospitalEntity entity = new HospitalEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setHospitalName(dto.getHospitalName());
        entity.setHospitalAddress(dto.getHospitalAddress());
        entity.setHospitalPhone(dto.getHospitalPhone());
        entity.setDepartments(departmentMapper.toEntityList(dto.getDepartmentName()));
        return entity;
    }

}
