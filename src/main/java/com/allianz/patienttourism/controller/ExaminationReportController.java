package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.ExaminationReport;
import com.allianz.patienttourism.model.requestDTO.ExaminationReportRequestDTO;
import com.allianz.patienttourism.model.responseDTO.ExaminationReportResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("examination-report")
public class ExaminationReportController extends BaseController<ExaminationReport, ExaminationReportResponseDTO,
        ExaminationReportRequestDTO> {
    public ExaminationReportController(BaseService<ExaminationReport,
            ExaminationReportResponseDTO, ExaminationReportRequestDTO> service) {
        super(service);
    }
}
