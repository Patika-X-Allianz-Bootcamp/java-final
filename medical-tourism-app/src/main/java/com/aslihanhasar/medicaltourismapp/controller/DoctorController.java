package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.request.DoctorSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.DoctorSaveResponse;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import com.aslihanhasar.medicaltourismapp.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    private final BaseResponseService baseResponseService;

    @PostMapping("/create")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponse<DoctorSaveResponse>> createDoctor(
            @Valid @RequestBody DoctorSaveRequest request) {
        DoctorSaveResponse doctorSaveResponse = doctorService.save(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, doctorSaveResponse);
    }


}
