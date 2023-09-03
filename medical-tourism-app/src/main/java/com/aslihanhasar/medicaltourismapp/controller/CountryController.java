package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.request.CountrySaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.CountrySaveResponse;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import com.aslihanhasar.medicaltourismapp.service.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;
    private final BaseResponseService baseResponseService;

    @PostMapping("/create")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponse<CountrySaveResponse>> createCountry(
            @Valid @RequestBody CountrySaveRequest request) {
        CountrySaveResponse countrySaveResponse = countryService.save(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, countrySaveResponse);
    }

}
