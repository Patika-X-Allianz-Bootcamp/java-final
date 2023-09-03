package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.Hospital;
import com.allianz.patienttourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.patienttourism.model.responseDTO.HospitalResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController<Hospital, HospitalResponseDTO, HospitalRequestDTO> {
    public HospitalController(BaseService<Hospital, HospitalResponseDTO, HospitalRequestDTO> service) {
        super(service);
    }
}
