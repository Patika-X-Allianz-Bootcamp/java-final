package com.allianz.medicaltourism.service;

import com.allianz.medicaltourism.database.entity.DoctorEntity;
import com.allianz.medicaltourism.database.entity.HotelEntity;
import com.allianz.medicaltourism.database.repository.DoctorEntityRepository;
import com.allianz.medicaltourism.database.repository.HotelEntityRepository;
import com.allianz.medicaltourism.database.specification.DoctorSpecification;
import com.allianz.medicaltourism.database.specification.HotelSpecification;
import com.allianz.medicaltourism.mapper.DoctorMapper;
import com.allianz.medicaltourism.mapper.HotelMapper;
import com.allianz.medicaltourism.model.DTO.DoctorDTO;
import com.allianz.medicaltourism.model.DTO.HotelDTO;
import com.allianz.medicaltourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.HotelRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HotelService extends BaseService<HotelEntity, HotelDTO, HotelRequestDTO,
		HotelMapper, HotelEntityRepository, HotelSpecification> {
	private final HotelMapper mapper;
	private final HotelEntityRepository repository;
	private final HotelSpecification specification;

	@Override
	protected HotelMapper getMapper() {
		return mapper;
	}

	@Override
	protected HotelEntityRepository getRepository() {
		return repository;
	}

	@Override
	protected HotelSpecification getSpecification() {
		return specification;
	}
}
