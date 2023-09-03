package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.repository.FlightRepository;
import com.allianz.healthtourism.database.specification.FlightSpecification;
import com.allianz.healthtourism.mapper.FlightMapper;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.model.responseDTO.FlightForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.FlightResponseDTO;
import com.allianz.healthtourism.service.FlightService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("flight")
@RequiredArgsConstructor
public class FlightController extends BaseController<FlightRequestDTO, FlightResponseDTO, FlightEntity, FlightMapper, FlightRepository, FlightSpecification, FlightService> {
    private final FlightService service;

    @Override
    protected FlightService getService() {
        return service;
    }


    @GetMapping("city/{cityFromName}/{cityToName}")
    public ResponseEntity<List<FlightForPatientResponseDTO>> getByUuid(@PathVariable String cityFromName, @PathVariable String cityToName) {
        try {
            List<FlightForPatientResponseDTO> responseDTOs = getService().findByCityName(cityFromName, cityToName);
            return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
