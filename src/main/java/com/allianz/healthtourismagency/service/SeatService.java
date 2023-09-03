package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.SeatEntity;
import com.allianz.healthtourismagency.database.repository.SeatRepository;
import com.allianz.healthtourismagency.database.specification.SeatSpecification;
import com.allianz.healthtourismagency.mapper.SeatMapper;
import com.allianz.healthtourismagency.model.SeatDTO;
import com.allianz.healthtourismagency.model.requestDTO.SeatRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SeatService extends BaseService<SeatEntity, SeatDTO, SeatRequestDTO, SeatMapper, SeatRepository,
        SeatSpecification> {

    private final SeatMapper seatMapper;
    private final SeatRepository seatRepository;
    private final SeatSpecification seatSpecification;

    public SeatService(SeatMapper seatMapper, SeatRepository seatRepository, SeatSpecification seatSpecification) {
        this.seatMapper = seatMapper;
        this.seatRepository = seatRepository;
        this.seatSpecification = seatSpecification;
    }


    @Override
    protected SeatMapper getMapper() {
        return seatMapper;
    }

    @Override
    protected SeatRepository getRepository() {
        return seatRepository;
    }

    @Override
    protected SeatSpecification getSpecification() {
        return seatSpecification;
    }
}
