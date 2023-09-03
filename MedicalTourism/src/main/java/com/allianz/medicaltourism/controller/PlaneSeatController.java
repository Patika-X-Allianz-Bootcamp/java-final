package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.PlaneSeatEntity;
import com.allianz.medicaltourism.database.repository.PlaneSeatEntityRepository;
import com.allianz.medicaltourism.database.specification.PlaneSeatSpecification;
import com.allianz.medicaltourism.mapper.PlaneSeatMapper;
import com.allianz.medicaltourism.model.DTO.PlaneSeatDTO;
import com.allianz.medicaltourism.model.requestDTO.PlaneSeatRequestDTO;
import com.allianz.medicaltourism.service.PlaneSeatService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("planeseat")
public class PlaneSeatController extends BaseController<PlaneSeatEntity, PlaneSeatDTO, PlaneSeatRequestDTO, PlaneSeatMapper,
		PlaneSeatEntityRepository, PlaneSeatSpecification, PlaneSeatService> {

	@Autowired
	PlaneSeatService service;

	@Override
	protected PlaneSeatService getService() {
		return service;
	}
}
