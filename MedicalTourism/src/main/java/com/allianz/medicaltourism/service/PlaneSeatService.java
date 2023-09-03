package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.PlaneSeatEntity;
import com.allianz.medicaltourism.database.repository.PlaneSeatEntityRepository;
import com.allianz.medicaltourism.database.specification.PlaneSeatSpecification;
import com.allianz.medicaltourism.mapper.PlaneSeatMapper;
import com.allianz.medicaltourism.model.DTO.PlaneSeatDTO;
import com.allianz.medicaltourism.model.requestDTO.PlaneSeatRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlaneSeatService extends BaseService<PlaneSeatEntity, PlaneSeatDTO, PlaneSeatRequestDTO,
		PlaneSeatMapper, PlaneSeatEntityRepository, PlaneSeatSpecification> {
	private final PlaneSeatMapper mapper;
	private final PlaneSeatEntityRepository repository;
	private final PlaneSeatSpecification specification;

	@Override
	protected PlaneSeatMapper getMapper() {
		return mapper;
	}

	@Override
	protected PlaneSeatEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected PlaneSeatSpecification getSpecification() {
		return specification;
	}
}
