package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.HealthServiceEntity;
import com.example.healthtourismapp.database.entities.HospitalEntity;
import com.example.healthtourismapp.database.repositories.HospitalRepository;
import com.example.healthtourismapp.database.specification.HospitalSpecification;
import com.example.healthtourismapp.mapper.HospitalMapper;
import com.example.healthtourismapp.model.HospitalDTO;
import com.example.healthtourismapp.model.requestDTO.HospitalRequestDTO;
import com.example.healthtourismapp.service.HospitalService;
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
@RequestMapping("/hospitals")
public class HospitalController extends BaseController<HospitalEntity, HospitalDTO, HospitalRequestDTO,
        HospitalMapper, HospitalRepository, HospitalSpecification, HospitalService> {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @Override
    protected HospitalService getService() {
        return hospitalService;
    }

    @GetMapping("/{hospitalUuid}/healthService/{healthServiceUuid}")
    public ResponseEntity<HealthServiceEntity> getHealthServiceByUuid(@PathVariable UUID hospitalUuid, @PathVariable UUID roomUuid) {
        Optional<HealthServiceEntity> healthServiceOptional = hospitalService.selectHealthService(hospitalUuid, roomUuid);
        if (healthServiceOptional.isPresent()) {
            return new ResponseEntity<>(healthServiceOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
