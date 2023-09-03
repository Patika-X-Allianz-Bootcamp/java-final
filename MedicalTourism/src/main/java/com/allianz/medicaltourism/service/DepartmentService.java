package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.DepartmentEntity;
import com.allianz.medicaltourism.database.repository.DepartmentEntityRepository;
import com.allianz.medicaltourism.database.specification.DepartmentSpecification;
import com.allianz.medicaltourism.mapper.DepartmentMapper;
import com.allianz.medicaltourism.model.DTO.DepartmentDTO;
import com.allianz.medicaltourism.model.requestDTO.DepartmentRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService extends BaseService<DepartmentEntity, DepartmentDTO, DepartmentRequestDTO,
		DepartmentMapper, DepartmentEntityRepository, DepartmentSpecification> {
	private final DepartmentMapper mapper;
	private final DepartmentEntityRepository repository;
	private final DepartmentSpecification specification;

	@Override
	protected DepartmentMapper getMapper() {
		return mapper;
	}

	@Override
	protected DepartmentEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected DepartmentSpecification getSpecification() {
		return specification;
	}
}
