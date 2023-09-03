package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.repository.PatientRepository;
import com.allianz.healthtourism.database.specification.PatientSpecification;
import com.allianz.healthtourism.mapper.PatientMapper;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorResponseDTO;
import com.allianz.healthtourism.model.responseDTO.PatientResponseDTO;
import com.allianz.healthtourism.service.PatientService;
import com.allianz.healthtourism.util.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
@RequiredArgsConstructor
public class PatientController extends BaseController<PatientRequestDTO, PatientResponseDTO, PatientEntity, PatientMapper, PatientRepository, PatientSpecification, PatientService> {
    private final PatientService service;

    @Override
    protected PatientService getService() {
        return service;
    }

    @PostMapping("register")
    public ResponseEntity<PatientResponseDTO> saveUser(@RequestBody PatientRequestDTO body) {
        PatientResponseDTO responseDTO = service.saveUserByRole(body);
        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
