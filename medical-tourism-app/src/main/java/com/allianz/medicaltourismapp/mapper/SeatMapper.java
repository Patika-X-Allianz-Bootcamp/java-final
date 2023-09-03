package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.SeatEntity;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.model.SeatDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class SeatMapper extends BaseMapper<SeatDTO, SeatEntity> {
    @Autowired
    @Lazy
    FlightMapper flightMapper;
    @Override
    public SeatDTO toDTO(SeatEntity entity) {
        SeatDTO dto = new SeatDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setFlight(flightMapper.toDTO(entity.getFlight()));
        dto.setSeatCode(entity.getSeatCode());
        dto.setBookingStatusEnum(entity.getBookingStatusEnum());
        return dto;
    }

    @Override
    public SeatEntity toEntity(SeatDTO dto) {
        SeatEntity entity = new SeatEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setFlight(flightMapper.toEntity(dto.getFlight()));
        entity.setSeatCode(dto.getSeatCode());
        entity.setBookingStatusEnum(dto.getBookingStatusEnum());

        return entity;
    }

    @Override
    public List<SeatEntity> toEntityList(List<SeatDTO> entityList) {
        return null;
    }

    @Override
    public List<SeatDTO> toDTOList(List<SeatEntity> dtoList) {
        return null;
    }

    @Override
    public PageDTO<SeatDTO> toDTO(Page<SeatEntity> entityPage) {
        return null;
    }

    @Override
    public SeatEntity dtoToExistEntity(SeatDTO dto, SeatEntity entity) {
        return null;
    }
}
