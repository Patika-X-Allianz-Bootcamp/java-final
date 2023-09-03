package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.DoctorEntity;
import com.allianz.medicaltourism.database.repository.DoctorEntityRepository;
import com.allianz.medicaltourism.database.specification.DoctorSpecification;
import com.allianz.medicaltourism.mapper.DoctorMapper;
import com.allianz.medicaltourism.model.DTO.DoctorDTO;
import com.allianz.medicaltourism.model.requestDTO.DoctorRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorService extends BaseService<DoctorEntity, DoctorDTO, DoctorRequestDTO,
		DoctorMapper, DoctorEntityRepository, DoctorSpecification> {
	private final DoctorMapper mapper;
	private final DoctorEntityRepository repository;
	private final DoctorSpecification specification;

	@Override
	protected DoctorMapper getMapper() {
		return mapper;
	}

	@Override
	protected DoctorEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected DoctorSpecification getSpecification() {
		return specification;
	}
}
