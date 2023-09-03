package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.AirportEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.AirportRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.AirportResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AirportMapper extends BaseMapper<AirportResponseDTO, AirportEntity, AirportRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(AirportEntity.class, AirportResponseDTO.class);
    }
}