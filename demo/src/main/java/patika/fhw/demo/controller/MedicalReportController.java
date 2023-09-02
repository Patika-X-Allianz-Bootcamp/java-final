package patika.fhw.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import patika.fhw.demo.database.entity.MedicalReport;
import patika.fhw.demo.database.repository.MedicalReportRepository;
import patika.fhw.demo.database.specification.MedicalReportSpecification;
import patika.fhw.demo.mapper.MedicalReportMapper;
import patika.fhw.demo.model.dto.MedicalReportDTO;
import patika.fhw.demo.model.requestDTO.MedicalReportRequestDTO;
import patika.fhw.demo.service.MedicalReportService;
import patika.fhw.demo.util.BaseController;

@RestController
@RequestMapping("medical-report")
public class MedicalReportController extends BaseController<
        MedicalReport,
        MedicalReportDTO,
        MedicalReportRequestDTO,
        MedicalReportMapper,
        MedicalReportRepository,
        MedicalReportSpecification,
        MedicalReportService> {

    @Autowired
    private MedicalReportService medicalReportService;

    @Override
    protected MedicalReportService getService() {
        return medicalReportService;
    }
}
