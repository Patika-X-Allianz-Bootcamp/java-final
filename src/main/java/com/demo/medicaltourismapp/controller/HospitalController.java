package com.demo.medicaltourismapp.controller;

import com.demo.medicaltourismapp.database.entity.HospitalEntity;
import com.demo.medicaltourismapp.database.repository.HospitalRepository;
import com.demo.medicaltourismapp.mapper.HospitalMapper;
import com.demo.medicaltourismapp.model.HospitalDTO;
import com.demo.medicaltourismapp.model.requestDTO.HospitalRequestDTO;
import com.demo.medicaltourismapp.service.HospitalService;
import com.demo.medicaltourismapp.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController<HospitalEntity, HospitalDTO, HospitalRequestDTO,
        HospitalMapper, HospitalRepository, HospitalService> {

    private final HospitalService hospitalService;

    @Override
    protected HospitalService getService() {
        return hospitalService;
    }
}
