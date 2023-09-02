package patika.fhw.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import patika.fhw.demo.database.entity.Patient;
import patika.fhw.demo.database.repository.PatientRepository;
import patika.fhw.demo.database.specification.PatientSpecification;
import patika.fhw.demo.mapper.PatientMapper;
import patika.fhw.demo.model.dto.PatientDTO;
import patika.fhw.demo.model.requestDTO.PatientRequestDTO;
import patika.fhw.demo.service.PatientService;
import patika.fhw.demo.util.BaseController;

@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<
        Patient,
        PatientDTO,
        PatientRequestDTO,
        PatientMapper,
        PatientRepository,
        PatientSpecification,
        PatientService> {

    @Autowired
    private PatientService patientService;

    @Override
    protected PatientService getService() {
        return patientService;
    }
}
