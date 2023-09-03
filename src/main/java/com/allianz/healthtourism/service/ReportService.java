package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.ReportEntity;
import com.allianz.healthtourism.database.repository.ReportRepository;
import com.allianz.healthtourism.mapper.ReportMapper;
import com.allianz.healthtourism.model.DTO.ReportDTO;
import com.allianz.healthtourism.model.requestDTO.ReportRequestDTO;
import com.allianz.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ReportService extends BaseService<ReportEntity, ReportDTO, ReportRequestDTO,
        ReportMapper, ReportRepository> {
    private final ReportMapper reportMapper;
    private final ReportRepository reportRepository;

    public ReportService(ReportMapper reportMapper, ReportRepository reportRepository) {
        this.reportMapper = reportMapper;
        this.reportRepository = reportRepository;
    }

    @Override
    protected ReportMapper getMapper() {
        return reportMapper;
    }

    @Override
    protected ReportRepository getRepository() {
        return reportRepository;
    }
}
