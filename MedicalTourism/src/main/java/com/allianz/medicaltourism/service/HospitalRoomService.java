package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.HospitalRoomEntity;
import com.allianz.medicaltourism.database.repository.HospitalRoomEntityRepository;
import com.allianz.medicaltourism.database.specification.HospitalRoomSpecification;
import com.allianz.medicaltourism.mapper.HospitalRoomMapper;
import com.allianz.medicaltourism.model.DTO.HospitalRoomDTO;
import com.allianz.medicaltourism.model.requestDTO.HospitalRoomRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HospitalRoomService extends BaseService<HospitalRoomEntity, HospitalRoomDTO, HospitalRoomRequestDTO,
		HospitalRoomMapper, HospitalRoomEntityRepository, HospitalRoomSpecification> {
	private final HospitalRoomMapper mapper;
	private final HospitalRoomEntityRepository repository;
	private final HospitalRoomSpecification specification;

	@Override
	protected HospitalRoomMapper getMapper() {
		return mapper;
	}

	@Override
	protected HospitalRoomEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected HospitalRoomSpecification getSpecification() {
		return specification;
	}
}
