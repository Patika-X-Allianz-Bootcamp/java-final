package com.patika.healthtourism.controller;

import com.patika.healthtourism.database.entity.HospitalEntity;
import com.patika.healthtourism.database.repository.HospitalEntityRepository;
import com.patika.healthtourism.mapper.HospitalMapper;
import com.patika.healthtourism.model.HospitalDTO;
import com.patika.healthtourism.model.requestDTO.HealthServiceRequestDTO;
import com.patika.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.patika.healthtourism.service.HospitalService;
import com.patika.healthtourism.util.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/hospital")
public class HospitalController extends BaseController<HospitalEntity, HospitalDTO,
        HospitalRequestDTO, HospitalMapper, HospitalEntityRepository, HospitalService> {
    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @Override
    protected HospitalService getService() {
        return hospitalService;
    }
    @PostMapping("/{hospitalUuid}/add-health-service")
    public ResponseEntity<String> addHealthServiceToHospital(
            @PathVariable UUID hospitalUuid,
            @RequestBody HealthServiceRequestDTO healthServiceRequestDTO) {
        boolean result = hospitalService.addHealthServiceToHospital(hospitalUuid, healthServiceRequestDTO);

        if (result) {
            return ResponseEntity.ok("Health service added to hospital successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add health service to hospital");
        }
    }

}
