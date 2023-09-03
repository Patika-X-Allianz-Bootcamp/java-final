package com.aslihanhasar.medicaltourismapp.controller;

import com.aslihanhasar.medicaltourismapp.dto.request.AddDoctorToHospitalRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.HospitalDetailResponse;
import com.aslihanhasar.medicaltourismapp.dto.request.HospitalSaveRequest;
import com.aslihanhasar.medicaltourismapp.dto.response.AddDoctorToHospitalResponse;
import com.aslihanhasar.medicaltourismapp.dto.BaseResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.HospitalSaveResponse;
import com.aslihanhasar.medicaltourismapp.service.BaseResponseService;
import com.aslihanhasar.medicaltourismapp.service.HospitalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;
    private final BaseResponseService baseResponseService;

    @GetMapping()
    public ResponseEntity<BaseResponse<List<HospitalSaveResponse>>> getAllHospitals(
            @RequestParam(defaultValue = "") String searchKey) {
        List<HospitalSaveResponse> hospitals = hospitalService.getAllHospitals(searchKey);
        return baseResponseService.createSuccessResponseList(hospitals);
    }

    @GetMapping("/{hospitalId}")
    public ResponseEntity<BaseResponse<HospitalDetailResponse>> getHospitalDetails
            (@PathVariable("hospitalId") Long hospitalId) {
        HospitalDetailResponse hospitalDetailResponse = hospitalService.getHospitalDetails(hospitalId);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, hospitalDetailResponse);
    }

    @PostMapping("/create")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BaseResponse<HospitalSaveResponse>> createHospital(
            @Valid @RequestBody HospitalSaveRequest request) {
        HospitalSaveResponse hospitalSaveResponse = hospitalService.save(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, hospitalSaveResponse);
    }

    @PostMapping("/add-doctor")
    public ResponseEntity<BaseResponse<AddDoctorToHospitalResponse>> addAirlineToAirport(
            @RequestBody AddDoctorToHospitalRequest request) {
        AddDoctorToHospitalResponse hospitalSaveResponse = hospitalService.addDoctorToHospital(request);
        return baseResponseService.createSuccessResponse(HttpStatus.OK, hospitalSaveResponse);
    }
}
