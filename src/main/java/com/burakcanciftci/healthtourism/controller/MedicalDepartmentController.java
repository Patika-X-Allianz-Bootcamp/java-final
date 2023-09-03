package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.MedicalDepartmentEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.MedicalDepartmentRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.MedicalDepartmentResponseDTO;
import com.burakcanciftci.healthtourism.service.MedicalDepartmentService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medical-department")
@AllArgsConstructor
public class MedicalDepartmentController extends BaseController<MedicalDepartmentEntity, MedicalDepartmentResponseDTO, MedicalDepartmentRequestDTO> {
    private final MedicalDepartmentService medicalDepartmentService;

    @Override
    protected MedicalDepartmentService getService() {
        return this.medicalDepartmentService;
    }
}
