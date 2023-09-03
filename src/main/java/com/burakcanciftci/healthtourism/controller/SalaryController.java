package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.SalaryEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.SalaryRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.SalaryResponseDTO;
import com.burakcanciftci.healthtourism.service.SalaryService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("salary")
@AllArgsConstructor
public class SalaryController extends BaseController<SalaryEntity, SalaryResponseDTO, SalaryRequestDTO> {
    private final SalaryService salaryService;

    @Override
    protected SalaryService getService() {
        return this.salaryService;
    }
}
