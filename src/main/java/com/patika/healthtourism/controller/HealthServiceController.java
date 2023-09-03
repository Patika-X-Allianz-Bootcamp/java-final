package com.patika.healthtourism.controller;

import com.patika.healthtourism.database.entity.HealthServiceEntity;
import com.patika.healthtourism.database.repository.HealthServiceEntityRepository;
import com.patika.healthtourism.mapper.HealthServiceMapper;
import com.patika.healthtourism.model.HealthServiceDTO;
import com.patika.healthtourism.model.requestDTO.DoctorCreateRequestDTO;
import com.patika.healthtourism.model.requestDTO.HealthServiceRequestDTO;
import com.patika.healthtourism.service.HealthServiceService;
import com.patika.healthtourism.util.BaseController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/healthservice")
public class HealthServiceController extends BaseController<HealthServiceEntity, HealthServiceDTO, HealthServiceRequestDTO,
        HealthServiceMapper, HealthServiceEntityRepository, HealthServiceService> {
    private final HealthServiceService healthServiceService;
    public HealthServiceController(HealthServiceService healthServiceService) {
        this.healthServiceService = healthServiceService;
    }
    @Override
    protected HealthServiceService getService() {
        return healthServiceService;
    }

    @PostMapping("/{healthServiceUuid}/add-doctor")
    public ResponseEntity<String> addDoctorToHealthService(
            @PathVariable UUID healthServiceUuid,
            @RequestBody DoctorCreateRequestDTO doctorRequestDTO) {
        boolean result = healthServiceService.addDoctorToHealthService(healthServiceUuid, doctorRequestDTO);

        if (result) {
            return ResponseEntity.ok("Doctor added to health service successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add doctor to health service");
        }
    }


}
