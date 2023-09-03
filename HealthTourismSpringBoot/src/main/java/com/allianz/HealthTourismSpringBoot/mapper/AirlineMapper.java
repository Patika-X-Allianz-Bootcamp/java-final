package com.allianz.HealthTourismSpringBoot.mapper;

import com.allianz.HealthTourismSpringBoot.database.entities.AirlineEntity;
import com.allianz.HealthTourismSpringBoot.model.AirlineDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.AirlineRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirlineMapper implements IBaseMapper<AirlineEntity, AirlineDTO, AirlineRequestDTO> {

    @Autowired
    @Lazy
    AgencyMapper agencyMapper;

    @Override
    public AirlineDTO entityToDTO(AirlineEntity entity) {

        AirlineDTO airlineDTO = new AirlineDTO();
        airlineDTO.setUuid(entity.getUuid());
        airlineDTO.setId(entity.getId());
        airlineDTO.setCreationDate(entity.getCreationDate());
        airlineDTO.setUpdatedDate(entity.getUpdatedDate());
        airlineDTO.setName(entity.getName());
        airlineDTO.setAgency(agencyMapper.entityToDTO(entity.getAgency()));

        return airlineDTO;
    }

    @Override
    public AirlineEntity dtoToEntity(AirlineDTO dto) {

        AirlineEntity airlineEntity = new AirlineEntity();
        airlineEntity.setUuid(dto.getUuid());
        airlineEntity.setId(dto.getId());
        airlineEntity.setCreationDate(dto.getCreationDate());
        airlineEntity.setUpdatedDate(dto.getUpdatedDate());
        airlineEntity.setName(dto.getName());
        airlineEntity.setAgency(agencyMapper.dtoToEntity(dto.getAgency()));

        return airlineEntity;
    }

    @Override
    public List<AirlineDTO> entityListToDTOList(List<AirlineEntity> airlineEntities) {

        List<AirlineDTO> airlineDTOList = new ArrayList<>();
        for (AirlineEntity entity: airlineEntities){
            airlineDTOList.add(entityToDTO(entity));
        }

        return airlineDTOList;
    }

    @Override
    public List<AirlineEntity> dtoListToEntityList(List<AirlineDTO> airlineDTOS) {

        List<AirlineEntity> airlineEntityList = new ArrayList<>();
        for(AirlineDTO dto : airlineDTOS){
            airlineEntityList.add(dtoToEntity(dto));
        }

        return airlineEntityList;
    }

    @Override
    public AirlineEntity requestDTOToEntity(AirlineRequestDTO airlineRequestDTO) {

        AirlineEntity airlineEntity = new AirlineEntity();
        airlineEntity.setUuid(airlineRequestDTO.getUuid());
        airlineEntity.setId(airlineRequestDTO.getId());
        airlineEntity.setCreationDate(airlineRequestDTO.getCreationDate());
        airlineEntity.setUpdatedDate(airlineRequestDTO.getUpdatedDate());
        airlineEntity.setName(airlineRequestDTO.getName());
        airlineEntity.setAgency(agencyMapper.requestDTOToEntity(airlineRequestDTO.getAgency()));

        return airlineEntity;
    }

    @Override
    public List<AirlineEntity> requestDTOListToEntityList(List<AirlineRequestDTO> airlineRequestDTOS) {

        List<AirlineEntity> airlineEntityList = new ArrayList<>();
        for(AirlineRequestDTO requestDTO : airlineRequestDTOS){
            airlineEntityList.add(requestDTOToEntity(requestDTO));
        }

        return airlineEntityList;
    }

    @Override
    public AirlineEntity requestDTOToExistEntity(AirlineRequestDTO airlineRequestDTO, AirlineEntity entity) {

        entity.setName(airlineRequestDTO.getName());
        entity.setAgency(agencyMapper.requestDTOToEntity(airlineRequestDTO.getAgency()));

        return entity;
    }

    @Override
    public Page<AirlineDTO> pageEntityToPageDTO(Page<AirlineEntity> airlineEntities) {
        return airlineEntities.map(this::entityToDTO);
    }
}
