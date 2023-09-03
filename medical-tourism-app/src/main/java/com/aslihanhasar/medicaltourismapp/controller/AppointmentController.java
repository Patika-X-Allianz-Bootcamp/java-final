package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.request.AppointmentSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.AppointmentSaveResponse;
import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.service.AppointmentService;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final BaseResponseService baseResponseService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<AppointmentSaveResponse>>> getAllAppointments(
            @RequestParam(defaultValue = "") String searchKey) {
        List<AppointmentSaveResponse> appointments = appointmentService.getAllAppointments(searchKey);
        return baseResponseService.createSuccessResponseList(appointments);
    }

    @PostMapping("/create")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponse<AppointmentSaveResponse>> createAppointment(
            @Valid @RequestBody AppointmentSaveRequest request) {
        AppointmentSaveResponse appointmentSaveResponse = appointmentService.save(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, appointmentSaveResponse);
    }

}
