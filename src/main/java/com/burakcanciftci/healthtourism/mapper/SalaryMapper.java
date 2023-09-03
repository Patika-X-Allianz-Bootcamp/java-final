package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.SalaryEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.SalaryRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.SalaryResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SalaryMapper extends BaseMapper<SalaryResponseDTO, SalaryEntity, SalaryRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(SalaryEntity.class, SalaryResponseDTO.class);
    }
}