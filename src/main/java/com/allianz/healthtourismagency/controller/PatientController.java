package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.PatientEntity;
import com.allianz.healthtourismagency.database.repository.PatientRepository;
import com.allianz.healthtourismagency.database.specification.PatientSpecification;
import com.allianz.healthtourismagency.mapper.PatientMapper;
import com.allianz.healthtourismagency.model.DoctorDTO;
import com.allianz.healthtourismagency.model.PatientDTO;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourismagency.service.PatientService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<
        PatientEntity,
        PatientDTO,
        PatientRequestDTO,
        PatientMapper,
        PatientRepository,
        PatientSpecification,
        PatientService> {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    protected PatientService getService() {
        return patientService;
    }

    @PutMapping("add-medical-report-to-patient/{patientUuid}/medical-report/{medicalReportUuid}")
    public ResponseEntity<PatientDTO> addMedicalReportToPatient(@PathVariable UUID patientUuid, @PathVariable UUID medicalReportUuid) {
        if (getService().addMedicalReportToPatient(patientUuid, medicalReportUuid) != null) {
            return new ResponseEntity<>(getService().addMedicalReportToPatient(patientUuid, medicalReportUuid), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
