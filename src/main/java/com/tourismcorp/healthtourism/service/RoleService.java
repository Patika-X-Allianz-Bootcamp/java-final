package com.tourismcorp.healthtourism.service;

import com.tourismcorp.healthtourism.database.entities.RoleEntity;
import com.tourismcorp.healthtourism.database.repositories.RoleRepository;
import com.tourismcorp.healthtourism.database.specification.RoleSpecification;
import com.tourismcorp.healthtourism.mapper.RoleMapper;
import com.tourismcorp.healthtourism.model.RoleDTO;
import com.tourismcorp.healthtourism.model.requestDTO.RoleRequestDTO;
import com.tourismcorp.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<
        RoleEntity,
        RoleDTO,
        RoleRequestDTO,
        RoleMapper,
        RoleRepository,
        RoleSpecification>{


    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    private final RoleSpecification roleSpecification;

    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper, RoleSpecification roleSpecification) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.roleSpecification = roleSpecification;
    }

    @Override
    protected RoleMapper getMapper() {
        return this.roleMapper;
    }

    @Override
    protected RoleRepository getRepository() {
        return this.roleRepository;
    }

    @Override
    protected RoleSpecification getSpecification() {
        return this.roleSpecification;
    }
}
