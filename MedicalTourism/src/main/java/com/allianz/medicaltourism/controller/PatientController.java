package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.HotelEntity;
import com.allianz.medicaltourism.database.entity.PatientEntity;
import com.allianz.medicaltourism.database.repository.HotelEntityRepository;
import com.allianz.medicaltourism.database.repository.PatientEntityRepository;
import com.allianz.medicaltourism.database.specification.HotelSpecification;
import com.allianz.medicaltourism.database.specification.PatientSpecification;
import com.allianz.medicaltourism.mapper.HotelMapper;
import com.allianz.medicaltourism.mapper.PatientMapper;
import com.allianz.medicaltourism.model.DTO.HotelDTO;
import com.allianz.medicaltourism.model.DTO.PatientDTO;
import com.allianz.medicaltourism.model.requestDTO.HotelRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PatientRequestDTO;
import com.allianz.medicaltourism.service.HotelService;
import com.allianz.medicaltourism.service.PatientService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<PatientEntity, PatientDTO, PatientRequestDTO, PatientMapper,
		PatientEntityRepository, PatientSpecification, PatientService> {

	@Autowired
	PatientService service;

	@Override
	protected PatientService getService() {
		return service;
	}
}
