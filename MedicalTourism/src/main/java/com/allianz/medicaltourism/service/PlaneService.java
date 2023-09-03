package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.DoctorEntity;
import com.allianz.medicaltourism.database.entity.PlaneEntity;
import com.allianz.medicaltourism.database.repository.DoctorEntityRepository;
import com.allianz.medicaltourism.database.repository.PlaneEntityRepository;
import com.allianz.medicaltourism.database.specification.DoctorSpecification;
import com.allianz.medicaltourism.database.specification.PlaneSpecification;
import com.allianz.medicaltourism.mapper.DoctorMapper;
import com.allianz.medicaltourism.mapper.PlaneMapper;
import com.allianz.medicaltourism.model.DTO.DoctorDTO;
import com.allianz.medicaltourism.model.DTO.PlaneDTO;
import com.allianz.medicaltourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PlaneRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlaneService extends BaseService<PlaneEntity, PlaneDTO, PlaneRequestDTO,
		PlaneMapper, PlaneEntityRepository, PlaneSpecification> {
	private final PlaneMapper mapper;
	private final PlaneEntityRepository repository;
	private final PlaneSpecification specification;

	@Override
	protected PlaneMapper getMapper() {
		return mapper;
	}

	@Override
	protected PlaneEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected PlaneSpecification getSpecification() {
		return specification;
	}
}
