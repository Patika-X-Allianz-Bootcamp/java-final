package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.FlightEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.FlightRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.FlightResponseDTO;
import com.burakcanciftci.healthtourism.service.FlightService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
@AllArgsConstructor
public class FlightController extends BaseController<FlightEntity, FlightResponseDTO, FlightRequestDTO> {
    private final FlightService flightService;

    @Override
    protected FlightService getService() {
        return this.flightService;
    }
}
