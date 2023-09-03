package com.healthtourism.healthtourism.controller;

import com.healthtourism.healthtourism.Specification.AppointmentSpecification;
import com.healthtourism.healthtourism.database.entities.AppointmentEntity;
import com.healthtourism.healthtourism.database.entities.DoctorEntity;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.database.repositories.AppointmentRepository;
import com.healthtourism.healthtourism.database.repositories.PatientRepository;
import com.healthtourism.healthtourism.mapper.AppointmentMapper;
import com.healthtourism.healthtourism.mapper.DoctorMapper;
import com.healthtourism.healthtourism.mapper.PatientMapper;
import com.healthtourism.healthtourism.model.AppointmentDTO;
import com.healthtourism.healthtourism.model.RequestDTO.AppointmentRequestDTO;
import com.healthtourism.healthtourism.service.AppointmentService;
import com.healthtourism.healthtourism.service.DoctorService;
import com.healthtourism.healthtourism.service.PatientService;
import com.healthtourism.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/appointment")
public class AppointmentController extends BaseController<
        AppointmentEntity,
        AppointmentDTO,
        AppointmentRequestDTO,
        AppointmentMapper,
        AppointmentRepository,
        AppointmentService,
        AppointmentSpecification> {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    AppointmentMapper appointmentMapper;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    DoctorMapper doctorMapper;

    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        try {
            boolean isCreated = appointmentService.createAppointment(
                    appointmentRequestDTO.getAppointmentDate(),
                    appointmentRequestDTO.getAppointmentTime(),
                    appointmentRequestDTO.getPatientUuid(),
                    appointmentRequestDTO.getDoctorUuid()
            );

            if (isCreated) {
                return ResponseEntity.ok("Appointment created successfully.");
            } else {
                return ResponseEntity.badRequest().body("Failed to create appointment.or appointment time is already taken.\"");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid input.");
        }
    }
    @PostMapping("/approve/{appointmentUuid}")
    public ResponseEntity<String> approveAppointment(@PathVariable UUID appointmentUuid) {
        boolean isApproved = appointmentService.approveAppointment(appointmentUuid);

        if (isApproved) {
            return ResponseEntity.ok("Appointment approved successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to approve appointment.");
        }
    }

    @PostMapping("/cancel/{appointmentUuid}")
    public ResponseEntity<String> cancelAppointment(@PathVariable UUID appointmentUuid) {
        boolean isCancelled = appointmentService.cancelAppointment(appointmentUuid);

        if (isCancelled) {
            return ResponseEntity.ok("Appointment cancelled successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to cancel appointment.");
        }
    }


    @GetMapping("/check-overtime")
    public ResponseEntity<String> checkOvertimeAppointments() {
        appointmentService.checkPendingAppointments();
        return ResponseEntity.ok("Overtime appointments checked and marked.");
    }

}
