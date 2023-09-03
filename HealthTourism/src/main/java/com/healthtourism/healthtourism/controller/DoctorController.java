package com.healthtourism.healthtourism.controller;

import com.healthtourism.healthtourism.Specification.DoctorSpecification;
import com.healthtourism.healthtourism.database.entities.DoctorEntity;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.database.repositories.DoctorRepository;
import com.healthtourism.healthtourism.mapper.DoctorMapper;
import com.healthtourism.healthtourism.model.DoctorDTO;
import com.healthtourism.healthtourism.model.PatientDTO;
import com.healthtourism.healthtourism.model.RequestDTO.DoctorRequestDTO;
import com.healthtourism.healthtourism.model.RequestDTO.PatientRequestDTO;
import com.healthtourism.healthtourism.service.DoctorService;
import com.healthtourism.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctor")
public class DoctorController extends BaseController<
        DoctorEntity,
        DoctorDTO,
        DoctorRequestDTO,
        DoctorMapper,
        DoctorRepository,
        DoctorService,
        DoctorSpecification> {
    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    protected DoctorService getService() {
        return doctorService;
    }

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO) {
        String specialization = doctorRequestDTO.getSpecialization();

        if (!doctorService.isValidSpecialization(specialization)) {
            System.out.println("Lütfen geçerli bir uzmanlık alanı seçin.");
            return ResponseEntity.badRequest().body(false);
        }
        boolean isCreated = doctorService.createDoctor(
                doctorRequestDTO.getFirstName(),
                doctorRequestDTO.getLastName(),
                doctorRequestDTO.getSpecialization()
        );

        if (isCreated) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }

}
