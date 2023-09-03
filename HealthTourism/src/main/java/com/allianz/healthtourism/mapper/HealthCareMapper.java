package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.HealthCareEntity;
import com.allianz.healthtourism.model.DTO.HealthCareDTO;
import com.allianz.healthtourism.model.DTO.PageDTO;
import com.allianz.healthtourism.model.requestDTO.HealthCareRequestDTO;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HealthCareMapper implements IBaseMapper<HealthCareDTO, HealthCareEntity, HealthCareRequestDTO> {
    @Override
    public HealthCareDTO entityToDTO(HealthCareEntity entity) {
        return null;
    }

    @Override
    public HealthCareEntity dtoToEntity(HealthCareDTO dto) {
        return null;
    }

    @Override
    public List<HealthCareDTO> entityListToDTOList(List<HealthCareEntity> healthCareEntities) {
        return null;
    }

    @Override
    public List<HealthCareEntity> dtoListTOEntityList(List<HealthCareDTO> healthCareDTOS) {
        return null;
    }

    @Override
    public HealthCareEntity requestDTOToEntity(HealthCareRequestDTO dto) {
        return null;
    }

    @Override
    public List<HealthCareEntity> requestDtoListTOEntityList(List<HealthCareRequestDTO> healthCareRequestDTOS) {
        return null;
    }

    @Override
    public HealthCareEntity requestDtoToExistEntity(HealthCareEntity entity, HealthCareRequestDTO healthCareRequestDTO) {
        return null;
    }

    @Override
    public HealthCareEntity dtoToExistEntity(HealthCareEntity entity, HealthCareDTO dto) {
        return null;
    }

    @Override
    public PageDTO<HealthCareDTO> pageEntityToPageDTO(Page<HealthCareEntity> healthCareEntities) {
        return null;
    }
}
