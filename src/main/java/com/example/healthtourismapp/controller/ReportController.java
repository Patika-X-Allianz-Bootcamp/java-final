package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.ReportEntity;
import com.example.healthtourismapp.database.repositories.ReportRepository;
import com.example.healthtourismapp.database.specification.ReportSpecification;
import com.example.healthtourismapp.mapper.ReportMapper;
import com.example.healthtourismapp.model.ReportDTO;
import com.example.healthtourismapp.model.requestDTO.ReportRequestDTO;
import com.example.healthtourismapp.service.ReportService;
import com.example.healthtourismapp.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController extends BaseController<ReportEntity, ReportDTO, ReportRequestDTO,
        ReportMapper, ReportRepository, ReportSpecification, ReportService> {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    protected ReportService getService() {
        return reportService;
    }
}
