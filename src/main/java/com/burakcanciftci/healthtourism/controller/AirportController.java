package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.AirportEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.AirportRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.AirportResponseDTO;
import com.burakcanciftci.healthtourism.service.AirportService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("airport")
@AllArgsConstructor
public class AirportController extends BaseController<AirportEntity, AirportResponseDTO, AirportRequestDTO> {
    private final AirportService airportService;

    @Override
    protected AirportService getService() {
        return this.airportService;
    }
}
