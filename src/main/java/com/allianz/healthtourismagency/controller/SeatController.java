package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.SeatEntity;
import com.allianz.healthtourismagency.database.repository.SeatRepository;
import com.allianz.healthtourismagency.database.specification.SeatSpecification;
import com.allianz.healthtourismagency.mapper.SeatMapper;
import com.allianz.healthtourismagency.model.SeatDTO;
import com.allianz.healthtourismagency.model.requestDTO.SeatRequestDTO;
import com.allianz.healthtourismagency.service.SeatService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seat")
public class SeatController extends BaseController<
        SeatEntity,
        SeatDTO,
        SeatRequestDTO,
        SeatMapper,
        SeatRepository,
        SeatSpecification,
        SeatService> {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @Override
    protected SeatService getService() {
        return seatService;
    }
}
