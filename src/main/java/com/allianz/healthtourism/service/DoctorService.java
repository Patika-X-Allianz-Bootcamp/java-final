package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.repository.AppointmentRepository;
import com.allianz.healthtourism.database.repository.DoctorRepository;
import com.allianz.healthtourism.mapper.AppointmentMapper;
import com.allianz.healthtourism.mapper.DoctorMapper;
import com.allianz.healthtourism.model.DTO.DoctorDTO;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends BaseService<DoctorEntity, DoctorDTO,
        DoctorRequestDTO, DoctorMapper, DoctorRepository> {
    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;

    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;

    public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository, AppointmentMapper appointmentMapper, AppointmentRepository appointmentRepository) {
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    protected DoctorRepository getRepository() {
        return doctorRepository;
    }
}
