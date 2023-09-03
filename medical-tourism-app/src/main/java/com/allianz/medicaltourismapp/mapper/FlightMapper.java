package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.FlightEntity;
import com.allianz.medicaltourismapp.model.FlightDTO;

import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class FlightMapper extends BaseMapper<FlightDTO, FlightEntity> {
    @Autowired
    @Lazy
    SeatMapper seatMapper;
    @Override
    public FlightDTO toDTO(FlightEntity entity) {
        FlightDTO dto = new FlightDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setFlightCode(entity.getFlightCode());
        dto.setStartingTime(entity.getStartingTime());
        dto.setReactingTime(entity.getReactingTime());
        dto.setDeparturePlace(entity.getDeparturePlace());
        dto.setArrivalPlace(entity.getArrivalPlace());
        dto.setSeats(seatMapper.toDTOList(entity.getSeats()));
        return dto;
    }

    @Override
    public FlightEntity toEntity(FlightDTO dto) {
        FlightEntity entity = new FlightEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setFlightCode(dto.getFlightCode());
        entity.setStartingTime(dto.getStartingTime());
        entity.setReactingTime(dto.getReactingTime());
        entity.setDeparturePlace(dto.getDeparturePlace());
        entity.setArrivalPlace(dto.getArrivalPlace());
        entity.setSeats(seatMapper.toEntityList(dto.getSeats()));
        return entity;
    }


}
