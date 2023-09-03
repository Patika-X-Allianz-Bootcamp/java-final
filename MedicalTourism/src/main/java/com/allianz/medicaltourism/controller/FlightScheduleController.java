package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.FlightScheduleEntity;
import com.allianz.medicaltourism.database.repository.FlightScheduleEntityRepository;
import com.allianz.medicaltourism.database.specification.FlightScheduleSpecification;
import com.allianz.medicaltourism.mapper.FlightScheduleMapper;
import com.allianz.medicaltourism.model.DTO.FlightScheduleDTO;
import com.allianz.medicaltourism.model.requestDTO.FlightScheduleRequestDTO;
import com.allianz.medicaltourism.service.FlightScheduleService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flightSchedule")
public class FlightScheduleController extends BaseController<FlightScheduleEntity, FlightScheduleDTO, FlightScheduleRequestDTO, FlightScheduleMapper,
		FlightScheduleEntityRepository, FlightScheduleSpecification, FlightScheduleService> {

	@Autowired
	FlightScheduleService service;


	@Override
	protected FlightScheduleService getService() {
		return service;
	}
}
