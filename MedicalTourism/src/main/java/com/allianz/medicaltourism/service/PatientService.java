package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.DoctorEntity;
import com.allianz.medicaltourism.database.entity.PatientEntity;
import com.allianz.medicaltourism.database.repository.DoctorEntityRepository;
import com.allianz.medicaltourism.database.repository.PatientEntityRepository;
import com.allianz.medicaltourism.database.specification.DoctorSpecification;
import com.allianz.medicaltourism.database.specification.PatientSpecification;
import com.allianz.medicaltourism.mapper.DoctorMapper;
import com.allianz.medicaltourism.mapper.PatientMapper;
import com.allianz.medicaltourism.model.DTO.DoctorDTO;
import com.allianz.medicaltourism.model.DTO.PatientDTO;
import com.allianz.medicaltourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PatientRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService extends BaseService<PatientEntity, PatientDTO, PatientRequestDTO,
		PatientMapper, PatientEntityRepository, PatientSpecification> {
	private final PatientMapper mapper;
	private final PatientEntityRepository repository;
	private final PatientSpecification specification;

	@Override
	protected PatientMapper getMapper() {
		return mapper;
	}

	@Override
	protected PatientEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected PatientSpecification getSpecification() {
		return specification;
	}
}
