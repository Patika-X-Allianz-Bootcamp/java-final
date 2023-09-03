package com.allianz.patienttourism.service;

import com.allianz.patienttourism.database.entity.ExaminationReport;
import com.allianz.patienttourism.model.requestDTO.ExaminationReportRequestDTO;
import com.allianz.patienttourism.model.responseDTO.ExaminationReportResponseDTO;
import com.allianz.patienttourism.util.BaseService;
import com.allianz.patienttourism.util.BaseSpecification;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import com.allianz.patienttourism.util.mapper.MapperService;
import org.springframework.stereotype.Service;

@Service
public class ExaminationReportService extends BaseService<ExaminationReport,
        ExaminationReportResponseDTO, ExaminationReportRequestDTO> {
    public ExaminationReportService(IBaseRepository<ExaminationReport> repository,
                                    MapperService mapperService, BaseSpecification<ExaminationReport> specification) {
        super(repository, mapperService, specification);
    }

    @Override
    protected Class<ExaminationReport> getEntityClass() {
        return ExaminationReport.class;
    }

    @Override
    protected Class<ExaminationReportResponseDTO> getResponseDTOClass() {
        return ExaminationReportResponseDTO.class;
    }
}
