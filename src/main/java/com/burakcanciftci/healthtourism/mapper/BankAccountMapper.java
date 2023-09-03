package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.BankAccountEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.BankAccountRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.BankAccountResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper extends BaseMapper<BankAccountResponseDTO, BankAccountEntity, BankAccountRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(BankAccountEntity.class, BankAccountResponseDTO.class);
    }
}