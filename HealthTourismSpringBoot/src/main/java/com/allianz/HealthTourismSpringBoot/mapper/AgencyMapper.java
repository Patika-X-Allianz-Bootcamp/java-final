package com.allianz.HealthTourismSpringBoot.mapper;

import com.allianz.HealthTourismSpringBoot.database.entities.AgencyEntity;
import com.allianz.HealthTourismSpringBoot.model.AgencyDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.AgencyRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AgencyMapper implements IBaseMapper<AgencyEntity, AgencyDTO, AgencyRequestDTO> {


    @Override
    public AgencyDTO entityToDTO(AgencyEntity entity) {

        AgencyDTO agencyDTO= new AgencyDTO();
        agencyDTO.setUuid(entity.getUuid());
        agencyDTO.setId(entity.getId());
        agencyDTO.setCreationDate(entity.getCreationDate());
        agencyDTO.setUpdatedDate(entity.getUpdatedDate());
        agencyDTO.setName(entity.getName());

        return agencyDTO;
    }

    @Override
    public AgencyEntity dtoToEntity(AgencyDTO dto) {

        AgencyEntity agencyEntity = new AgencyEntity();
        agencyEntity.setUuid(dto.getUuid());
        agencyEntity.setId(dto.getId());
        agencyEntity.setCreationDate(dto.getCreationDate());
        agencyEntity.setUpdatedDate(dto.getUpdatedDate());
        agencyEntity.setName(dto.getName());

        return agencyEntity;
    }

    @Override
    public List<AgencyDTO> entityListToDTOList(List<AgencyEntity> agencyEntities) {

        List<AgencyDTO> agencyDTOList = new ArrayList<>();
        for (AgencyEntity entity: agencyEntities){
            agencyDTOList.add(entityToDTO(entity));
        }

        return agencyDTOList;
    }

    @Override
    public List<AgencyEntity> dtoListToEntityList(List<AgencyDTO> agencyDTOS) {

        List<AgencyEntity> agencyEntityList = new ArrayList<>();
        for (AgencyDTO dto : agencyDTOS){
            agencyEntityList.add(dtoToEntity(dto));
        }

        return agencyEntityList;
    }

    @Override
    public AgencyEntity requestDTOToEntity(AgencyRequestDTO agencyRequestDTO) {

        AgencyEntity agencyEntity = new AgencyEntity();
        agencyEntity.setUuid(agencyRequestDTO.getUuid());
        agencyEntity.setId(agencyRequestDTO.getId());
        agencyEntity.setCreationDate(agencyRequestDTO.getCreationDate());
        agencyEntity.setUpdatedDate(agencyRequestDTO.getUpdatedDate());
        agencyEntity.setName(agencyRequestDTO.getName());

        return agencyEntity;
    }

    @Override
    public List<AgencyEntity> requestDTOListToEntityList(List<AgencyRequestDTO> agencyRequestDTOS) {

        List<AgencyEntity> agencyEntityList = new ArrayList<>();
        for (AgencyRequestDTO requestDTO : agencyRequestDTOS){
            agencyEntityList.add(requestDTOToEntity(requestDTO));
        }

        return agencyEntityList;
    }

    @Override
    public AgencyEntity requestDTOToExistEntity(AgencyRequestDTO agencyRequestDTO, AgencyEntity entity) {

        entity.setName(agencyRequestDTO.getName());

        return entity;
    }

    @Override
    public Page<AgencyDTO> pageEntityToPageDTO(Page<AgencyEntity> agencyEntities) {
        return agencyEntities.map(this::entityToDTO);
    }
}
