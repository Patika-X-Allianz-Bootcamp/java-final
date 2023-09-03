package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.repository.HospitalRepository;
import com.allianz.healthtourism.mapper.HospitalMapper;
import com.allianz.healthtourism.model.DTO.HospitalDTO;
import com.allianz.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourism.service.HospitalService;
import com.allianz.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController<HospitalEntity, HospitalDTO, HospitalRequestDTO,
        HospitalMapper, HospitalRepository, HospitalService> {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }


    @Override
    protected HospitalService getService() {
        return hospitalService;
    }
}
