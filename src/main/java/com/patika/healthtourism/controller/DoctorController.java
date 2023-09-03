package com.patika.healthtourism.controller;

import com.patika.healthtourism.database.entity.DoctorEntity;
import com.patika.healthtourism.database.repository.DoctorEntityRepository;
import com.patika.healthtourism.mapper.DoctorMapper;
import com.patika.healthtourism.model.DoctorDTO;
import com.patika.healthtourism.model.requestDTO.DoctorCreateRequestDTO;
import com.patika.healthtourism.service.DoctorService;
import com.patika.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController extends BaseController<DoctorEntity, DoctorDTO, DoctorCreateRequestDTO,
        DoctorMapper, DoctorEntityRepository, DoctorService> {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    protected DoctorService getService() {
        return doctorService;
    }

}
