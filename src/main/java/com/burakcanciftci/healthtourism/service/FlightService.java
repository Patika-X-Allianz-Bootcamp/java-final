package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.FlightEntity;
import com.burakcanciftci.healthtourism.database.repository.FlightEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.FlightSpecification;
import com.burakcanciftci.healthtourism.mapper.FlightMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.FlightRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.FlightResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FlightService extends BaseService<FlightEntity, FlightResponseDTO, FlightRequestDTO> {

    private final FlightEntityRepository flightEntityRepository;
    private final FlightMapper flightMapper;
    private final FlightSpecification flightSpecification;

    @Override
    protected FlightMapper getMapper() {
        return this.flightMapper;
    }

    @Override
    protected FlightEntityRepository getRepository() {
        return this.flightEntityRepository;
    }

    @Override
    protected FlightSpecification getSpecification() {
        return flightSpecification;
    }
}