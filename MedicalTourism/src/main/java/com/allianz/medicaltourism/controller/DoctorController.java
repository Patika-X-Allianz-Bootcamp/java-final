package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.DoctorEntity;
import com.allianz.medicaltourism.database.repository.DoctorEntityRepository;
import com.allianz.medicaltourism.database.specification.DoctorSpecification;
import com.allianz.medicaltourism.mapper.DoctorMapper;
import com.allianz.medicaltourism.model.DTO.DoctorDTO;
import com.allianz.medicaltourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.medicaltourism.service.DoctorService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<DoctorEntity, DoctorDTO, DoctorRequestDTO, DoctorMapper,
		DoctorEntityRepository, DoctorSpecification, DoctorService> {

	@Autowired
	DoctorService service;


	@Override
	protected DoctorService getService() {
		return service;
	}
}
