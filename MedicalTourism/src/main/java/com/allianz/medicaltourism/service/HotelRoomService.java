package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.DoctorEntity;
import com.allianz.medicaltourism.database.entity.HotelRoomEntity;
import com.allianz.medicaltourism.database.repository.DoctorEntityRepository;
import com.allianz.medicaltourism.database.repository.HotelRoomEntityRepository;
import com.allianz.medicaltourism.database.specification.DoctorSpecification;
import com.allianz.medicaltourism.database.specification.HotelRoomSpecification;
import com.allianz.medicaltourism.mapper.DoctorMapper;
import com.allianz.medicaltourism.mapper.HotelRoomMapper;
import com.allianz.medicaltourism.model.DTO.DoctorDTO;
import com.allianz.medicaltourism.model.DTO.HotelRoomDTO;
import com.allianz.medicaltourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.HotelRoomRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HotelRoomService extends BaseService<HotelRoomEntity, HotelRoomDTO, HotelRoomRequestDTO,
		HotelRoomMapper, HotelRoomEntityRepository, HotelRoomSpecification> {
	private final HotelRoomMapper mapper;
	private final HotelRoomEntityRepository repository;
	private final HotelRoomSpecification specification;

	@Override
	protected HotelRoomMapper getMapper() {
		return mapper;
	}

	@Override
	protected HotelRoomEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected HotelRoomSpecification getSpecification() {
		return specification;
	}
}
