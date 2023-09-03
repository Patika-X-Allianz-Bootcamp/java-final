package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.DoctorEntity;
import com.tourismcorp.healthtourism.database.repositories.DoctorRepository;
import com.tourismcorp.healthtourism.database.specification.DoctorSpecification;
import com.tourismcorp.healthtourism.mapper.DoctorMapper;
import com.tourismcorp.healthtourism.model.DoctorDTO;
import com.tourismcorp.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.tourismcorp.healthtourism.service.DoctorService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification,
        DoctorService> {

    @Autowired
    DoctorService doctorService;

    @Override
    protected DoctorService getService() {
        return this.doctorService;
    }
}
