package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.Patient;
import com.allianz.patienttourism.model.requestDTO.PatientRequestDTO;
import com.allianz.patienttourism.model.responseDTO.PatientResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<Patient, PatientResponseDTO, PatientRequestDTO> {
    public PatientController(BaseService<Patient, PatientResponseDTO, PatientRequestDTO> service) {
        super(service);
    }
}
