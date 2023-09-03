package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.HealthCareServiceEntity;
import com.allianz.healthtourism.model.requestDTO.HealthCareServiceRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HealthCareServiceResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HealthCareServiceMapper extends BaseMapper<HealthCareServiceEntity, HealthCareServiceResponseDTO, HealthCareServiceRequestDTO> {
    HealthCareServiceMapper INSTANCE = Mappers.getMapper(HealthCareServiceMapper.class);
}
