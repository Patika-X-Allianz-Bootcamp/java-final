package allianz.healthtourism.controller;

import allianz.healthtourism.base.BaseController;
import allianz.healthtourism.dto.Request.DoctorRequest;
import allianz.healthtourism.dto.Request.HealthServiceRequest;
import allianz.healthtourism.dto.Response.DoctorDTO;
import allianz.healthtourism.dto.Response.HealthServiceDTO;
import allianz.healthtourism.entity.Doctor;
import allianz.healthtourism.entity.HealthService;
import allianz.healthtourism.repository.DoctorRepository;
import allianz.healthtourism.repository.HealthServiceRepository;
import allianz.healthtourism.service.DoctorService;
import allianz.healthtourism.service.HealthServiceService;
import allianz.healthtourism.specification.DoctorSpecification;
import allianz.healthtourism.specification.HealthServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("healthService")
public class HealthServiceController extends BaseController<
        HealthService,
        HealthServiceDTO,
        HealthServiceRequest,
        HealthServiceRepository,
        HealthServiceSpecification,
        HealthServiceService> {


    @Autowired
    HealthServiceService healthServiceService;


    @Override
    protected HealthServiceService getService() {
        return healthServiceService;
    }
}
