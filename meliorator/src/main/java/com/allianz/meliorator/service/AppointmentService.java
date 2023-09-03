package com.allianz.meliorator.service;

import com.allianz.meliorator.database.entity.Appointment;
import com.allianz.meliorator.database.repository.AppointmentRepository;
import com.allianz.meliorator.database.specification.AppointmentSpecification;
import com.allianz.meliorator.mapper.AppointmentMapper;
import com.allianz.meliorator.model.dto.AppointmentDTO;
import com.allianz.meliorator.model.requestDTO.AppointmentRequestDTO;
import com.allianz.meliorator.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends BaseService<Appointment, AppointmentDTO,
        AppointmentRequestDTO, AppointmentMapper, AppointmentRepository, AppointmentSpecification> {
    @Autowired
    AppointmentSpecification appointmentSpecification;
    @Autowired
    AppointmentMapper appointmentMapper;
    @Autowired
    AppointmentRepository appointmentRepository;


    @Override
    protected AppointmentMapper getMapper() {
        return this.appointmentMapper;
    }

    @Override
    protected AppointmentRepository getRepository() {
        return this.appointmentRepository;
    }

    @Override
    protected AppointmentSpecification getSpecification() {
        return null;
    }
}
