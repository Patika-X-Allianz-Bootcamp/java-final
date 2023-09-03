package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.RoleEntity;
import com.tourismcorp.healthtourism.database.repositories.RoleRepository;
import com.tourismcorp.healthtourism.database.specification.RoleSpecification;
import com.tourismcorp.healthtourism.mapper.RoleMapper;
import com.tourismcorp.healthtourism.model.RoleDTO;
import com.tourismcorp.healthtourism.model.requestDTO.RoleRequestDTO;
import com.tourismcorp.healthtourism.service.RoleService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController extends BaseController<
        RoleEntity,
        RoleDTO,
        RoleRequestDTO,
        RoleMapper,
        RoleRepository,
        RoleSpecification,
        RoleService> {

    @Autowired
    RoleService roleService;

    @Override
    protected RoleService getService() {
        return this.roleService;
    }
}
