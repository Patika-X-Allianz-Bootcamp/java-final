package com.allianz.medicaltourismapp.mapper;

import com.allianz.medicaltourismapp.database.entity.FlightCompanyEntity;
import com.allianz.medicaltourismapp.model.FlightCompanyDTO;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.BaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class FlightCompanyMapper extends BaseMapper<FlightCompanyDTO, FlightCompanyEntity> {
    @Autowired
    @Lazy
    FlightMapper flightMapper;

    @Override
    public FlightCompanyDTO toDTO(FlightCompanyEntity entity) {
        FlightCompanyDTO dto = new FlightCompanyDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setFlightCompanyName(entity.getFlightCompanyName());
        dto.setFlightCompanyAddress(entity.getFlightCompanyAddress());
        dto.setFlightCompanyPhone(entity.getFlightCompanyPhone());
        dto.setFlightCodes(flightMapper.toDTOList(entity.getFlights()));
        return dto;
    }

    @Override
    public FlightCompanyEntity toEntity(FlightCompanyDTO dto) {
        FlightCompanyEntity entity = new FlightCompanyEntity();
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setId(dto.getId());
        entity.setFlightCompanyName(dto.getFlightCompanyName());
        entity.setFlightCompanyAddress(dto.getFlightCompanyAddress());
        entity.setFlightCompanyPhone(dto.getFlightCompanyPhone());
        entity.setFlights(flightMapper.toEntityList(dto.getFlightCodes()));
        return entity;
    }


}
