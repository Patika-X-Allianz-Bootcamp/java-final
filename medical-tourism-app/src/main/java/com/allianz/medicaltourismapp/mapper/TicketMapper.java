package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.TicketEntity;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.model.TicketDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class TicketMapper extends BaseMapper<TicketDTO, TicketEntity> {
    @Autowired
    @Lazy
    PassengerMapper passengerMapper;

    @Autowired
    @Lazy
    FlightMapper flightMapper;
    @Autowired
    @Lazy
    SeatMapper seatMapper;


    @Override
    public TicketDTO toDTO(TicketEntity entity) {
        TicketDTO dto = new TicketDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setTicketCode(entity.getTicketCode());
        dto.setTypeEnum(entity.getTypeEnum());
        dto.setPassenger(passengerMapper.toDTO(entity.getPassenger()));
        dto.setFlightCode(flightMapper.toDTO(entity.getFlight()));
        dto.setSeatCode(seatMapper.toDTO(entity.getSeat()));

        return dto;
    }

    @Override
    public TicketEntity toEntity(TicketDTO dto) {
        TicketEntity entity = new TicketEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setTicketCode(dto.getTicketCode());
        entity.setTypeEnum(dto.getTypeEnum());
        entity.setPassenger(passengerMapper.toEntity(dto.getPassenger()));
        entity.setFlight(flightMapper.toEntity(dto.getFlightCode()));
        entity.setSeat(seatMapper.toEntity(dto.getSeatCode()));
        return entity;
    }
}