package Tourism.service;

import Tourism.database.entity.PatientEntity;
import Tourism.database.repository.PatientRepository;
import Tourism.database.specification.PatientSpecification;
import Tourism.mapper.PatientMapper;
import Tourism.model.PatientDTO;
import Tourism.model.requestDTO.RequestPatientDTO;
import Tourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<PatientEntity, PatientDTO, RequestPatientDTO,
        PatientMapper, PatientRepository, PatientSpecification> {

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientSpecification patientSpecification;

    @Override
    protected PatientMapper getMapper() {
        return patientMapper;
    }

    @Override
    protected PatientRepository getRepository() {
        return patientRepository;
    }

    @Override
    protected PatientSpecification getSpecification() {
        return patientSpecification;
    }
}
