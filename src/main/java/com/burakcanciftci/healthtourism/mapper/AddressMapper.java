package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.AddressEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.AddressRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.AddressResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper extends BaseMapper<AddressResponseDTO, AddressEntity, AddressRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(AddressEntity.class, AddressResponseDTO.class);
    }
}