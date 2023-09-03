package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.SeatEntity;
import com.tourismcorp.healthtourism.database.repositories.SeatRepository;
import com.tourismcorp.healthtourism.database.specification.SeatSpecification;
import com.tourismcorp.healthtourism.mapper.SeatMapper;
import com.tourismcorp.healthtourism.model.SeatDTO;
import com.tourismcorp.healthtourism.model.requestDTO.SeatRequestDTO;
import com.tourismcorp.healthtourism.service.SeatService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    SeatService seatService;

    @Override
    protected SeatService getService() {
        return this.seatService;
    }
}
