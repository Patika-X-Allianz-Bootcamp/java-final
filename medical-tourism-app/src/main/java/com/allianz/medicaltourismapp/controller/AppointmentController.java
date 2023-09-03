package com.allianz.medicaltourismapp.controller;

import com.allianz.medicaltourismapp.database.entity.AppointmentEntity;
import com.allianz.medicaltourismapp.database.repository.AppointmentEntityRepository;
import com.allianz.medicaltourismapp.database.specification.AppointmentSpecification;
import com.allianz.medicaltourismapp.mapper.AppointmentMapper;
import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.AppointmentDTO;
import com.allianz.medicaltourismapp.service.AppointmentService;
import com.allianz.medicaltourismapp.util.BaseController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("appointment")
@RequiredArgsConstructor
public class AppointmentController extends BaseController<
        AppointmentEntity,
        AppointmentDTO,
        AppointmentMapper,
        AppointmentEntityRepository,
        AppointmentSpecification, AppointmentService
        > {

    @Autowired
    AppointmentMapper appointmentMapper;

    @Override
    protected AppointmentMapper getMapper() {
        return appointmentMapper;
    }

    @Autowired
    AppointmentService appointmentService;
    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }
}
