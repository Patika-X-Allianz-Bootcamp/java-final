package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.FlightSeatEntity;
import com.example.healthtourismapp.model.FlightSeatDTO;
import com.example.healthtourismapp.model.requestDTO.FlightSeatRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightSeatMapper implements IBaseMapper<FlightSeatEntity, FlightSeatDTO, FlightSeatRequestDTO> {
    @Override
    public FlightSeatDTO entityToDTO(FlightSeatEntity entity) {

        FlightSeatDTO flightSeatDTO = new FlightSeatDTO();
        flightSeatDTO.setFlightClass(entity.getFlightClass());
        flightSeatDTO.setSeatNumber(entity.getSeatNumber());
        flightSeatDTO.setUuid(entity.getUuid());
        flightSeatDTO.setId(entity.getId());
        flightSeatDTO.setUpdatedDate(entity.getUpdatedDate());
        flightSeatDTO.setCreationDate(entity.getCreationDate());

        return flightSeatDTO;
    }

    @Override
    public FlightSeatEntity dtoToEntity(FlightSeatDTO dto) {

        FlightSeatEntity flightSeatEntity = new FlightSeatEntity();
        flightSeatEntity.setFlightClass(dto.getFlightClass());
        flightSeatEntity.setSeatNumber(dto.getSeatNumber());
        flightSeatEntity.setUuid(dto.getUuid());
        flightSeatEntity.setId(dto.getId());
        flightSeatEntity.setUpdatedDate(dto.getUpdatedDate());
        flightSeatEntity.setCreationDate(dto.getCreationDate());

        return flightSeatEntity;
    }

    @Override
    public List<FlightSeatDTO> entityListToDTOList(List<FlightSeatEntity> flightSeatEntities) {

        List<FlightSeatDTO> flightSeatDTOS = new ArrayList<>();
        for (FlightSeatEntity entity : flightSeatEntities) {
            flightSeatDTOS.add(entityToDTO(entity));
        }
        return flightSeatDTOS;
    }

    @Override
    public List<FlightSeatEntity> dtoListToEntityList(List<FlightSeatDTO> flightSeatDTOS) {

        List<FlightSeatEntity> flightSeatEntities = new ArrayList<>();
        for (FlightSeatDTO dto : flightSeatDTOS) {
            flightSeatEntities.add(dtoToEntity(dto));
        }
        return flightSeatEntities;
    }

    @Override
    public FlightSeatEntity requestDTOToEntity(FlightSeatRequestDTO flightSeatRequestDTO) {

        FlightSeatEntity flightSeatEntity = new FlightSeatEntity();
        flightSeatEntity.setFlightClass(flightSeatRequestDTO.getFlightClass());
        flightSeatEntity.setSeatNumber(flightSeatRequestDTO.getSeatNumber());
        flightSeatEntity.setUuid(flightSeatRequestDTO.getUuid());
        flightSeatEntity.setId(flightSeatRequestDTO.getId());
        flightSeatEntity.setUpdatedDate(flightSeatRequestDTO.getUpdatedDate());
        flightSeatEntity.setCreationDate(flightSeatRequestDTO.getCreationDate());

        return flightSeatEntity;
    }

    @Override
    public List<FlightSeatEntity> requestDTOListToEntityList(List<FlightSeatRequestDTO> flightSeatRequestDTOS) {

        List<FlightSeatEntity> flightSeatEntities = new ArrayList<>();
        for (FlightSeatRequestDTO requestDTO : flightSeatRequestDTOS) {
            flightSeatEntities.add(requestDTOToEntity(requestDTO));
        }
        return flightSeatEntities;
    }

    @Override
    public FlightSeatEntity requestDTOToExistEntity(FlightSeatRequestDTO flightSeatRequestDTO, FlightSeatEntity entity) {

        entity.setFlightClass(flightSeatRequestDTO.getFlightClass());
        entity.setSeatNumber(flightSeatRequestDTO.getSeatNumber());

        return entity;
    }

    @Override
    public Page<FlightSeatDTO> pageEntityToPageDTO(Page<FlightSeatEntity> flightSeatEntities) {
        return flightSeatEntities.map(this::entityToDTO);
    }

}
