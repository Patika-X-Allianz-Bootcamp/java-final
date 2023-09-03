package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.AppointmentEntity;
import com.allianz.medicaltourism.database.repository.AppointmentEntityRepository;
import com.allianz.medicaltourism.database.specification.AppointmentSpecification;
import com.allianz.medicaltourism.mapper.AppointmentMapper;
import com.allianz.medicaltourism.model.DTO.AppointmentDTO;
import com.allianz.medicaltourism.model.requestDTO.AppointmentRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService extends BaseService<AppointmentEntity, AppointmentDTO, AppointmentRequestDTO,
		AppointmentMapper, AppointmentEntityRepository, AppointmentSpecification> {
	private final AppointmentMapper mapper;
	private final AppointmentEntityRepository repository;
	private final AppointmentSpecification specification;

	@Override
	protected AppointmentMapper getMapper() {
		return mapper;
	}

	@Override
	protected AppointmentEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected AppointmentSpecification getSpecification() {
		return specification;
	}
}
