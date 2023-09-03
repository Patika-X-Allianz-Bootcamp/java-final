package com.patika.healthtourism.mapper;

import com.patika.healthtourism.database.entity.HealthServiceEntity;
import com.patika.healthtourism.model.HealthServiceDTO;
import com.patika.healthtourism.model.requestDTO.HealthServiceRequestDTO;
import com.patika.healthtourism.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HealthServiceMapper extends IBaseMapper<HealthServiceEntity, HealthServiceDTO, HealthServiceRequestDTO> {
}
