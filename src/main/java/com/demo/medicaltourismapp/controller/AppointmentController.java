package com.demo.medicaltourismapp.controller;

import com.demo.medicaltourismapp.database.entity.AppointmentEntity;
import com.demo.medicaltourismapp.database.repository.AppointmentRepository;
import com.demo.medicaltourismapp.mapper.AppointmentMapper;
import com.demo.medicaltourismapp.model.AppointmentDTO;
import com.demo.medicaltourismapp.model.requestDTO.AppointmentRequestDTO;
import com.demo.medicaltourismapp.service.AppointmentService;
import com.demo.medicaltourismapp.service.PatientService;
import com.demo.medicaltourismapp.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
@AllArgsConstructor
public class AppointmentController extends BaseController<AppointmentEntity, AppointmentDTO, AppointmentRequestDTO,
        AppointmentMapper, AppointmentRepository, AppointmentService> {

    private final AppointmentService appointmentService;

    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }

    @PutMapping("confirm-appointment")
    public void confirmAppointment(AppointmentRequestDTO appointmentRequestDTO){
        appointmentService.save(appointmentRequestDTO);
    }


}
