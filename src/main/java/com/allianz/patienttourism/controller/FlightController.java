package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.Flight;
import com.allianz.patienttourism.model.requestDTO.FlightRequestDTO;
import com.allianz.patienttourism.model.responseDTO.FlightResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController extends BaseController<Flight, FlightResponseDTO, FlightRequestDTO> {
    public FlightController(BaseService<Flight, FlightResponseDTO, FlightRequestDTO> service) {
        super(service);
    }
}
