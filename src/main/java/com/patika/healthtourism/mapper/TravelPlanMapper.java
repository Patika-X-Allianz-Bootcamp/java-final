package com.patika.healthtourism.mapper;

import com.patika.healthtourism.database.entity.TravelPlanEntity;
import com.patika.healthtourism.model.TravelPlanDTO;
import com.patika.healthtourism.model.requestDTO.TravelPlanRequestDTO;
import com.patika.healthtourism.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TravelPlanMapper extends IBaseMapper<TravelPlanEntity, TravelPlanDTO, TravelPlanRequestDTO> {
}
