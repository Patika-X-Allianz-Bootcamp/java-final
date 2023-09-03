package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.HospitalEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.HospitalResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class HospitalMapper extends BaseMapper<HospitalResponseDTO, HospitalEntity, HospitalRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(HospitalEntity.class, HospitalResponseDTO.class);
    }
}