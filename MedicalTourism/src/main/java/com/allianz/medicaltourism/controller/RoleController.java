package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.RoleEntity;
import com.allianz.medicaltourism.database.repository.RoleEntityRepository;
import com.allianz.medicaltourism.database.specification.RoleSpecification;
import com.allianz.medicaltourism.mapper.RoleMapper;
import com.allianz.medicaltourism.model.DTO.RoleDTO;
import com.allianz.medicaltourism.model.requestDTO.RoleRequestDTO;
import com.allianz.medicaltourism.service.RoleService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController extends BaseController<RoleEntity, RoleDTO, RoleRequestDTO, RoleMapper,
		RoleEntityRepository, RoleSpecification, RoleService> {
	@Autowired
	RoleService service;
	@Override
	protected RoleService getService() {
		return service;
	}
}
