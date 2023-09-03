package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.HotelEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.HotelRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.HotelResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper extends BaseMapper<HotelResponseDTO, HotelEntity, HotelRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(HotelEntity.class, HotelResponseDTO.class);
    }
}