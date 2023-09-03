package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.DepartmentEntity;
import com.allianz.medicaltourism.database.repository.DepartmentEntityRepository;
import com.allianz.medicaltourism.database.specification.DepartmentSpecification;
import com.allianz.medicaltourism.mapper.DepartmentMapper;
import com.allianz.medicaltourism.model.DTO.DepartmentDTO;
import com.allianz.medicaltourism.model.requestDTO.DepartmentRequestDTO;
import com.allianz.medicaltourism.service.DepartmentService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("department")
public class DepartmentController extends BaseController<DepartmentEntity, DepartmentDTO, DepartmentRequestDTO, DepartmentMapper,
		DepartmentEntityRepository, DepartmentSpecification, DepartmentService> {

	@Autowired
	DepartmentService service;


	@Override
	protected DepartmentService getService() {
		return service;
	}
}
