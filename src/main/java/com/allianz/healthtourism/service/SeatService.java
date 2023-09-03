package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.SeatEntity;
import com.allianz.healthtourism.database.repository.SeatRepository;
import com.allianz.healthtourism.database.specification.SeatSpecification;
import com.allianz.healthtourism.mapper.SeatMapper;
import com.allianz.healthtourism.model.requestDTO.SeatRequestDTO;
import com.allianz.healthtourism.model.responseDTO.SeatResponseDTO;
import com.allianz.healthtourism.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SeatService extends BaseService<SeatResponseDTO, SeatRequestDTO, SeatEntity, SeatMapper, SeatRepository, SeatSpecification> {
    private final SeatRepository repository;
    private final SeatSpecification specification;

    @Override
    protected SeatMapper getMapper() {
        return SeatMapper.INSTANCE;
    }

    @Override
    protected SeatRepository getRepository() {
        return repository;
    }

    @Override
    protected SeatSpecification getSpecification() {
        return specification;
    }
}
