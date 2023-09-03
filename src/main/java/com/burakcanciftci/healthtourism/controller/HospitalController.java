package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.HospitalEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.HospitalResponseDTO;
import com.burakcanciftci.healthtourism.service.HospitalService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hospital")
@AllArgsConstructor
public class HospitalController extends BaseController<HospitalEntity, HospitalResponseDTO, HospitalRequestDTO> {
    private final HospitalService hospitalService;

    @Override
    protected HospitalService getService() {
        return this.hospitalService;
    }
}
