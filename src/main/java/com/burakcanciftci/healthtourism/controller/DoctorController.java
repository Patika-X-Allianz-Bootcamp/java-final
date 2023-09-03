package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.DoctorEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.DoctorResponseDTO;
import com.burakcanciftci.healthtourism.service.DoctorService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
@AllArgsConstructor
public class DoctorController extends BaseController<DoctorEntity, DoctorResponseDTO, DoctorRequestDTO> {
    private final DoctorService doctorService;

    @Override
    protected DoctorService getService() {
        return this.doctorService;
    }
}
