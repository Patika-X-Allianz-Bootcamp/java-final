package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.ReservationEntity;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.model.ReservationDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class ReservationMapper extends BaseMapper<ReservationDTO, ReservationEntity> {
    @Autowired
    @Lazy
    RoomMapper roomMapper;

    @Autowired
    @Lazy
    GuestMapper guestMapper;
    @Override
    public ReservationDTO toDTO(ReservationEntity entity) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setGuest(guestMapper.toDTO(entity.getGuest()));
        dto.setReservationCode(entity.getReservationCode());
        dto.setDate(entity.getDate());
        dto.setPrice(entity.getPrice());
        dto.setRoomNumber(roomMapper.toDTO(entity.getRoom()));
        return dto;
    }

    @Override
    public ReservationEntity toEntity(ReservationDTO dto) {
        ReservationEntity entity = new ReservationEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setGuest(guestMapper.toEntity(dto.getGuest()));
        entity.setReservationCode(dto.getReservationCode());
        entity.setDate(dto.getDate());
        entity.setPrice(dto.getPrice());
        entity.setRoom(roomMapper.toEntity(dto.getRoomNumber()));

        return entity;
    }

}
