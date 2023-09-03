package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.PassengerEntity;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.model.PassengerDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class PassengerMapper extends BaseMapper<PassengerDTO, PassengerEntity> {
    @Autowired
    @Lazy
    CreditCardMapper creditCardMapper;

    @Autowired
    @Lazy
    TicketMapper ticketMapper;

    @Override
    public PassengerDTO toDTO(PassengerEntity entity) {
        PassengerDTO dto = new PassengerDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setCreditCardNumber(creditCardMapper.toDTOList(entity.getCreditCards()));
        dto.setTicketCode(ticketMapper.toDTOList(entity.getTicket()));
        return dto;
    }

    @Override
    public PassengerEntity toEntity(PassengerDTO dto) {
        PassengerEntity entity = new PassengerEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setCreditCards(creditCardMapper.toEntityList(dto.getCreditCardNumber()));
        entity.setTicket(ticketMapper.toEntityList(dto.getTicketCode()));
        return entity;
    }
}