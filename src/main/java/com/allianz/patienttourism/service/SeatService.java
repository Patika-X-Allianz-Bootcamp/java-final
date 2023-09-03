package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.Seat;
import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.SeatRequestDTO;
import com.allianz.patienttourism.model.responseDTO.SeatResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatService extends BaseService<Seat, SeatResponseDTO, SeatRequestDTO> {

    public SeatService(IBaseRepository<Seat> repository, MapperService mapperService, BaseSpecification<Seat> specification) {
        super(repository, mapperService, specification);
    }

    @Override
    protected Class<Seat> getEntityClass() {
        return Seat.class;
    }

    @Override
    protected Class<SeatResponseDTO> getResponseDTOClass() {
        return SeatResponseDTO.class;
    }
}
