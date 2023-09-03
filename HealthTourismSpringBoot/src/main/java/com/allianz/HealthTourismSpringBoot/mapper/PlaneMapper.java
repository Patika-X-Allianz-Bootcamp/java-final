package com.allianz.HealthTourismSpringBoot.mapper;

import com.allianz.HealthTourismSpringBoot.database.entities.PlaneEntity;
import com.allianz.HealthTourismSpringBoot.model.PlaneDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.PlaneRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaneMapper implements IBaseMapper<PlaneEntity, PlaneDTO, PlaneRequestDTO> {

    @Autowired
    @Lazy
    AirlineMapper airlineMapper;

    @Override
    public PlaneDTO entityToDTO(PlaneEntity entity) {

        PlaneDTO planeDTO = new PlaneDTO();
        planeDTO.setUuid(entity.getUuid());
        planeDTO.setId(entity.getId());
        planeDTO.setCreationDate(entity.getCreationDate());
        planeDTO.setUpdatedDate(entity.getUpdatedDate());
        planeDTO.setModel(entity.getModel());
        planeDTO.setTotalSeats(entity.getTotalSeats());
        planeDTO.setAvailableSeats(entity.getAvailableSeats());
        planeDTO.setAirline(airlineMapper.entityToDTO(entity.getAirline()));

        return planeDTO;
    }

    @Override
    public PlaneEntity dtoToEntity(PlaneDTO dto) {

        PlaneEntity planeEntity = new PlaneEntity();
        planeEntity.setUuid(dto.getUuid());
        planeEntity.setId(dto.getId());
        planeEntity.setCreationDate(dto.getCreationDate());
        planeEntity.setUpdatedDate(dto.getUpdatedDate());
        planeEntity.setModel(dto.getModel());
        planeEntity.setTotalSeats(dto.getTotalSeats());
        planeEntity.setAvailableSeats(dto.getAvailableSeats());
        planeEntity.setAirline(airlineMapper.dtoToEntity(dto.getAirline()));

        return planeEntity;
    }

    @Override
    public List<PlaneDTO> entityListToDTOList(List<PlaneEntity> planeEntities) {

        List<PlaneDTO> planeDTOList = new ArrayList<>();
        for (PlaneEntity entity : planeEntities){
            planeDTOList.add(entityToDTO(entity));
        }
        return planeDTOList;
    }

    @Override
    public List<PlaneEntity> dtoListToEntityList(List<PlaneDTO> planeDTOS) {

        List<PlaneEntity> planeEntityList = new ArrayList<>();
        for (PlaneDTO dto : planeDTOS){
            planeEntityList.add(dtoToEntity(dto));
        }
        return planeEntityList;
    }

    @Override
    public PlaneEntity requestDTOToEntity(PlaneRequestDTO planeRequestDTO) {

        PlaneEntity planeEntity = new PlaneEntity();
        planeEntity.setUuid(planeRequestDTO.getUuid());
        planeEntity.setId(planeRequestDTO.getId());
        planeEntity.setCreationDate(planeRequestDTO.getCreationDate());
        planeEntity.setUpdatedDate(planeRequestDTO.getUpdatedDate());
        planeEntity.setModel(planeRequestDTO.getModel());
        planeEntity.setTotalSeats(planeRequestDTO.getTotalSeats());
        planeEntity.setAvailableSeats(planeRequestDTO.getAvailableSeats());
        planeEntity.setAirline(airlineMapper.requestDTOToEntity(planeRequestDTO.getAirline()));

        return planeEntity;
    }

    @Override
    public List<PlaneEntity> requestDTOListToEntityList(List<PlaneRequestDTO> planeRequestDTOS) {

        List<PlaneEntity> planeEntityList = new ArrayList<>();
        for (PlaneRequestDTO requestDTO : planeRequestDTOS){
            planeEntityList.add(requestDTOToEntity(requestDTO));
        }
        return planeEntityList;
    }

    @Override
    public PlaneEntity requestDTOToExistEntity(PlaneRequestDTO planeRequestDTO, PlaneEntity entity) {

        entity.setModel(planeRequestDTO.getModel());
        entity.setTotalSeats(planeRequestDTO.getTotalSeats());
        entity.setAvailableSeats(planeRequestDTO.getAvailableSeats());
        entity.setAirline(airlineMapper.requestDTOToEntity(planeRequestDTO.getAirline()));

        return entity;
    }

    @Override
    public Page<PlaneDTO> pageEntityToPageDTO(Page<PlaneEntity> planeEntities) {
        return planeEntities.map((this::entityToDTO));
    }
}
