package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Doctor;
import com.allianz.meliorator.database.repository.DoctorRepository;
import com.allianz.meliorator.mapper.DoctorMapper;
import com.allianz.meliorator.model.dto.DoctorDTO;
import com.allianz.meliorator.model.requestDTO.DoctorRequestDTO;
import com.allianz.meliorator.service.DoctorService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController extends BaseController<Doctor, DoctorDTO, DoctorRequestDTO, DoctorMapper,
        DoctorRepository, DoctorService> {
    @Autowired
    DoctorService doctorService;
    @Override
    protected DoctorService getService() {
        return this.doctorService;
    }
}
