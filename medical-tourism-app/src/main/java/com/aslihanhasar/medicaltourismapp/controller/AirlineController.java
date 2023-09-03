package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.request.AirlineSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.AirlineSaveResponse;
import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.service.AirlineService;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airlines")
@RequiredArgsConstructor
public class AirlineController {
    private final AirlineService airlineService;
    private final BaseResponseService baseResponseService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<AirlineSaveResponse>>> getAllAirlines(
            @RequestParam(defaultValue = "") String searchKey) {
        List<AirlineSaveResponse> airlines = airlineService.getAllAirlines(searchKey);
        return baseResponseService.createSuccessResponseList(airlines);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<AirlineSaveResponse>> createAirline(
            @Valid @RequestBody AirlineSaveRequest request) {
        AirlineSaveResponse airlineSaveResponse = airlineService.save(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, airlineSaveResponse);
    }
}



