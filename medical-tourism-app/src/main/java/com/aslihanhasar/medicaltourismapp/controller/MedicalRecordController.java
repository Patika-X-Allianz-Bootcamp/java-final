package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.dto.request.MedicalRecordRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.MedicalRecordResponse;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import com.aslihanhasar.medicaltourismapp.service.MedicalRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;
    private final BaseResponseService baseResponseService;

    @PostMapping
    //@PreAuthorize("DOCTOR")
    public ResponseEntity<BaseResponse<MedicalRecordResponse>> createMedicalRecord(
            @Valid @RequestBody MedicalRecordRequest request) {
        MedicalRecordResponse medicalRecordResponse = medicalRecordService.createMedicalRecord(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, medicalRecordResponse);
    }
}
