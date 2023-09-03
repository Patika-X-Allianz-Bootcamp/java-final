package com.patika.healthtourism.controller;

import com.patika.healthtourism.database.entity.AppointmentEntity;
import com.patika.healthtourism.database.repository.AppointmentEntityRepository;
import com.patika.healthtourism.mapper.AppointmentMapper;
import com.patika.healthtourism.model.AppointmentDTO;
import com.patika.healthtourism.model.requestDTO.*;
import com.patika.healthtourism.service.AppointmentService;
import com.patika.healthtourism.util.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.UUID;

@RestController
@RequestMapping("/appointment")
public class AppointmentController extends BaseController<AppointmentEntity, AppointmentDTO, AppointmentCreateRequestDTO,
        AppointmentMapper, AppointmentEntityRepository, AppointmentService>{

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }
    @PostMapping("/{appointmentUuid}/select-patient")
    public ResponseEntity<String> selectPatient(@PathVariable UUID appointmentUuid,
                                                @RequestBody PatientRequestDTO patient){
        boolean result = appointmentService.selectPatient(appointmentUuid, patient);

        if (result) {
            return ResponseEntity.ok("Patient selected successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to select patient");
        }

    }
    @PostMapping("/{appointmentUuid}/select-hospital")
    public ResponseEntity<String> selectHospital(@PathVariable UUID appointmentUuid,
                                                 @RequestBody HospitalRequestDTO selectedHospital) {
        boolean result = appointmentService.selectHospital(appointmentUuid, selectedHospital);

        if (result) {
            return ResponseEntity.ok("Hospital selected successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to select hospital");
        }
    }


    @PostMapping("/{appointmentUuid}/select-healthService")
    public ResponseEntity<String> selectHealthService(@PathVariable UUID appointmentUuid,
                                                 @RequestBody HealthServiceRequestDTO selectedHealthService) {
        boolean result = appointmentService.selectHealthService(appointmentUuid, selectedHealthService);

        if (result) {
            return ResponseEntity.ok("Health Service selected successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to select Health service");
        }
    }
    @PostMapping("/{appointmentUuid}/select-doctor")
    public ResponseEntity<String> selectDoctor(@PathVariable UUID appointmentUuid,
                                                 @RequestBody DoctorCreateRequestDTO selectedDoctor) {
        boolean result = appointmentService.selectDoctor(appointmentUuid, selectedDoctor);

        if (result) {
            return ResponseEntity.ok("Doctor selected successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to select Health service");
        }
    }
    @PostMapping("/{appointmentUuid}/approve")
    public ResponseEntity<Boolean> approveAppointment(@PathVariable UUID appointmentUuid,
                                                      @RequestBody boolean approve){
        return new ResponseEntity<>(appointmentService.approve(appointmentUuid,approve), HttpStatus.OK);
    }
}