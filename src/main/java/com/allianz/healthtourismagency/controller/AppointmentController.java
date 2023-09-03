package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.AppointmentEntity;
import com.allianz.healthtourismagency.database.repository.AppointmentRepository;
import com.allianz.healthtourismagency.database.specification.AppointmentSpecification;
import com.allianz.healthtourismagency.mapper.AppointmentMapper;
import com.allianz.healthtourismagency.model.AppointmentDTO;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentStatusRequestDTO;
import com.allianz.healthtourismagency.service.AppointmentService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("appointment")
public class AppointmentController extends BaseController<
        AppointmentEntity,
        AppointmentDTO,
        AppointmentRequestDTO,
        AppointmentMapper,
        AppointmentRepository,
        AppointmentSpecification,
        AppointmentService> {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }

    @PutMapping("update-appointment-status/{uuid}")
    public ResponseEntity<AppointmentDTO> updateAppointmentStatus(@PathVariable UUID uuid, @RequestBody AppointmentStatusRequestDTO requestDTO) {
        if (getService().updateAppointmentStatus(uuid, requestDTO) != null) {
            return new ResponseEntity<>(getService().updateAppointmentStatus(uuid, requestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
