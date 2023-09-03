package allianz.healthtourism.controller;

import allianz.healthtourism.base.BaseController;
import allianz.healthtourism.dto.Request.DoctorRequest;
import allianz.healthtourism.dto.Response.DoctorDTO;
import allianz.healthtourism.entity.Doctor;
import allianz.healthtourism.repository.DoctorRepository;
import allianz.healthtourism.service.DoctorService;
import allianz.healthtourism.specification.DoctorSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<
        Doctor,
        DoctorDTO,
        DoctorRequest,
        DoctorRepository,
        DoctorSpecification,
        DoctorService> {


    @Autowired
    DoctorService doctorService;


    @Override
    protected DoctorService getService() {
        return doctorService;
    }
}
