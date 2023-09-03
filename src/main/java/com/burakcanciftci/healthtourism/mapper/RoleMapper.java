package com.burakcanciftci.healthtourism.mapper;

import com.burakcanciftci.healthtourism.database.entity.RoleEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.RoleRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.RoleResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper extends BaseMapper<RoleResponseDTO, RoleEntity, RoleRequestDTO> {

    @PostConstruct
    public void set(){
        this.init(RoleEntity.class, RoleResponseDTO.class);
    }
}