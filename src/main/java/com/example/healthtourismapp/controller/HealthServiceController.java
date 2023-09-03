package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.DoctorEntity;
import com.example.healthtourismapp.database.entities.HealthServiceEntity;
import com.example.healthtourismapp.database.repositories.HealthServiceRepository;
import com.example.healthtourismapp.database.specification.HealthServiceSpecification;
import com.example.healthtourismapp.mapper.HealthServiceMapper;
import com.example.healthtourismapp.model.HealthServiceDTO;
import com.example.healthtourismapp.model.requestDTO.HealthServiceRequestDTO;
import com.example.healthtourismapp.service.HealthServiceService;
import com.example.healthtourismapp.util.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/health-services")
public class HealthServiceController extends BaseController<HealthServiceEntity, HealthServiceDTO,
        HealthServiceRequestDTO, HealthServiceMapper, HealthServiceRepository, HealthServiceSpecification, HealthServiceService> {

    private final HealthServiceService healthServiceService;

    public HealthServiceController(HealthServiceService healthServiceService) {
        this.healthServiceService = healthServiceService;
    }

    @Override
    protected HealthServiceService getService() {
        return healthServiceService;
    }

    @GetMapping("/{healthServiceUuid}/doctor/{doctorUuid}")
    public ResponseEntity<DoctorEntity> getDoctorByUuid(@PathVariable UUID healthServiceUuid, @PathVariable UUID doctorUuid) {
        Optional<DoctorEntity> doctorOptional = healthServiceService.selectDoctor(healthServiceUuid, doctorUuid);
        if (doctorOptional.isPresent()) {
            return new ResponseEntity<>(doctorOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
