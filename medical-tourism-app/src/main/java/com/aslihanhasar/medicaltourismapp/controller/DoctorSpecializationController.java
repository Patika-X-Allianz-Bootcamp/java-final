package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.request.DoctorSpecializationSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.DoctorSpecializationSaveResponse;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import com.aslihanhasar.medicaltourismapp.service.DoctorSpecializationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/specializations")
@RequiredArgsConstructor
public class DoctorSpecializationController {
    private final DoctorSpecializationService specializationService;
    private final BaseResponseService baseResponseService;

    @PostMapping("/create")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponse<DoctorSpecializationSaveResponse>> createSpecialization(
            @Valid @RequestBody DoctorSpecializationSaveRequest request) {
        DoctorSpecializationSaveResponse specializationSaveResponse = specializationService.save(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, specializationSaveResponse);
    }
}
