package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.GuestEntity;
import com.allianz.medicaltourismapp.model.GuestDTO;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class GuestMapper extends BaseMapper<GuestDTO, GuestEntity> {
    @Autowired
    @Lazy
    CreditCardMapper creditCardMapper;

    @Autowired
    @Lazy
    ReservationMapper reservationMapper;
    @Override
    public GuestDTO toDTO(GuestEntity entity) {
        GuestDTO dto = new GuestDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setCcNumbers(creditCardMapper.toDTOList(entity.getCreditCards()));
        dto.setReservationCodes(reservationMapper.toDTOList(entity.getReservations()));
        return dto;
    }

    @Override
    public GuestEntity toEntity(GuestDTO dto) {
        GuestEntity entity = new GuestEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setCreditCards(creditCardMapper.toEntityList(dto.getCcNumbers()));
        entity.setReservations(reservationMapper.toEntityList(dto.getReservationCodes()));
        return entity;

    }

}
