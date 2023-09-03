package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.HospitalRoomEntity;
import com.allianz.medicaltourism.database.repository.HospitalRoomEntityRepository;
import com.allianz.medicaltourism.database.specification.HospitalRoomSpecification;
import com.allianz.medicaltourism.mapper.HospitalRoomMapper;
import com.allianz.medicaltourism.model.DTO.HospitalDTO;
import com.allianz.medicaltourism.model.DTO.HospitalRoomDTO;
import com.allianz.medicaltourism.model.requestDTO.HospitalRoomRequestDTO;
import com.allianz.medicaltourism.service.HospitalRoomService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hospitalroom")
public class HospitalRoomController extends BaseController<HospitalRoomEntity, HospitalRoomDTO, HospitalRoomRequestDTO, HospitalRoomMapper
		, HospitalRoomEntityRepository, HospitalRoomSpecification, HospitalRoomService> {
	@Autowired
	HospitalRoomService service;
	@Override
	protected HospitalRoomService getService() {
		return service;
	}
}
