package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.TravelPlanEntity;
import com.allianz.healthtourismagency.model.TravelPlanDTO;
import com.allianz.healthtourismagency.model.requestDTO.TravelPlanRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TravelPlanMapper extends IBaseMapper<TravelPlanEntity, TravelPlanDTO, TravelPlanRequestDTO> {

}
