package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.DoctorEntity;
import com.allianz.medicaltourism.database.entity.RoleEntity;
import com.allianz.medicaltourism.database.repository.DoctorEntityRepository;
import com.allianz.medicaltourism.database.repository.RoleEntityRepository;
import com.allianz.medicaltourism.database.specification.DoctorSpecification;
import com.allianz.medicaltourism.database.specification.RoleSpecification;
import com.allianz.medicaltourism.mapper.DoctorMapper;
import com.allianz.medicaltourism.mapper.RoleMapper;
import com.allianz.medicaltourism.model.DTO.DoctorDTO;
import com.allianz.medicaltourism.model.DTO.RoleDTO;
import com.allianz.medicaltourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.RoleRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService extends BaseService<RoleEntity, RoleDTO, RoleRequestDTO,
		RoleMapper, RoleEntityRepository, RoleSpecification> {
	private final RoleMapper mapper;
	private final RoleEntityRepository repository;
	private final RoleSpecification specification;

	@Override
	protected RoleMapper getMapper() {
		return mapper;
	}

	@Override
	protected RoleEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected RoleSpecification getSpecification() {
		return specification;
	}
}
