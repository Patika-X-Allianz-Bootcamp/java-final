package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.dto.request.AppointmentPlanRequest;
import com.aslihanhasar.medicaltourismapp.dto.request.HotelPlanRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.AppointmentPlanResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.HotelPlanResponse;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import com.aslihanhasar.medicaltourismapp.service.TravelPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travel-plan")
@RequiredArgsConstructor
public class TravelPlanController {
    private final TravelPlanService travelPlanService;
    private final BaseResponseService baseResponseService;

    @PostMapping("/create-appointment-plan")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<BaseResponse<AppointmentPlanResponse>> createAppointmentPlan(
            @Valid @RequestBody AppointmentPlanRequest request) {
        AppointmentPlanResponse appointmentPlanResponse = travelPlanService.saveAppointmentPlan(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, appointmentPlanResponse);
    }

    @PostMapping("/confirm-appointment/{appointmentNumber}/{patientNumber}")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<BaseResponse<String>> confirmAppointment(
            @PathVariable String appointmentNumber,
            @PathVariable String patientNumber) {
        travelPlanService.confirmAppointmentPlan(appointmentNumber, patientNumber);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, "Checked in.");
    }

    @PostMapping("/create-hotel-plan")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<BaseResponse<HotelPlanResponse>> createHotelPlan(
            @Valid @RequestBody HotelPlanRequest request) {
        HotelPlanResponse hotelPlanResponse = travelPlanService.saveHotelPlan(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, hotelPlanResponse);
    }

    @PostMapping("/confirm-hotel/{reservationNumber}")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<BaseResponse<String>> confirmHotel(
            @PathVariable String reservationNumber) {
        travelPlanService.confirmHotelPlan(reservationNumber);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, "Checked in.");
    }
}
