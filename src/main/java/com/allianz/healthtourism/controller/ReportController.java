package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.ReportEntity;
import com.allianz.healthtourism.database.repository.ReportRepository;
import com.allianz.healthtourism.mapper.ReportMapper;
import com.allianz.healthtourism.model.DTO.ReportDTO;
import com.allianz.healthtourism.model.requestDTO.ReportRequestDTO;
import com.allianz.healthtourism.service.ReportService;
import com.allianz.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("report")
public class ReportController extends BaseController<ReportEntity, ReportDTO, ReportRequestDTO,
        ReportMapper, ReportRepository, ReportService> {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }


    @Override
    protected ReportService getService() {
        return reportService;
    }
}
