package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.model.DTO.FlightDTO;
import com.allianz.healthtourism.model.DTO.PageDTO;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class FlightMapper implements IBaseMapper<FlightDTO, FlightEntity, FlightRequestDTO> {

    private final CityMapper cityMapper;

    private final PatientMapper patientMapper;

    public FlightMapper(CityMapper cityMapper, PatientMapper patientMapper) {
        this.cityMapper = cityMapper;
        this.patientMapper = patientMapper;
    }

    @Override
    public FlightDTO entityToDTO(FlightEntity entity) {
        FlightDTO dto = new FlightDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setFlightNumber(entity.getFlightNumber());
        dto.setFligthTime(entity.getFligtTime());
        dto.setAirline(entity.getAirline());
        dto.setDepartureCity(cityMapper.entityToDTO(entity.getDepartureCity()));
        dto.setDestinationCity(cityMapper.entityToDTO(entity.getDestinationCity()));

        return dto;
    }

    @Override
    public FlightEntity dtoToEntity(FlightDTO dto) {
        FlightEntity entity = new FlightEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setFlightNumber(dto.getFlightNumber());
        entity.setAirline(dto.getAirline());
        entity.setDepartureCity(cityMapper.dtoToEntity(dto.getDepartureCity()));
        entity.setDestinationCity(cityMapper.dtoToEntity(dto.getDestinationCity()));
        entity.setFligtTime(dto.getFligthTime());
        entity.setPatientList(patientMapper.dtoListTOEntityList(dto.getPatientList()));

        return entity;
    }

    @Override
    public List<FlightDTO> entityListToDTOList(List<FlightEntity> flightEntities) {
        return null;
    }


    @Override
    public List<FlightEntity> dtoListTOEntityList(List<FlightDTO> dtoList) {
        List<FlightEntity> entities = new ArrayList<>();

        for (FlightDTO dto: dtoList){
            entities.add(dtoToEntity(dto));
        }

        return entities;
    }

    @Override
    public FlightEntity requestDTOToEntity(FlightRequestDTO dto) {
        return null;
    }

    @Override
    public List<FlightEntity> requestDtoListTOEntityList(List<FlightRequestDTO> flightRequestDTOS) {
        return null;
    }

    @Override
    public FlightEntity requestDtoToExistEntity(FlightEntity entity, FlightRequestDTO flightRequestDTO) {
        return null;
    }

    @Override
    public FlightEntity dtoToExistEntity(FlightEntity entity, FlightDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setFligtTime(dto.getFligthTime());
        entity.setFlightNumber(dto.getFlightNumber());
        entity.setAirline(dto.getAirline());
        entity.setDepartureCity(cityMapper.dtoToEntity(dto.getDepartureCity()));
        entity.setDestinationCity(cityMapper.dtoToEntity(dto.getDestinationCity()));
        entity.setPatientList(patientMapper.dtoListTOEntityList(dto.getPatientList()));

        return entity;
    }

    @Override
    public PageDTO<FlightDTO> pageEntityToPageDTO(Page<FlightEntity> flightEntities) {
        return null;
    }
}
