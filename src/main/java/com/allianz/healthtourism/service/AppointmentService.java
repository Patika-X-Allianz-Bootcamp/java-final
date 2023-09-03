package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.repository.AppointmentRepository;
import com.allianz.healthtourism.mapper.AppointmentMapper;
import com.allianz.healthtourism.model.DTO.AppointmentDTO;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;


@Service
public class AppointmentService extends BaseService<AppointmentEntity, AppointmentDTO,
        AppointmentRequestDTO, AppointmentMapper, AppointmentRepository> {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentMapper appointmentMapper, AppointmentRepository appointmentRepository) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepository = appointmentRepository;
    }
    @Override
    protected AppointmentMapper getMapper() {
        return appointmentMapper;
    }
    @Override
    protected AppointmentRepository getRepository() {
        return appointmentRepository;
    }

}
