package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Seat;
import com.allianz.meliorator.database.repository.SeatRepository;
import com.allianz.meliorator.mapper.SeatMapper;
import com.allianz.meliorator.model.dto.SeatDTO;
import com.allianz.meliorator.model.requestDTO.SeatRequestDTO;
import com.allianz.meliorator.service.SeatService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController extends BaseController<Seat, SeatDTO, SeatRequestDTO,
        SeatMapper, SeatRepository, SeatService> {
    @Autowired
    SeatService seatService;
    @Override
    protected SeatService getService() {
        return this.seatService;
    }
}
