package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.BookingEntity;
import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.repository.BookingRepository;
import com.allianz.healthtourism.database.repository.CityRepository;
import com.allianz.healthtourism.database.specification.BookingSpecification;
import com.allianz.healthtourism.database.specification.CitySpecification;
import com.allianz.healthtourism.mapper.BookingMapper;
import com.allianz.healthtourism.mapper.CityMapper;
import com.allianz.healthtourism.model.requestDTO.BookingRequestDTO;
import com.allianz.healthtourism.model.requestDTO.CityRequestDTO;
import com.allianz.healthtourism.model.responseDTO.BookingResponseDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CityService extends BaseService<CityResponseDTO, CityRequestDTO, CityEntity, CityMapper, CityRepository, CitySpecification> {
    private final CityRepository repository;
    private final CitySpecification specification;
    @Override
    protected CityMapper getMapper() {
        return CityMapper.INSTANCE;
    }
    @Override
    protected CityRepository getRepository() {
        return repository;
    }
    @Override
    protected CitySpecification getSpecification() {
        return specification;
    }
}
