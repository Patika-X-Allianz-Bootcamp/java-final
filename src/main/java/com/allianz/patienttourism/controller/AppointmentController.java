package com.allianz.patienttourism.controller;

import com.allianz.patienttourism.database.entity.Appointment;
import com.allianz.patienttourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.patienttourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.patienttourism.util.BaseController;
import com.allianz.patienttourism.util.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController extends BaseController<Appointment, AppointmentResponseDTO, AppointmentRequestDTO> {
    public AppointmentController(BaseService<Appointment, AppointmentResponseDTO, AppointmentRequestDTO> service) {
        super(service);
    }
}
