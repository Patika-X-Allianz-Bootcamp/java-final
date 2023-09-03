package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.HospitalEntity;
import com.allianz.medicaltourism.database.repository.HospitalEntityRepository;
import com.allianz.medicaltourism.database.specification.HospitalSpecification;
import com.allianz.medicaltourism.mapper.HospitalMapper;
import com.allianz.medicaltourism.model.DTO.HospitalDTO;
import com.allianz.medicaltourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.medicaltourism.service.HospitalService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController<HospitalEntity, HospitalDTO, HospitalRequestDTO, HospitalMapper,
		HospitalEntityRepository, HospitalSpecification, HospitalService> {

	@Autowired
	HospitalService service;
	@Override
	protected HospitalService getService() {
		return service;
	}
}
