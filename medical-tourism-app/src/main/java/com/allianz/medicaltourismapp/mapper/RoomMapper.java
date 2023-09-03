package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.RoomEntity;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.model.RoomDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class RoomMapper extends BaseMapper<RoomDTO, RoomEntity> {
    @Autowired
    @Lazy
    HotelMapper hotelMapper;

    @Override
    public RoomDTO toDTO(RoomEntity entity) {
        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setHotelDTO(hotelMapper.toDTO(entity.getHotel()));
        dto.setRoomNumber(entity.getRoomNumber());
        dto.setBookingStatusEnum(entity.getBookingStatusEnum());
        return dto;
    }

    @Override
    public RoomEntity toEntity(RoomDTO dto) {
        RoomEntity entity = new RoomEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setHotel(hotelMapper.toEntity(dto.getHotelDTO()));
        entity.setRoomNumber(dto.getRoomNumber());
        entity.setBookingStatusEnum(dto.getBookingStatusEnum());

        return entity;
    }
}