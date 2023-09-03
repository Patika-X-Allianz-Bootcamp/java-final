package com.tourismcorp.healthtourism.service;

import com.tourismcorp.healthtourism.database.entities.PrescriptionEntity;
import com.tourismcorp.healthtourism.database.repositories.PrescriptionRepository;
import com.tourismcorp.healthtourism.database.specification.PrescriptionSpecification;
import com.tourismcorp.healthtourism.mapper.PrescriptionMapper;
import com.tourismcorp.healthtourism.model.PrescriptionDTO;
import com.tourismcorp.healthtourism.model.requestDTO.PrescriptionRequestDTO;
import com.tourismcorp.healthtourism.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService extends BaseService<
        PrescriptionEntity,
        PrescriptionDTO,
        PrescriptionRequestDTO,
        PrescriptionMapper,
        PrescriptionRepository,
        PrescriptionSpecification> {


    private final PrescriptionRepository prescriptionRepository;

    private final PrescriptionMapper prescriptionMapper;

    private final PrescriptionSpecification prescriptionSpecification;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository, PrescriptionMapper prescriptionMapper, PrescriptionSpecification prescriptionSpecification) {
        this.prescriptionRepository = prescriptionRepository;
        this.prescriptionMapper = prescriptionMapper;
        this.prescriptionSpecification = prescriptionSpecification;
    }

    @Override
    protected PrescriptionMapper getMapper() {
        return this.prescriptionMapper;
    }

    @Override
    protected PrescriptionRepository getRepository() {
        return this.prescriptionRepository;
    }

    @Override
    protected PrescriptionSpecification getSpecification() {
        return this.prescriptionSpecification;
    }
}
