package com.tourismcorp.healthtourism.service;

import com.tourismcorp.healthtourism.database.entities.SeatEntity;
import com.tourismcorp.healthtourism.database.repositories.SeatRepository;
import com.tourismcorp.healthtourism.database.specification.SeatSpecification;
import com.tourismcorp.healthtourism.mapper.SeatMapper;
import com.tourismcorp.healthtourism.model.SeatDTO;
import com.tourismcorp.healthtourism.model.requestDTO.SeatRequestDTO;
import com.tourismcorp.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService extends BaseService<
        SeatEntity,
        SeatDTO,
        SeatRequestDTO,
        SeatMapper,
        SeatRepository,
        SeatSpecification> {


    private final SeatRepository seatRepository;

    private final SeatMapper seatMapper;

    private final SeatSpecification seatSpecification;

    @Autowired
    public SeatService(SeatRepository seatRepository, SeatMapper seatMapper, SeatSpecification seatSpecification) {
        this.seatRepository = seatRepository;
        this.seatMapper = seatMapper;
        this.seatSpecification = seatSpecification;
    }

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
