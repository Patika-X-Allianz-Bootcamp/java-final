package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.ExaminationEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.ExaminationRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.ExaminationResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ExaminationMapper
        extends BaseMapper<ExaminationResponseDTO, ExaminationEntity, ExaminationRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(ExaminationEntity.class, ExaminationResponseDTO.class);
    }
}