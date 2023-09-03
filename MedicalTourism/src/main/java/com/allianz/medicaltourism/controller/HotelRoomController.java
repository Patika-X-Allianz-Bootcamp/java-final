package com.allianz.medicaltourism.controller;

import com.allianz.medicaltourism.database.entity.HotelEntity;
import com.allianz.medicaltourism.database.entity.HotelRoomEntity;
import com.allianz.medicaltourism.database.repository.HotelEntityRepository;
import com.allianz.medicaltourism.database.repository.HotelRoomEntityRepository;
import com.allianz.medicaltourism.database.specification.HotelRoomSpecification;
import com.allianz.medicaltourism.database.specification.HotelSpecification;
import com.allianz.medicaltourism.mapper.HotelMapper;
import com.allianz.medicaltourism.mapper.HotelRoomMapper;
import com.allianz.medicaltourism.model.DTO.HotelDTO;
import com.allianz.medicaltourism.model.DTO.HotelRoomDTO;
import com.allianz.medicaltourism.model.requestDTO.HotelRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.HotelRoomRequestDTO;
import com.allianz.medicaltourism.service.HotelRoomService;
import com.allianz.medicaltourism.service.HotelService;
import com.allianz.medicaltourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotelroom")
public class HotelRoomController extends BaseController<HotelRoomEntity, HotelRoomDTO, HotelRoomRequestDTO, HotelRoomMapper,
		HotelRoomEntityRepository, HotelRoomSpecification, HotelRoomService> {

	@Autowired
	HotelRoomService service;

	@Override
	protected HotelRoomService getService() {
		return service;
	}
}
