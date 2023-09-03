package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.FlightScheduleEntity;
import com.allianz.medicaltourism.database.repository.FlightScheduleEntityRepository;
import com.allianz.medicaltourism.database.specification.FlightScheduleSpecification;
import com.allianz.medicaltourism.mapper.FlightScheduleMapper;
import com.allianz.medicaltourism.model.DTO.FlightScheduleDTO;
import com.allianz.medicaltourism.model.requestDTO.FlightScheduleRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlightScheduleService extends BaseService<FlightScheduleEntity, FlightScheduleDTO, FlightScheduleRequestDTO,
		FlightScheduleMapper, FlightScheduleEntityRepository, FlightScheduleSpecification> {
	private final FlightScheduleMapper mapper;
	private final FlightScheduleEntityRepository repository;
	private final FlightScheduleSpecification specification;

	@Override
	protected FlightScheduleMapper getMapper() {
		return mapper;
	}

	@Override
	protected FlightScheduleEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected FlightScheduleSpecification getSpecification() {
		return specification;
	}
}
