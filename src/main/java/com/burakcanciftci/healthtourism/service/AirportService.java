package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.AirportEntity;
import com.burakcanciftci.healthtourism.database.entity.FlightEntity;
import com.burakcanciftci.healthtourism.database.entity.PlaneSeatEntity;
import com.burakcanciftci.healthtourism.database.repository.AirportEntityRepository;
import com.burakcanciftci.healthtourism.database.repository.FlightEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.AirportSpecification;
import com.burakcanciftci.healthtourism.mapper.AirportMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.AirportRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.AirportResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AirportService extends BaseService<AirportEntity, AirportResponseDTO, AirportRequestDTO> {

    private final AirportEntityRepository airportEntityRepository;
    private final AirportMapper airportMapper;
    private final AirportSpecification airportSpecification;

    @Override
    protected AirportMapper getMapper() {
        return this.airportMapper;
    }

    @Override
    protected AirportEntityRepository getRepository() {
        return this.airportEntityRepository;
    }

    @Override
    protected AirportSpecification getSpecification() {
        return airportSpecification;
    }
}