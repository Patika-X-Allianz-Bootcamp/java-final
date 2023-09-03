package com.allianz.medicaltourismapp.service;
import com.allianz.medicaltourismapp.database.entity.AppointmentEntity;
import com.allianz.medicaltourismapp.database.repository.AppointmentEntityRepository;
import com.allianz.medicaltourismapp.database.specification.AppointmentSpecification;

import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.CreditCardMapper;
import com.allianz.medicaltourismapp.model.AppointmentDTO;
import com.allianz.medicaltourismapp.util.BaseService;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AppointmentService extends BaseService<
        AppointmentDTO,
        AppointmentEntity,
        AppointmentEntityRepository,
        AppointmentMapper,
        AppointmentSpecification> {

    private final AppointmentEntityRepository appointmentEntityRepository;


    private final AppointmentSpecification appointmentSpecification;

    private final AppointmentMapper mapper;

    @Override
    protected AppointmentMapper getMapper() {
        return mapper;
    }

    @Override
    protected AppointmentEntityRepository getRepository() {
        return appointmentEntityRepository;
    }

    @Override
    protected AppointmentSpecification getSpecification() {
        return appointmentSpecification;
    }
}
