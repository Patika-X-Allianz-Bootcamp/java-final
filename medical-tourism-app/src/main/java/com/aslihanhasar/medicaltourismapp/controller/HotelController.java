package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.dto.request.HotelSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.HotelSaveResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.HotelSearchResponse;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import com.aslihanhasar.medicaltourismapp.service.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;
    private final BaseResponseService baseResponseService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<HotelSearchResponse>>> getAllHotels(
            @RequestParam(defaultValue = "") String nameKey,
            @RequestParam(defaultValue = "") String cityNameKey) {
        List<HotelSearchResponse> hotels = hotelService.getAllHotels(nameKey, cityNameKey);
        return baseResponseService.createSuccessResponseList(hotels);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<HotelSaveResponse>> createHotel(
            @Valid @RequestBody HotelSaveRequest request) {
        HotelSaveResponse hotelSaveResponse = hotelService.save(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, hotelSaveResponse);
    }
}
