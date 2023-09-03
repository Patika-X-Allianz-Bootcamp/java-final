package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.request.FlightSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.FlightSaveResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.FlightSearchResponse;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import com.aslihanhasar.medicaltourismapp.service.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;
    private final BaseResponseService baseResponseService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<FlightSearchResponse>>> getAllFlights(
            @RequestParam(defaultValue = "") String departureKey,
            @RequestParam(defaultValue = "") String arrivalKey,
            @RequestParam(required = false) String departureDate) {
        List<FlightSearchResponse> flights = flightService.getAllFlights(departureKey, arrivalKey, departureDate);
        return baseResponseService.createSuccessResponseList(flights);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<FlightSaveResponse>> createFlight(
            @Valid @RequestBody FlightSaveRequest request) {
        FlightSaveResponse flightSaveResponse = flightService.save(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, flightSaveResponse);
    }
}
