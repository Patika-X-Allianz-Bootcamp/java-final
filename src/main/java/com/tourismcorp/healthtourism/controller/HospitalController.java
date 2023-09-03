package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.HospitalEntity;
import com.tourismcorp.healthtourism.database.repositories.HospitalRepository;
import com.tourismcorp.healthtourism.database.specification.HospitalSpecification;
import com.tourismcorp.healthtourism.mapper.HospitalMapper;
import com.tourismcorp.healthtourism.model.HospitalDTO;
import com.tourismcorp.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.tourismcorp.healthtourism.service.HospitalService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    HospitalService hospitalService;

    @Override
    protected HospitalService getService() {
        return this.hospitalService;
    }
}
