package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.PlaneEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.PlaneRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.PlaneResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PlaneMapper extends BaseMapper<PlaneResponseDTO, PlaneEntity, PlaneRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(PlaneEntity.class, PlaneResponseDTO.class);
    }
}