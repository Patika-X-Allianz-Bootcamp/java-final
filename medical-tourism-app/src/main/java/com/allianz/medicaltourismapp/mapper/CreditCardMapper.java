package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.CreditCardEntity;
import com.allianz.medicaltourismapp.model.CreditCardDTO;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreditCardMapper extends BaseMapper<CreditCardDTO, CreditCardEntity> {

    @Override
    protected CreditCardDTO toDTO(CreditCardEntity entity) {
        CreditCardDTO dto = new CreditCardDTO();
        dto.setClientName(entity.getClientName());
        dto.setCcNumber(entity.getCcNumber());
        dto.setCcBudget(entity.getCcBudget());
        dto.setExDate(entity.getExDate());
        dto.setCcPassword(entity.getCcPassword());
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;

    }

    @Override
    protected CreditCardEntity toEntity(CreditCardDTO dto) {
        CreditCardEntity entity = new CreditCardEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setClientName(dto.getClientName());
        entity.setCcNumber(dto.getCcNumber());
        entity.setCcBudget(dto.getCcBudget());
        entity.setExDate(dto.getExDate());
        entity.setCcPassword(dto.getCcPassword());
        return entity;
    }

}
