package Tourism.controller;

import Tourism.database.entity.PatientEntity;
import Tourism.database.repository.PatientRepository;
import Tourism.database.specification.PatientSpecification;
import Tourism.mapper.PatientMapper;
import Tourism.model.PatientDTO;
import Tourism.model.requestDTO.RequestPatientDTO;
import Tourism.service.PatientService;
import Tourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<
        PatientEntity,
        PatientDTO,
        RequestPatientDTO,
        PatientMapper,
        PatientRepository,
        PatientSpecification,
        PatientService> {

    @Autowired
    PatientService patientService;

    @Override
    protected PatientService getService() {
        return this.patientService;
    }
}