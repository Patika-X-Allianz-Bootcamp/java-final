package com.allianz.healthtourism.controller;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.repository.AppointmentRepository;
import com.allianz.healthtourism.mapper.AppointmentMapper;
import com.allianz.healthtourism.model.DTO.AppointmentDTO;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;

import com.allianz.healthtourism.service.AppointmentService;
import com.allianz.healthtourism.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController extends BaseController<AppointmentEntity, AppointmentDTO,
        AppointmentRequestDTO,AppointmentMapper,  AppointmentRepository, AppointmentService> {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }
}
