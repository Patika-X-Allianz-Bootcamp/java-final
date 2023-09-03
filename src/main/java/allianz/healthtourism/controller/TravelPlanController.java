package allianz.healthtourism.controller;

import allianz.healthtourism.base.BaseController;
import allianz.healthtourism.dto.Request.DoctorRequest;
import allianz.healthtourism.dto.Request.TravelPlanRequest;
import allianz.healthtourism.dto.Response.DoctorDTO;
import allianz.healthtourism.dto.Response.TravelPlanDTO;
import allianz.healthtourism.entity.Doctor;
import allianz.healthtourism.entity.TravelPlan;
import allianz.healthtourism.repository.DoctorRepository;
import allianz.healthtourism.repository.TravelPlanRepository;
import allianz.healthtourism.service.DoctorService;
import allianz.healthtourism.service.TravelPlanService;
import allianz.healthtourism.specification.DoctorSpecification;
import allianz.healthtourism.specification.TravelPlanSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("travelPlan")
public class TravelPlanController extends BaseController<
        TravelPlan,
        TravelPlanDTO,
        TravelPlanRequest,
        TravelPlanRepository,
        TravelPlanSpecification,
        TravelPlanService> {


    @Autowired
    TravelPlanService travelPlanService;


    @Override
    protected TravelPlanService getService() {
        return travelPlanService;
    }
}
