package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Role;
import com.allianz.meliorator.database.repository.RoleRepository;
import com.allianz.meliorator.database.specification.RoleSpecification;
import com.allianz.meliorator.mapper.RoleMapper;
import com.allianz.meliorator.model.dto.RoleDTO;
import com.allianz.meliorator.model.requestDTO.RoleRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleResult;

@Service
public class RoleService extends BaseService<Role, RoleDTO, RoleRequestDTO, RoleMapper,
        RoleRepository, RoleSpecification> {
    @Autowired
    RoleSpecification roleSpecification;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleMapper roleMapper;

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
        return null;
    }
}
