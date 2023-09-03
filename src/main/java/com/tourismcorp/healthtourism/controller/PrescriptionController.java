package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.PrescriptionEntity;
import com.tourismcorp.healthtourism.database.repositories.PrescriptionRepository;
import com.tourismcorp.healthtourism.database.specification.PrescriptionSpecification;
import com.tourismcorp.healthtourism.mapper.PrescriptionMapper;
import com.tourismcorp.healthtourism.model.PrescriptionDTO;
import com.tourismcorp.healthtourism.model.requestDTO.PrescriptionRequestDTO;
import com.tourismcorp.healthtourism.service.PrescriptionService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prescription")
public class PrescriptionController extends BaseController<
        PrescriptionEntity,
        PrescriptionDTO,
        PrescriptionRequestDTO,
        PrescriptionMapper,
        PrescriptionRepository,
        PrescriptionSpecification,
        PrescriptionService> {

    @Autowired
    PrescriptionService prescriptionService;

    @Override
    protected PrescriptionService getService() {
        return this.prescriptionService;
    }

}
