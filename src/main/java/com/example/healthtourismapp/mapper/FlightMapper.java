package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.FlightEntity;
import com.example.healthtourismapp.model.FlightDTO;
import com.example.healthtourismapp.model.requestDTO.FlightRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightMapper implements IBaseMapper<FlightEntity, FlightDTO, FlightRequestDTO> {

    private final FlightSeatMapper flightSeatMapper;

    public FlightMapper(FlightSeatMapper flightSeatMapper) {
        this.flightSeatMapper = flightSeatMapper;
    }

    @Override
    public FlightDTO entityToDTO(FlightEntity entity) {

        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setFlightCode(entity.getFlightCode());
        flightDTO.setSeat(flightSeatMapper.entityListToDTOList(entity.getSeat()));
        flightDTO.setDate(entity.getDate());
        flightDTO.setDistance(entity.getDistance());
        flightDTO.setFromWhere(entity.getFromWhere());
        flightDTO.setToWhere(entity.getToWhere());
        flightDTO.setCreationDate(entity.getCreationDate());
        flightDTO.setId(entity.getId());
        flightDTO.setUpdatedDate(entity.getUpdatedDate());
        flightDTO.setUuid(entity.getUuid());

        return flightDTO;
    }

    @Override
    public FlightEntity dtoToEntity(FlightDTO dto) {

        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setFlightCode(dto.getFlightCode());
        flightEntity.setSeat(flightSeatMapper.dtoListToEntityList(dto.getSeat()));
        flightEntity.setDate(dto.getDate());
        flightEntity.setDistance(dto.getDistance());
        flightEntity.setFromWhere(dto.getFromWhere());
        flightEntity.setToWhere(dto.getToWhere());
        flightEntity.setCreationDate(dto.getCreationDate());
        flightEntity.setId(dto.getId());
        flightEntity.setUpdatedDate(dto.getUpdatedDate());
        flightEntity.setUuid(dto.getUuid());

        return flightEntity;
    }

    @Override
    public List<FlightDTO> entityListToDTOList(List<FlightEntity> flightEntities) {

        List<FlightDTO> flightDTOS = new ArrayList<>();
        for (FlightEntity entity : flightEntities) {
            flightDTOS.add(entityToDTO(entity));
        }
        return flightDTOS;
    }

    @Override
    public List<FlightEntity> dtoListToEntityList(List<FlightDTO> flightDTOS) {

        List<FlightEntity> flightEntities = new ArrayList<>();
        for (FlightDTO dto : flightDTOS) {
            flightEntities.add(dtoToEntity(dto));
        }
        return flightEntities;
    }

    @Override
    public FlightEntity requestDTOToEntity(FlightRequestDTO flightRequestDTO) {

        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setFlightCode(flightRequestDTO.getFlightCode());
        flightEntity.setSeat(flightSeatMapper.dtoListToEntityList(flightRequestDTO.getSeat()));
        flightEntity.setDate(flightRequestDTO.getDate());
        flightEntity.setDistance(flightRequestDTO.getDistance());
        flightEntity.setFromWhere(flightRequestDTO.getFromWhere());
        flightEntity.setToWhere(flightRequestDTO.getToWhere());
        flightEntity.setCreationDate(flightRequestDTO.getCreationDate());
        flightEntity.setId(flightRequestDTO.getId());
        flightEntity.setUpdatedDate(flightRequestDTO.getUpdatedDate());
        flightEntity.setUuid(flightRequestDTO.getUuid());

        return flightEntity;
    }

    @Override
    public List<FlightEntity> requestDTOListToEntityList(List<FlightRequestDTO> flightRequestDTOS) {

        List<FlightEntity> flightEntities = new ArrayList<>();
        for (FlightRequestDTO requestDTO : flightRequestDTOS) {
            flightEntities.add(requestDTOToEntity(requestDTO));
        }
        return flightEntities;
    }

    @Override
    public FlightEntity requestDTOToExistEntity(FlightRequestDTO flightRequestDTO, FlightEntity entity) {

        entity.setFlightCode(flightRequestDTO.getFlightCode());
        entity.setSeat(flightSeatMapper.dtoListToEntityList(flightRequestDTO.getSeat()));
        entity.setDate(flightRequestDTO.getDate());
        entity.setDistance(flightRequestDTO.getDistance());
        entity.setFromWhere(flightRequestDTO.getFromWhere());
        entity.setToWhere(flightRequestDTO.getToWhere());

        return entity;
    }

    @Override
    public Page<FlightDTO> pageEntityToPageDTO(Page<FlightEntity> flightEntities) {
        return flightEntities.map(this::entityToDTO);
    }
}
