package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Seat;
import com.allianz.meliorator.database.repository.SeatRepository;
import com.allianz.meliorator.database.specification.SeatSpecification;
import com.allianz.meliorator.mapper.SeatMapper;
import com.allianz.meliorator.model.dto.SeatDTO;
import com.allianz.meliorator.model.requestDTO.SeatRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService extends BaseService<Seat, SeatDTO, SeatRequestDTO,
        SeatMapper, SeatRepository, SeatSpecification> {
    @Autowired
    SeatSpecification seatSpecification;
    @Autowired
    SeatMapper seatMapper;
    @Autowired
    SeatRepository seatRepository;
    @Override
    protected SeatMapper getMapper() {
        return this.seatMapper;
    }

    @Override
    protected SeatRepository getRepository() {
        return this.seatRepository;
    }

    @Override
    protected SeatSpecification getSpecification() {
        return this.seatSpecification;
    }
}
