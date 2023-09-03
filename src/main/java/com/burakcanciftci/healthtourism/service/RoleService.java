package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.RoleEntity;
import com.burakcanciftci.healthtourism.database.repository.RoleEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.RoleSpecification;
import com.burakcanciftci.healthtourism.mapper.RoleMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.RoleRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.RoleResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleService extends BaseService<RoleEntity, RoleResponseDTO, RoleRequestDTO> {

    private final RoleEntityRepository roleEntityRepository;
    private final RoleMapper roleMapper;
    private final RoleSpecification roleSpecification;

    @Override
    protected RoleMapper getMapper() {
        return this.roleMapper;
    }

    @Override
    protected RoleEntityRepository getRepository() {
        return this.roleEntityRepository;
    }

    @Override
    protected RoleSpecification getSpecification() {
        return roleSpecification;
    }
}