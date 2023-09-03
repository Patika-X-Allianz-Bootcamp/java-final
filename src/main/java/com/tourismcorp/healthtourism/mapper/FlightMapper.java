package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.FlightEntity;
import com.tourismcorp.healthtourism.model.FlightDTO;
import com.tourismcorp.healthtourism.model.requestDTO.FlightRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightMapper implements IBaseMapper<FlightEntity, FlightDTO, FlightRequestDTO> {


    private final SeatMapper seatMapper;

    @Autowired
    public FlightMapper(@Lazy SeatMapper seatMapper) {
        this.seatMapper = seatMapper;
    }

    @Override
    public FlightDTO entityToDTO(FlightEntity entity) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setUuid(entity.getUuid());
        flightDTO.setCreationDate(entity.getCreationDate());
        flightDTO.setUpdatedDate(entity.getUpdatedDate());
        flightDTO.setId(entity.getId());
        flightDTO.setFlightNumber(entity.getFlightNumber());
        flightDTO.setDeparture(entity.getDeparture());
        flightDTO.setArrival(entity.getArrival());
        flightDTO.setDepartureTime(entity.getDepartureTime());
        flightDTO.setDate(entity.getDate());
        flightDTO.setPrice(entity.getPrice());
        flightDTO.setSeat(seatMapper.entityListToDTOList(entity.getSeat()));

        return flightDTO;
    }

    @Override
    public FlightEntity dtoToEntity(FlightDTO dto) {
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setUuid(dto.getUuid());
        flightEntity.setCreationDate(dto.getCreationDate());
        flightEntity.setUpdatedDate(dto.getUpdatedDate());
        flightEntity.setId(dto.getId());
        flightEntity.setFlightNumber(dto.getFlightNumber());
        flightEntity.setDeparture(dto.getDeparture());
        flightEntity.setArrival(dto.getArrival());
        flightEntity.setDepartureTime(dto.getDepartureTime());
        flightEntity.setDate(dto.getDate());
        flightEntity.setPrice(dto.getPrice());
        flightEntity.setSeat(seatMapper.dtoListToEntityList(dto.getSeat()));

        return flightEntity;
    }

    @Override
    public List<FlightDTO> entityListToDTOList(List<FlightEntity> entityList) {
        List<FlightDTO> flightDTOList = new ArrayList<>();
        for (FlightEntity entity : entityList) {
            FlightDTO dto = entityToDTO(entity);
            flightDTOList.add(dto);
        }
        return flightDTOList;
    }

    @Override
    public List<FlightEntity> dtoListToEntityList(List<FlightDTO> dtoList) {
        List<FlightEntity> flightEntityList = new ArrayList<>();
        for (FlightDTO dto : dtoList) {
            FlightEntity entity = dtoToEntity(dto);
            flightEntityList.add(entity);
        }
        return flightEntityList;
    }

    @Override
    public FlightEntity requestDTOToEntity(FlightRequestDTO requestDTO) {
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setUuid(requestDTO.getUuid());
        flightEntity.setCreationDate(requestDTO.getCreationDate());
        flightEntity.setUpdatedDate(requestDTO.getUpdatedDate());
        flightEntity.setId(requestDTO.getId());
        flightEntity.setFlightNumber(requestDTO.getFlightNumber());
        flightEntity.setDeparture(requestDTO.getDeparture());
        flightEntity.setArrival(requestDTO.getArrival());
        flightEntity.setDepartureTime(requestDTO.getDepartureTime());
        flightEntity.setDate(requestDTO.getDate());
        flightEntity.setPrice(requestDTO.getPrice());
        flightEntity.setSeat(seatMapper.requestDTOListToEntityList(requestDTO.getSeat()));

        return flightEntity;
    }

    @Override
    public List<FlightEntity> requestDTOListToEntityList(List<FlightRequestDTO> dtoList) {
        List<FlightEntity> flightEntityList = new ArrayList<>();
        if (dtoList == null)
            return flightEntityList;
        for (FlightRequestDTO dto : dtoList) {
            FlightEntity entity = requestDTOToEntity(dto);
            flightEntityList.add(entity);
        }
        return flightEntityList;
    }

    @Override
    public FlightEntity requestDTOToExistEntity(FlightRequestDTO requestDTO, FlightEntity entity) {
        if (requestDTO.getFlightNumber() != null)
            entity.setFlightNumber(requestDTO.getFlightNumber());
        if (requestDTO.getDeparture() != null)
            entity.setDeparture(requestDTO.getDeparture());
        if (requestDTO.getArrival() != null)
            entity.setArrival(requestDTO.getArrival());
        if (requestDTO.getDepartureTime() != null)
            entity.setDepartureTime(requestDTO.getDepartureTime());
        if (requestDTO.getDate() != null)
            entity.setDate(requestDTO.getDate());
        if (requestDTO.getPrice() != null)
            entity.setPrice(requestDTO.getPrice());
        if (requestDTO.getSeat() != null)
            entity.setSeat(seatMapper.requestDTOListToEntityList(requestDTO.getSeat()));


        return entity;
    }

    @Override
    public Page<FlightDTO> pageEntityToPageDTO(Page<FlightEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }

}
