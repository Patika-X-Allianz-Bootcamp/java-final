package com.healthtourism.healthtourism.mapper;

import com.healthtourism.healthtourism.database.entities.FlightInfoEntity;
import com.healthtourism.healthtourism.database.entities.HotelInfoEntity;
import com.healthtourism.healthtourism.model.FlightInfoDTO;
import com.healthtourism.healthtourism.model.HotelInfoDTO;
import com.healthtourism.healthtourism.model.RequestDTO.FlightInfoRequestDTO;
import com.healthtourism.healthtourism.model.RequestDTO.HoteInfoRequestDTO;
import com.healthtourism.healthtourism.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightInfoMapper implements IBaseMapper<FlightInfoEntity, FlightInfoDTO, FlightInfoRequestDTO> {


    private final PatientMapper patientMapper;

    public FlightInfoMapper(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    @Override
    public FlightInfoDTO entityToDTO(FlightInfoEntity entity) {
        FlightInfoDTO dto = new FlightInfoDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setAirlineCompany(entity.getAirlineCompany());
        dto.setFlightNumber(entity.getFlightNumber());
        dto.setDepartureCity(entity.getDepartureCity());
        dto.setArrivalCity(entity.getArrivalCity());
        dto.setArrivalDateTime(entity.getArrivalDateTime());
        dto.setReservationStatus(entity.getReservationStatus());
        dto.setCurrentDateTime(entity.getCurrentDateTime());
        dto.setDepartureDateTime(entity.getDepartureDateTime());
        dto.setPatients(patientMapper.entityListToDTOList(entity.getPatients()));
        dto.setConfirmed(entity.isConfirmed());


        return dto;
    }

    @Override
    public FlightInfoEntity dtoToEntity(FlightInfoDTO dto) {
        FlightInfoEntity entity = new FlightInfoEntity();
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setAirlineCompany(dto.getAirlineCompany());
        entity.setFlightNumber(dto.getFlightNumber());
        entity.setDepartureCity(dto.getDepartureCity());
        entity.setArrivalCity(dto.getArrivalCity());
        entity.setArrivalDateTime(dto.getArrivalDateTime());
        entity.setReservationStatus(dto.getReservationStatus());
        entity.setArrivalCity(dto.getArrivalCity());
        entity.setCurrentDateTime(dto.getCurrentDateTime());
        entity.setDepartureDateTime(dto.getDepartureDateTime());
        entity.setConfirmed(dto.isConfirmed());
        entity.setPatients(patientMapper.dtoListToEntityList(dto.getPatients()));
        return entity;
    }

    @Override
    public List<FlightInfoDTO> entityListToDTOList(List<FlightInfoEntity> entityList) {
        List<FlightInfoDTO> dtoList = new ArrayList<>();
        for (FlightInfoEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<FlightInfoEntity> dtoListToEntityList(List<FlightInfoDTO> dtoList) {
        List<FlightInfoEntity> entityList = new ArrayList<>();
        for (FlightInfoDTO dto : dtoList) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public FlightInfoEntity requestDTOToEntity(FlightInfoRequestDTO requestDTO) {
        FlightInfoEntity entity = new FlightInfoEntity();
        entity.setAirlineCompany(requestDTO.getAirlineCompany());
        entity.setFlightNumber(requestDTO.getFlightNumber());
        entity.setDepartureCity(requestDTO.getDepartureCity());
        entity.setArrivalCity(requestDTO.getArrivalCity());
        entity.setArrivalDateTime(requestDTO.getArrivalDateTime());
        entity.setReservationStatus(requestDTO.getReservationStatus());
        entity.setConfirmed(requestDTO.isConfirmed());
        entity.setArrivalCity(requestDTO.getArrivalCity());
        entity.setDepartureDateTime(requestDTO.getDepartureDateTime());
        entity.setCurrentDateTime(requestDTO.getCurrentDateTime());
        entity.setConfirmed(requestDTO.isConfirmed());


        return entity;
    }

    @Override
    public List<FlightInfoEntity> requestDTOListToEntityList(List<FlightInfoRequestDTO> dtoList) {
        List<FlightInfoEntity> entityList = new ArrayList<>();
        for (FlightInfoRequestDTO dto : dtoList) {
            entityList.add(requestDTOToEntity(dto));
        }
        return entityList;
    }

    @Override
    public FlightInfoEntity requestDTOToExistEntity(FlightInfoRequestDTO requestDTO, FlightInfoEntity entity) {
        FlightInfoEntity flightInfoEntity = new FlightInfoEntity();
        flightInfoEntity.setFlightNumber(requestDTO.getFlightNumber());
        flightInfoEntity.setAirlineCompany(requestDTO.getAirlineCompany());
        flightInfoEntity.setArrivalDateTime(requestDTO.getArrivalDateTime());
        flightInfoEntity.setArrivalCity(requestDTO.getArrivalCity());
        flightInfoEntity.setDepartureCity(requestDTO.getDepartureCity());
        flightInfoEntity.setCreationDate(requestDTO.getCreationDate());
        flightInfoEntity.setUpdatedDate(requestDTO.getUpdatedDate());
        flightInfoEntity.setUuid(requestDTO.getUuid());
        flightInfoEntity.setId(requestDTO.getId());
        flightInfoEntity.setCurrentDateTime(requestDTO.getCurrentDateTime());
        flightInfoEntity.setDepartureDateTime(requestDTO.getDepartureDateTime());
        flightInfoEntity.setConfirmed(requestDTO.isConfirmed());

        return entity;
    }

}
