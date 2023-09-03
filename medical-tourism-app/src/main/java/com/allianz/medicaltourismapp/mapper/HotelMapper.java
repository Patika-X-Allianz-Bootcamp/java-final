package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.HotelEntity;
import com.allianz.medicaltourismapp.model.HotelDTO;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class HotelMapper extends BaseMapper<HotelDTO, HotelEntity> {
    @Autowired
    @Lazy
    RoomMapper roomMapper;
    @Override
    public HotelDTO toDTO(HotelEntity entity) {
        HotelDTO dto =new HotelDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setHotelName(entity.getHotelName());
        dto.setHotelAdress(entity.getHotelAdress());
        dto.setRoomNumbers(roomMapper.toDTOList(entity.getHotelCapacity()));

        return dto;
    }

    @Override
    public HotelEntity toEntity(HotelDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setHotelAdress(dto.getHotelAdress());
        entity.setHotelName(dto.getHotelName());
        entity.setHotelCapacity(roomMapper.toEntityList(dto.getRoomNumbers()));
        return entity;

    }

}
