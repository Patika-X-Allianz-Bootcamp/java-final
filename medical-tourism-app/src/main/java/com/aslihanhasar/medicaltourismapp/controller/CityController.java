package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.request.CitySaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.CitySaveResponse;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import com.aslihanhasar.medicaltourismapp.service.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;
    private final BaseResponseService baseResponseService;

    @PostMapping("/create")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponse<CitySaveResponse>> createCity(
            @Valid @RequestBody CitySaveRequest request) {
        CitySaveResponse citySaveResponse = cityService.save(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, citySaveResponse);
    }
}
