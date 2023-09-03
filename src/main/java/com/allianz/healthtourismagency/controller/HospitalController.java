package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.HospitalEntity;
import com.allianz.healthtourismagency.database.repository.HospitalRepository;
import com.allianz.healthtourismagency.database.specification.HospitalSpecification;
import com.allianz.healthtourismagency.mapper.HospitalMapper;
import com.allianz.healthtourismagency.model.HospitalDTO;
import com.allianz.healthtourismagency.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourismagency.service.HospitalService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController<
        HospitalEntity,
        HospitalDTO,
        HospitalRequestDTO,
        HospitalMapper,
        HospitalRepository,
        HospitalSpecification,
        HospitalService> {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @Override
    protected HospitalService getService() {
        return hospitalService;
    }
}
