package com.allianz.healthtourismagency.controller;

import com.allianz.healthtourismagency.database.entity.MedicationEntity;
import com.allianz.healthtourismagency.database.repository.MedicationRepository;
import com.allianz.healthtourismagency.database.specification.MedicationSpecification;
import com.allianz.healthtourismagency.mapper.MedicationMapper;
import com.allianz.healthtourismagency.model.MedicationDTO;
import com.allianz.healthtourismagency.model.requestDTO.MedicationRequestDTO;
import com.allianz.healthtourismagency.service.MedicationService;
import com.allianz.healthtourismagency.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medication")
public class MedicationController extends BaseController<
        MedicationEntity,
        MedicationDTO,
        MedicationRequestDTO,
        MedicationMapper,
        MedicationRepository,
        MedicationSpecification,
        MedicationService> {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @Override
    protected MedicationService getService() {
        return medicationService;
    }
}
