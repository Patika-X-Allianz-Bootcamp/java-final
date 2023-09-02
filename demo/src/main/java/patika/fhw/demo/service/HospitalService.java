package patika.fhw.demo.service;

import org.springframework.stereotype.Service;

import patika.fhw.demo.database.entity.Hospital;
import patika.fhw.demo.database.repository.HospitalRepository;
import patika.fhw.demo.database.specification.HospitalSpecification;
import patika.fhw.demo.mapper.HospitalMapper;
import patika.fhw.demo.model.dto.HospitalDTO;
import patika.fhw.demo.model.requestDTO.HospitalRequestDTO;
import patika.fhw.demo.util.BaseService;

@Service
public class HospitalService extends BaseService<Hospital, HospitalDTO, HospitalRequestDTO, HospitalMapper, HospitalRepository, HospitalSpecification> {

    private final HospitalMapper mapper;
    private final HospitalRepository repository;
    private final HospitalSpecification specification;

    public HospitalService(HospitalMapper mapper, HospitalRepository repository, HospitalSpecification specification) {
        this.mapper = mapper;
        this.repository = repository;
        this.specification = specification;
    }

    @Override
    protected HospitalMapper getMapper() {
        return mapper;
    }

    @Override
    protected HospitalRepository getRepository() {
        return repository;
    }

    @Override
    protected HospitalSpecification getSpecification() {
        return specification;
    }
}
