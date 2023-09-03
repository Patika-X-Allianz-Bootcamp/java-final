package allianz.healthtourism.controller;

import allianz.healthtourism.base.BaseController;
import allianz.healthtourism.dto.Request.DoctorRequest;
import allianz.healthtourism.dto.Request.PatientRequest;
import allianz.healthtourism.dto.Response.DoctorDTO;
import allianz.healthtourism.dto.Response.PatientDTO;
import allianz.healthtourism.entity.Doctor;
import allianz.healthtourism.entity.Patient;
import allianz.healthtourism.repository.DoctorRepository;
import allianz.healthtourism.repository.PatientRepository;
import allianz.healthtourism.service.DoctorService;
import allianz.healthtourism.service.PatientService;
import allianz.healthtourism.specification.DoctorSpecification;
import allianz.healthtourism.specification.PatientSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<
        Patient,
        PatientDTO,
        PatientRequest,
        PatientRepository,
        PatientSpecification,
        PatientService> {


    @Autowired
    PatientService patientService;


    @Override
    protected PatientService getService() {
        return patientService;
    }
}
