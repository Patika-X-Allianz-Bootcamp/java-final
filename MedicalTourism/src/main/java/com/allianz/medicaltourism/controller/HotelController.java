package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.HotelEntity;
import com.allianz.medicaltourism.database.repository.HotelEntityRepository;
import com.allianz.medicaltourism.database.specification.HotelSpecification;
import com.allianz.medicaltourism.mapper.HotelMapper;
import com.allianz.medicaltourism.model.DTO.HotelDTO;
import com.allianz.medicaltourism.model.requestDTO.HotelRequestDTO;
import com.allianz.medicaltourism.service.HotelService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<HotelEntity, HotelDTO, HotelRequestDTO, HotelMapper,
		HotelEntityRepository, HotelSpecification, HotelService> {

	@Autowired
	HotelService service;

	@Override
	protected HotelService getService() {
		return service;
	}
}
