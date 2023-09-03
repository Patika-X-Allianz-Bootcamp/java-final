package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.ExaminationCardEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.ExaminationCardRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.ExaminationCardResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ExaminationCardMapper
        extends BaseMapper<ExaminationCardResponseDTO, ExaminationCardEntity, ExaminationCardRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(ExaminationCardEntity.class, ExaminationCardResponseDTO.class);
    }
}