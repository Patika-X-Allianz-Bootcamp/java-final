package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.request.AddAirlineToAirportRequest;
import com.aslihanhasar.medicaltourismapp.dto.request.AirportSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.AddAirlineToAirportResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.AirportDetailResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.AirportSaveResponse;
import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.service.AirportService;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;
    private final BaseResponseService baseResponseService;

    @GetMapping()
    public ResponseEntity<BaseResponse<List<AirportSaveResponse>>> getAllAirports(
            @RequestParam(defaultValue = "") String searchKey) {
        List<AirportSaveResponse> airports = airportService.getAllAirports(searchKey);
        return baseResponseService.createSuccessResponseList(airports);
    }

    @GetMapping("/{airportId}")
    public ResponseEntity<BaseResponse<AirportDetailResponse>> getAirportDetails
            (@PathVariable("airportId") Long airportId) {
        AirportDetailResponse airportDetailResponse = airportService.getAirportDetails(airportId);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, airportDetailResponse);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AirportSaveResponse>> createAirport(
            @Valid @RequestBody AirportSaveRequest request) {
        AirportSaveResponse airportSaveResponse = airportService.save(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, airportSaveResponse);
    }

    @PostMapping("/add-airline")
    public ResponseEntity<BaseResponse<AddAirlineToAirportResponse>> addAirlineToAirport(
            @RequestBody AddAirlineToAirportRequest request) {
        AddAirlineToAirportResponse airportSaveResponse = airportService.addAirlineToAirport(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, airportSaveResponse);
    }

}
