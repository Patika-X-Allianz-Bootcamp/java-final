package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.PatientEntity;
import com.allianz.medicaltourism.database.entity.PlaneEntity;
import com.allianz.medicaltourism.database.repository.PatientEntityRepository;
import com.allianz.medicaltourism.database.repository.PlaneEntityRepository;
import com.allianz.medicaltourism.database.specification.PatientSpecification;
import com.allianz.medicaltourism.database.specification.PlaneSpecification;
import com.allianz.medicaltourism.mapper.PatientMapper;
import com.allianz.medicaltourism.mapper.PlaneMapper;
import com.allianz.medicaltourism.model.DTO.PatientDTO;
import com.allianz.medicaltourism.model.DTO.PlaneDTO;
import com.allianz.medicaltourism.model.requestDTO.PatientRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PlaneRequestDTO;
import com.allianz.medicaltourism.service.PatientService;
import com.allianz.medicaltourism.service.PlaneService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("plane")
public class PlaneController extends BaseController<PlaneEntity, PlaneDTO, PlaneRequestDTO, PlaneMapper,
		PlaneEntityRepository, PlaneSpecification, PlaneService> {

	@Autowired
	PlaneService service;

	@Override
	protected PlaneService getService() {
		return service;
	}
}
