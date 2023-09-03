package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.AppointmentEntity;
import com.example.healthtourismapp.database.repositories.AppointmentRepository;
import com.example.healthtourismapp.database.specification.AppointmentSpecification;
import com.example.healthtourismapp.mapper.AppointmentMapper;
import com.example.healthtourismapp.model.AppointmentDTO;
import com.example.healthtourismapp.model.requestDTO.AppointmentRequestDTO;
import com.example.healthtourismapp.service.AppointmentService;
import com.example.healthtourismapp.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/appointments")
public class AppointmentController extends BaseController<AppointmentEntity, AppointmentDTO, AppointmentRequestDTO,
        AppointmentMapper, AppointmentRepository, AppointmentSpecification, AppointmentService> {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }


}
