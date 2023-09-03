package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.AppointmentEntity;
import com.allianz.medicaltourism.database.repository.AppointmentEntityRepository;
import com.allianz.medicaltourism.database.specification.AppointmentSpecification;
import com.allianz.medicaltourism.mapper.AppointmentMapper;
import com.allianz.medicaltourism.model.DTO.AppointmentDTO;
import com.allianz.medicaltourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.medicaltourism.service.AppointmentService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController extends BaseController<AppointmentEntity, AppointmentDTO, AppointmentRequestDTO, AppointmentMapper,
		AppointmentEntityRepository, AppointmentSpecification, AppointmentService> {

	@Autowired
	AppointmentService service;


	@Override
	protected AppointmentService getService() {
		return service;
	}
}
