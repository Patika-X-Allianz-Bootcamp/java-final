package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.MedicalReportEntity;
import com.allianz.healthtourismagency.database.repository.MedicalReportRepository;
import com.allianz.healthtourismagency.database.specification.MedicalReportSpecification;
import com.allianz.healthtourismagency.mapper.MedicalReportMapper;
import com.allianz.healthtourismagency.model.DoctorDTO;
import com.allianz.healthtourismagency.model.MedicalReportDTO;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.MedicalReportRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.MedicationRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.TestResultRequestDTO;
import com.allianz.healthtourismagency.service.MedicalReportService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("medical-report")
public class MedicalReportController extends BaseController<
        MedicalReportEntity,
        MedicalReportDTO,
        MedicalReportRequestDTO,
        MedicalReportMapper,
        MedicalReportRepository,
        MedicalReportSpecification,
        MedicalReportService> {

    private final MedicalReportService medicalReportService;

    public MedicalReportController(MedicalReportService medicalReportService) {
        this.medicalReportService = medicalReportService;
    }

    @Override
    protected MedicalReportService getService() {
        return medicalReportService;
    }

    @PutMapping("add-medication-to-medical-report/{uuid}")
    public ResponseEntity<MedicalReportDTO> addMedicationToMedicalReport(@PathVariable UUID uuid, @RequestBody MedicationRequestDTO medicationRequestDTO) {
        if (getService().addMedicationToMedicalReport(uuid, medicationRequestDTO) != null) {
            return new ResponseEntity<>(getService().addMedicationToMedicalReport(uuid, medicationRequestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("add-test-result-to-medical-report/{uuid}")
    public ResponseEntity<MedicalReportDTO> addTestResultToMedicalReport(@PathVariable UUID uuid, @RequestBody TestResultRequestDTO testResultRequestDTO) {
        if (getService().addTestResultToMedicalReport(uuid, testResultRequestDTO) != null) {
            return new ResponseEntity<>(getService().addTestResultToMedicalReport(uuid, testResultRequestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
