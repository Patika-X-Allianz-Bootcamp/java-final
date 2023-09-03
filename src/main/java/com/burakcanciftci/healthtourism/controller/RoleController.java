package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.RoleEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.RoleRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.RoleResponseDTO;
import com.burakcanciftci.healthtourism.service.RoleService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
@AllArgsConstructor
public class RoleController extends BaseController<RoleEntity, RoleResponseDTO, RoleRequestDTO> {
    private final RoleService roleService;

    @Override
    protected RoleService getService() {
        return this.roleService;
    }
}
