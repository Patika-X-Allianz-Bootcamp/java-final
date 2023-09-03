package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.*;
import com.example.healthtourismapp.database.repositories.*;
import com.example.healthtourismapp.database.specification.AppointmentSpecification;
import com.example.healthtourismapp.mapper.*;
import com.example.healthtourismapp.model.AppointmentDTO;
import com.example.healthtourismapp.model.requestDTO.AppointmentRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends BaseService<AppointmentEntity,
        AppointmentDTO,
        AppointmentRequestDTO,
        AppointmentMapper,
        AppointmentRepository, AppointmentSpecification> {

    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentSpecification appointmentSpecification;

    public AppointmentService(AppointmentMapper appointmentMapper, AppointmentRepository appointmentRepository, AppointmentSpecification appointmentSpecification) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepository = appointmentRepository;
        this.appointmentSpecification = appointmentSpecification;
    }


    @Override
    public AppointmentMapper getMapper() {
        return appointmentMapper;
    }

    @Override
    public AppointmentRepository getRepository() {
        return appointmentRepository;
    }

    @Override
    protected AppointmentSpecification getSpecification() {
        return appointmentSpecification;
    }


}
