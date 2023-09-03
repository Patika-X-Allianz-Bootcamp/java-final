package com.healthtourism.healthtourism.mapper;

import com.healthtourism.healthtourism.database.entities.HealthServiceEntity;
import com.healthtourism.healthtourism.model.HealthServiceDTO;
import com.healthtourism.healthtourism.model.RequestDTO.HealthServiceRequestDTO;
import com.healthtourism.healthtourism.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HealthServiceMapper implements IBaseMapper<HealthServiceEntity, HealthServiceDTO, HealthServiceRequestDTO> {

    @Override
    public HealthServiceDTO entityToDTO(HealthServiceEntity entity) {
        HealthServiceDTO dto = new HealthServiceDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setServiceName(entity.getServiceName());
        dto.setDescription(entity.getDescription());
        dto.setServicePrice(entity.getServicePrice());
        return dto;
    }

    @Override
    public HealthServiceEntity dtoToEntity(HealthServiceDTO dto) {
        HealthServiceEntity entity = new HealthServiceEntity();
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setServiceName(dto.getServiceName());
        entity.setDescription(dto.getDescription());
        entity.setServicePrice(dto.getServicePrice());
        return entity;
    }

    @Override
    public List<HealthServiceDTO> entityListToDTOList(List<HealthServiceEntity> entityList) {
        List<HealthServiceDTO> dtoList = new ArrayList<>();
        for (HealthServiceEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<HealthServiceEntity> dtoListToEntityList(List<HealthServiceDTO> dtoList) {
        List<HealthServiceEntity> entityList = new ArrayList<>();
        for (HealthServiceDTO dto : dtoList) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public HealthServiceEntity requestDTOToEntity(HealthServiceRequestDTO requestDTO) {
        HealthServiceEntity entity = new HealthServiceEntity();
        entity.setServiceName(requestDTO.getServiceName());
        entity.setDescription(requestDTO.getDescription());
        entity.setServicePrice(requestDTO.getServicePrice());
        return entity;
    }

    @Override
    public List<HealthServiceEntity> requestDTOListToEntityList(List<HealthServiceRequestDTO> dtoList) {
        List<HealthServiceEntity> entityList = new ArrayList<>();
        for (HealthServiceRequestDTO requestDTO : dtoList) {
            entityList.add(requestDTOToEntity(requestDTO));
        }
        return entityList;
    }

    @Override
    public HealthServiceEntity requestDTOToExistEntity(HealthServiceRequestDTO requestDTO, HealthServiceEntity entity) {
        entity.setServiceName(requestDTO.getServiceName());
        entity.setDescription(requestDTO.getDescription());
        entity.setServicePrice(requestDTO.getServicePrice());
        return entity;
    }
}
