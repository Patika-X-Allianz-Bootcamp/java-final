package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.ReportEntity;
import com.example.healthtourismapp.database.repositories.ReportRepository;
import com.example.healthtourismapp.database.specification.ReportSpecification;
import com.example.healthtourismapp.mapper.ReportMapper;
import com.example.healthtourismapp.model.ReportDTO;
import com.example.healthtourismapp.model.requestDTO.ReportRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ReportService extends BaseService<
        ReportEntity,
        ReportDTO,
        ReportRequestDTO,
        ReportMapper,
        ReportRepository, ReportSpecification> {

    private final ReportMapper reportMapper;

    private final ReportRepository reportRepository;

    private final ReportSpecification reportSpecification;

    public ReportService(ReportMapper reportMapper, ReportRepository reportRepository, ReportSpecification reportSpecification) {
        this.reportMapper = reportMapper;
        this.reportRepository = reportRepository;
        this.reportSpecification = reportSpecification;
    }

    @Override
    public ReportMapper getMapper() {
        return reportMapper;
    }

    @Override
    public ReportRepository getRepository() {
        return reportRepository;
    }

    @Override
    protected ReportSpecification getSpecification() {
        return reportSpecification;
    }
}
