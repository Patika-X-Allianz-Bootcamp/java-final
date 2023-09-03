package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.FlightEntity;
import com.example.healthtourismapp.database.entities.FlightSeatEntity;
import com.example.healthtourismapp.database.repositories.FlightRepository;
import com.example.healthtourismapp.database.specification.FlightSpecification;
import com.example.healthtourismapp.mapper.FlightMapper;
import com.example.healthtourismapp.model.FlightDTO;
import com.example.healthtourismapp.model.requestDTO.FlightRequestDTO;
import com.example.healthtourismapp.service.FlightService;
import com.example.healthtourismapp.util.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/flights")
public class FlightController extends BaseController<FlightEntity, FlightDTO, FlightRequestDTO,
        FlightMapper, FlightRepository, FlightSpecification, FlightService> {

    private final FlightService flightService;

    private final FlightRepository flightRepository;

    public FlightController(FlightService flightService, FlightRepository flightRepository) {
        this.flightService = flightService;
        this.flightRepository = flightRepository;
    }

    @Override
    protected FlightService getService() {
        return flightService;
    }

    @Override
    public ResponseEntity<FlightDTO> getByUuid(UUID uuid) {
        return super.getByUuid(uuid);
    }


    @GetMapping("/{flightUuid}/seat/{seatUuid}")
    public ResponseEntity<FlightSeatEntity> getFlightSeatByUuid(@PathVariable UUID flightUuid, @PathVariable UUID seatUuid) {
        Optional<FlightSeatEntity> seatOptional = flightService.selectFlightSeat(flightUuid, seatUuid);
        if (seatOptional.isPresent()) {
            return new ResponseEntity<>(seatOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
