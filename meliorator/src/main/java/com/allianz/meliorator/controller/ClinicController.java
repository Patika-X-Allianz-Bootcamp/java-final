package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Clinic;
import com.allianz.meliorator.database.repository.ClinicRepository;
import com.allianz.meliorator.mapper.ClinicMapper;
import com.allianz.meliorator.model.dto.ClinicDTO;
import com.allianz.meliorator.model.requestDTO.ClinicRequestDTO;
import com.allianz.meliorator.service.ClinicService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinic")
public class ClinicController extends BaseController<Clinic, ClinicDTO, ClinicRequestDTO,
        ClinicMapper, ClinicRepository, ClinicService> {
    @Autowired
    ClinicService clinicService;
    @Override
    protected ClinicService getService() {
        return this.clinicService;
    }
}
