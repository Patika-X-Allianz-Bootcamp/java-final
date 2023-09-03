package com.healthtourism.healthtourism.controller;

import com.healthtourism.healthtourism.Specification.PatientSpecification;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.database.repositories.PatientRepository;
import com.healthtourism.healthtourism.mapper.PatientMapper;
import com.healthtourism.healthtourism.model.PatientDTO;
import com.healthtourism.healthtourism.model.RequestDTO.PatientRequestDTO;
import com.healthtourism.healthtourism.service.PatientService;
import com.healthtourism.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patient")
public class PatientController extends BaseController<PatientEntity,
        PatientDTO,
        PatientRequestDTO,
        PatientMapper,
        PatientRepository,
        PatientService,
        PatientSpecification> {

    @Autowired
    PatientService patientService;
    @Override
    protected PatientService getService() {
        return patientService;
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        boolean isCreated = patientService.createPatient(
                patientRequestDTO.getFirstName(),
                patientRequestDTO.getLastName(),
                patientRequestDTO.getGender(),
                patientRequestDTO.getDateOfBirth(),
                patientRequestDTO.getPhoneNumber()
        );

        if (isCreated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }


}
