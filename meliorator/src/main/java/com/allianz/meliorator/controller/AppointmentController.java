package com.allianz.meliorator.controller;

import com.allianz.meliorator.database.entity.Appointment;
import com.allianz.meliorator.database.repository.AppointmentRepository;
import com.allianz.meliorator.mapper.AppointmentMapper;
import com.allianz.meliorator.model.dto.AppointmentDTO;
import com.allianz.meliorator.model.requestDTO.AppointmentRequestDTO;
import com.allianz.meliorator.service.AppointmentService;
import com.allianz.meliorator.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController extends BaseController
        <Appointment, AppointmentDTO, AppointmentRequestDTO,
        AppointmentMapper, AppointmentRepository, AppointmentService> {
    @Autowired
    AppointmentService appointmentService;
    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }
}
