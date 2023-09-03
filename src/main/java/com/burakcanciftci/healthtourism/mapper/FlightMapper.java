package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.FlightEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.FlightRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.FlightResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper extends BaseMapper<FlightResponseDTO, FlightEntity, FlightRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(FlightEntity.class, FlightResponseDTO.class);
    }
}