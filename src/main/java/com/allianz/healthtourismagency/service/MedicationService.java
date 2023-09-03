package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.MedicationEntity;
import com.allianz.healthtourismagency.database.repository.MedicationRepository;
import com.allianz.healthtourismagency.database.specification.MedicationSpecification;
import com.allianz.healthtourismagency.mapper.MedicationMapper;
import com.allianz.healthtourismagency.model.MedicationDTO;
import com.allianz.healthtourismagency.model.requestDTO.MedicationRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class MedicationService extends BaseService<MedicationEntity, MedicationDTO, MedicationRequestDTO,
        MedicationMapper, MedicationRepository, MedicationSpecification> {

    private final MedicationMapper medicationMapper;
    private final MedicationRepository medicationRepository;
    private final MedicationSpecification medicationSpecification;

    public MedicationService(MedicationMapper medicationMapper, MedicationRepository medicationRepository,
                             MedicationSpecification medicationSpecification) {
        this.medicationMapper = medicationMapper;
        this.medicationRepository = medicationRepository;
        this.medicationSpecification = medicationSpecification;
    }


    @Override
    protected MedicationMapper getMapper() {
        return medicationMapper;
    }

    @Override
    protected MedicationRepository getRepository() {
        return medicationRepository;
    }

    @Override
    protected MedicationSpecification getSpecification() {
        return medicationSpecification;
    }
}
