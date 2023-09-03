package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.Doctor;
import com.allianz.patienttourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.patienttourism.model.responseDTO.DoctorResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<Doctor, DoctorResponseDTO, DoctorRequestDTO> {
    public DoctorController(BaseService<Doctor, DoctorResponseDTO, DoctorRequestDTO> service) {
        super(service);
    }
}
