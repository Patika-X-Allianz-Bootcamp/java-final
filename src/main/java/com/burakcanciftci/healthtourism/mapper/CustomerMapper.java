package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.CustomerEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.CustomerRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.CustomerResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper extends BaseMapper<CustomerResponseDTO, CustomerEntity, CustomerRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(CustomerEntity.class, CustomerResponseDTO.class);
    }
}