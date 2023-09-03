package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.TravelPlanEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.TravelPlanRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.TravelPlanResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TravelPlanMapper extends BaseMapper<TravelPlanResponseDTO, TravelPlanEntity, TravelPlanRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(TravelPlanEntity.class, TravelPlanResponseDTO.class);
    }
}