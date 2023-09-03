package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.DoctorEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.DoctorResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper extends BaseMapper<DoctorResponseDTO, DoctorEntity, DoctorRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(DoctorEntity.class, DoctorResponseDTO.class);
    }
}