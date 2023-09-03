package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.Flight;
import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.FlightRequestDTO;
import com.allianz.patienttourism.model.responseDTO.FlightResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends BaseService<Flight, FlightResponseDTO, FlightRequestDTO> {


    public FlightService(IBaseRepository<Flight> repository, MapperService mapperService, BaseSpecification<Flight> specification) {
        super(repository, mapperService, specification);
    }

    @Override
    protected Class<Flight> getEntityClass() {
        return Flight.class;
    }

    @Override
    protected Class<FlightResponseDTO> getResponseDTOClass() {
        return FlightResponseDTO.class;
    }
}
