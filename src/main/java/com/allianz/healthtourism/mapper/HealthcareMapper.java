package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.HealthcareEntity;
import com.allianz.healthtourism.model.DTO.HealthcareDTO;
import com.allianz.healthtourism.model.DTO.PageDTO;
import com.allianz.healthtourism.model.requestDTO.HealthcareRequestDTO;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HealthcareMapper implements IBaseMapper<HealthcareDTO, HealthcareEntity, HealthcareRequestDTO> {
    @Override
    public HealthcareDTO entityToDTO(HealthcareEntity entity) {
        return null;
    }

    @Override
    public HealthcareEntity dtoToEntity(HealthcareDTO dto) {
        return null;
    }

    @Override
    public List<HealthcareDTO> entityListToDTOList(List<HealthcareEntity> HealthcareEntities) {
        return null;
    }

    @Override
    public List<HealthcareEntity> dtoListTOEntityList(List<HealthcareDTO> HealthcareDTOS) {
        return null;
    }

    @Override
    public HealthcareEntity requestDTOToEntity(HealthcareRequestDTO dto) {
        return null;
    }

    @Override
    public List<HealthcareEntity> requestDtoListTOEntityList(List<HealthcareRequestDTO> HealthcareRequestDTOS) {
        return null;
    }

    @Override
    public HealthcareEntity requestDtoToExistEntity(HealthcareEntity entity, HealthcareRequestDTO HealthcareRequestDTO) {
        return null;
    }

    @Override
    public HealthcareEntity dtoToExistEntity(HealthcareEntity entity, HealthcareDTO dto) {
        return null;
    }

    @Override
    public PageDTO<HealthcareDTO> pageEntityToPageDTO(Page<HealthcareEntity> HealthcareEntities) {
        return null;
    }
}