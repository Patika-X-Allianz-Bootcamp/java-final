package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.DoctorEntity;
import com.example.healthtourismapp.database.repositories.DoctorRepository;
import com.example.healthtourismapp.database.specification.DoctorSpecification;
import com.example.healthtourismapp.mapper.DoctorMapper;
import com.example.healthtourismapp.model.DoctorDTO;
import com.example.healthtourismapp.model.requestDTO.DoctorRequestDTO;
import com.example.healthtourismapp.service.DoctorService;
import com.example.healthtourismapp.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/doctors")
public class DoctorController extends BaseController<DoctorEntity, DoctorDTO, DoctorRequestDTO,
        DoctorMapper, DoctorRepository, DoctorSpecification, DoctorService> {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    protected DoctorService getService() {
        return doctorService;
    }


}
