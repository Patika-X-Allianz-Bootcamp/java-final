package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.repository.DoctorRepository;
import com.allianz.healthtourism.mapper.DoctorMapper;
import com.allianz.healthtourism.model.DTO.DoctorDTO;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.service.DoctorService;
import com.allianz.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<DoctorEntity, DoctorDTO, DoctorRequestDTO,
        DoctorMapper, DoctorRepository, DoctorService> {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    protected DoctorService getService() {
        return doctorService;
    }
}
