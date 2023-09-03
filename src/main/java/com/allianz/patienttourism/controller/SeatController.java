package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.Seat;
import com.allianz.patienttourism.model.requestDTO.SeatRequestDTO;
import com.allianz.patienttourism.model.responseDTO.SeatResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("seat")
public class SeatController extends BaseController<Seat, SeatResponseDTO, SeatRequestDTO> {
    public SeatController(BaseService<Seat, SeatResponseDTO, SeatRequestDTO> service) {
        super(service);
    }
}
