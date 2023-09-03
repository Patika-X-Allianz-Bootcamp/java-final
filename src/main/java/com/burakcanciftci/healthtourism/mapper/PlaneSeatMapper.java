package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.PlaneSeatEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.PlaneSeatRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.PlaneSeatResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PlaneSeatMapper extends BaseMapper<PlaneSeatResponseDTO, PlaneSeatEntity, PlaneSeatRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(PlaneSeatEntity.class, PlaneSeatResponseDTO.class);
    }
}