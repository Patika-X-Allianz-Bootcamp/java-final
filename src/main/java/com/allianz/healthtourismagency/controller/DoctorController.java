package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.DoctorEntity;
import com.allianz.healthtourismagency.database.repository.DoctorRepository;
import com.allianz.healthtourismagency.database.specification.DoctorSpecification;
import com.allianz.healthtourismagency.mapper.DoctorMapper;
import com.allianz.healthtourismagency.model.AppointmentDTO;
import com.allianz.healthtourismagency.model.DoctorDTO;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentStatusRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourismagency.service.DoctorService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorSpecification,
        DoctorService> {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    protected DoctorService getService() {
        return doctorService;
    }

    @PutMapping("add-appointment-to-doctor/{uuid}")
    public ResponseEntity<DoctorDTO> addAppointmentToDoctor(@PathVariable UUID uuid, @RequestBody AppointmentRequestDTO requestDTO) {
        if (getService().addAppointmentToDoctor(uuid, requestDTO) != null) {
            return new ResponseEntity<>(getService().addAppointmentToDoctor(uuid, requestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
