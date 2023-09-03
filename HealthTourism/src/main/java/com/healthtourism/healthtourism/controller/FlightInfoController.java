package com.healthtourism.healthtourism.controller;

import com.healthtourism.healthtourism.Specification.FlightInfoSpecification;
import com.healthtourism.healthtourism.database.entities.FlightInfoEntity;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.database.repositories.FlightInfoRepository;
import com.healthtourism.healthtourism.database.repositories.PatientRepository;
import com.healthtourism.healthtourism.mapper.FlightInfoMapper;
import com.healthtourism.healthtourism.model.FlightInfoDTO;
import com.healthtourism.healthtourism.model.RequestDTO.DoctorRequestDTO;
import com.healthtourism.healthtourism.model.RequestDTO.FlightInfoRequestDTO;
import com.healthtourism.healthtourism.service.FlightInfoService;
import com.healthtourism.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/flightInfo")
public class FlightInfoController extends BaseController<
        FlightInfoEntity,
        FlightInfoDTO,
        FlightInfoRequestDTO,
        FlightInfoMapper,
        FlightInfoRepository,
        FlightInfoService,
        FlightInfoSpecification> {
    @Autowired
    FlightInfoService flightInfoService;
    @Autowired
    PatientRepository patientRepository;

    @Override
    protected FlightInfoService getService() {
        return flightInfoService;
    }



    @PostMapping("/create")
    public ResponseEntity<Boolean> createFlight (@RequestBody FlightInfoRequestDTO flightInfoRequestDTO) {
        boolean isCreated = flightInfoService.createFlight(
                flightInfoRequestDTO.getAirlineCompany(),
                flightInfoRequestDTO.getFlightNumber(),
                flightInfoRequestDTO.getArrivalCity(),
                flightInfoRequestDTO.getDepartureCity(),
                flightInfoRequestDTO.getArrivalDateTime(),
                flightInfoRequestDTO.getDepartureDateTime(),
                flightInfoRequestDTO.getPatientUuids()

        );

        if (isCreated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }



    @PostMapping("/approve/{flightUuid}")
    public ResponseEntity<String> approveReservation(@RequestParam UUID flightUuid) {
        boolean isApproved = flightInfoService.approveReservation(flightUuid);

        if (isApproved) {
            return new ResponseEntity<>("Reservation approved successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Reservation could not be approved.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/make-reservation/{flightUuid}")
    public ResponseEntity<FlightInfoDTO> makeReservation(
            @RequestParam UUID flightUuid,
            @RequestParam UUID patientUuid) {

        FlightInfoDTO reservationResult = flightInfoService.makeReservation(flightUuid, patientUuid);

        if (reservationResult != null) {
            return new ResponseEntity<>(reservationResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/invalidate-unconfirmed-reservations")
    public ResponseEntity<String> invalidateUnconfirmedReservations() {
        flightInfoService.invalidateUnconfirmedReservations();
        return new ResponseEntity<>("Unconfirmed reservations invalidated.", HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<FlightInfoDTO>> getAllFlights() {
        List<FlightInfoDTO> allFlights = flightInfoService.getAllFlights();
        return new ResponseEntity<>(allFlights, HttpStatus.OK);
    }


}
