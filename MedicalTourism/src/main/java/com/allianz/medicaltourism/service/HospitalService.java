package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.HospitalEntity;
import com.allianz.medicaltourism.database.repository.HospitalEntityRepository;
import com.allianz.medicaltourism.database.specification.HospitalSpecification;
import com.allianz.medicaltourism.mapper.HospitalMapper;
import com.allianz.medicaltourism.model.DTO.HospitalDTO;
import com.allianz.medicaltourism.model.requestDTO.HospitalRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HospitalService extends BaseService<HospitalEntity, HospitalDTO, HospitalRequestDTO,
		HospitalMapper, HospitalEntityRepository, HospitalSpecification> {
	private final HospitalEntityRepository hospitalEntityRepository;
	private final HospitalMapper hospitalMapper;
	private final HospitalSpecification hospitalSpecification;

	@Override
	protected HospitalMapper getMapper() {
		return hospitalMapper;
	}

	@Override
	protected HospitalEntityRepository getRepository() {
		return hospitalEntityRepository;
	}

	@Override
	protected HospitalSpecification getSpecification() {
		return hospitalSpecification;
	}
}
