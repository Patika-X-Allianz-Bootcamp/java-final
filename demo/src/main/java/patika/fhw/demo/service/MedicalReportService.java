package patika.fhw.demo.service;

import org.springframework.stereotype.Service;

import patika.fhw.demo.database.entity.MedicalReport;
import patika.fhw.demo.database.repository.MedicalReportRepository;
import patika.fhw.demo.database.specification.MedicalReportSpecification;
import patika.fhw.demo.mapper.MedicalReportMapper;
import patika.fhw.demo.model.dto.MedicalReportDTO;
import patika.fhw.demo.model.requestDTO.MedicalReportRequestDTO;
import patika.fhw.demo.util.BaseService;

@Service
public class MedicalReportService extends BaseService<MedicalReport, MedicalReportDTO, MedicalReportRequestDTO, MedicalReportMapper, MedicalReportRepository, MedicalReportSpecification> {

    private final MedicalReportMapper mapper;
    private final MedicalReportRepository repository;
    private final MedicalReportSpecification specification;

    public MedicalReportService(MedicalReportMapper mapper, MedicalReportRepository repository, MedicalReportSpecification specification) {
        this.mapper = mapper;
        this.repository = repository;
        this.specification = specification;
    }

    @Override
    protected MedicalReportMapper getMapper() {
        return mapper;
    }

    @Override
    protected MedicalReportRepository getRepository() {
        return repository;
    }

    @Override
    protected MedicalReportSpecification getSpecification() {
        return specification;
    }
}
