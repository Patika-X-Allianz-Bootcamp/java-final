package allianz.healthtourism.controller;

import allianz.healthtourism.base.BaseController;
import allianz.healthtourism.dto.Request.AppointmentRequest;
import allianz.healthtourism.dto.Response.AppointmentDTO;
import allianz.healthtourism.entity.Appointment;
import allianz.healthtourism.repository.AppointmentRepository;
import allianz.healthtourism.service.AppointmentService;
import allianz.healthtourism.specification.AppointmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController extends BaseController<
        Appointment,
        AppointmentDTO,
        AppointmentRequest,
        AppointmentRepository,
        AppointmentSpecification,
        AppointmentService> {




    @Autowired
    AppointmentService appointmentService;


    @Override
    protected AppointmentService getService() {
        return appointmentService;



    }


}
