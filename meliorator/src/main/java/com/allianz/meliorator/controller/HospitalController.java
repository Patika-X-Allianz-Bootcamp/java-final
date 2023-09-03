package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Hospital;
import com.allianz.meliorator.database.repository.HospitalRepository;
import com.allianz.meliorator.mapper.HospitalMapper;
import com.allianz.meliorator.model.dto.HospitalDTO;
import com.allianz.meliorator.model.requestDTO.HospitalRequestDTO;
import com.allianz.meliorator.service.HospitalService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/hospital")
public class HospitalController extends BaseController<Hospital, HospitalDTO, HospitalRequestDTO,
        HospitalMapper, HospitalRepository, HospitalService> {
    @Autowired
    HospitalService hospitalService;
    @Override
    protected HospitalService getService() {
        return this.hospitalService;
    }
}
