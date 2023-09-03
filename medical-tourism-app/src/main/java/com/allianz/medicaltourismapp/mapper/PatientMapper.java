package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.PatientEntity;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.model.PatientDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class PatientMapper extends BaseMapper<PatientDTO, PatientEntity> {
    @Autowired
    @Lazy
    CreditCardMapper creditCardMapper;

    @Autowired
    @Lazy
    AppointmentMapper appointmentMapper;

    @Override
    public PatientDTO toDTO(PatientEntity entity) {
        PatientDTO dto = new PatientDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setCcNumber(creditCardMapper.toDTOList(entity.getCreditCards()));
        dto.setAppointmentCode(appointmentMapper.toDTOList(entity.getAppointments()));
        return dto;
    }


    @Override
    public PatientEntity toEntity(PatientDTO dto) {
        PatientEntity entity = new PatientEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setCreditCards(creditCardMapper.toEntityList(dto.getCcNumber()));
        entity.setAppointments(appointmentMapper.toEntityList(dto.getAppointmentCode()));
        return entity;
    }
}
