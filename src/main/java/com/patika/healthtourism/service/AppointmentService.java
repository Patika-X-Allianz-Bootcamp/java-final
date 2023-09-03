package com.patika.healthtourism.service;

import com.patika.healthtourism.database.entity.AppointmentEntity;
import com.patika.healthtourism.database.repository.AppointmentEntityRepository;
import com.patika.healthtourism.mapper.AppointmentMapper;
import com.patika.healthtourism.model.AppointmentDTO;
import com.patika.healthtourism.model.requestDTO.*;
import com.patika.healthtourism.util.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService extends BaseService<AppointmentEntity, AppointmentDTO, AppointmentCreateRequestDTO,
        AppointmentMapper, AppointmentEntityRepository> {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentEntityRepository appointmentEntityRepository;
    private final PatientService patientService;
    private final HospitalService hospitalService;
    private final HealthServiceService healthServiceService;
    private final DoctorService doctorService;

    public AppointmentService(AppointmentMapper appointmentMapper, AppointmentEntityRepository appointmentEntityRepository,
                              PatientService patientService, HospitalService hospitalService, HealthServiceService healthServiceService, DoctorService doctorService) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentEntityRepository = appointmentEntityRepository;
        this.patientService = patientService;
        this.hospitalService = hospitalService;
        this.healthServiceService = healthServiceService;
        this.doctorService = doctorService;
    }

    @Override
    protected AppointmentMapper getMapper() {
        return appointmentMapper;
    }

    @Override
    protected AppointmentEntityRepository getRepository() {
        return appointmentEntityRepository;
    }
    @Transactional
    public boolean selectPatient(UUID appointmentUuid, PatientRequestDTO patient) {
        Optional<AppointmentEntity> appointmentEntityOptional
                = appointmentEntityRepository.findByUuid(appointmentUuid);
        if(appointmentEntityOptional.isPresent()){
            AppointmentEntity appointment =appointmentEntityOptional.get();
            appointment.setPatient(patientService.getMapper().requestDtoToEntity(patient));
            appointmentEntityRepository.save(appointment);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean selectHospital(UUID appointmentUuid, HospitalRequestDTO hospitalRequestDTO) {
        Optional<AppointmentEntity> appointmentEntityOptional
                = appointmentEntityRepository.findByUuid(appointmentUuid);
        if(appointmentEntityOptional.isPresent()){
            AppointmentEntity appointment =appointmentEntityOptional.get();
            appointment.setHospital(hospitalService.getMapper().requestDtoToEntity(hospitalRequestDTO));
            appointmentEntityRepository.save(appointment);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean selectHealthService(UUID appointmentUuid, HealthServiceRequestDTO healthService) {
        Optional<AppointmentEntity> appointmentEntityOptional
                = appointmentEntityRepository.findByUuid(appointmentUuid);
        if(appointmentEntityOptional.isPresent()){
            AppointmentEntity appointment =appointmentEntityOptional.get();
            appointment.setHealthService(healthServiceService.getMapper().requestDtoToEntity(healthService));
            appointmentEntityRepository.save(appointment);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean selectDoctor(UUID appointmentUuid, DoctorCreateRequestDTO doctor) {
        Optional<AppointmentEntity> appointmentEntityOptional
                = appointmentEntityRepository.findByUuid(appointmentUuid);
        if(appointmentEntityOptional.isPresent()){
            AppointmentEntity appointment =appointmentEntityOptional.get();
            appointment.setDoctor(doctorService.getMapper().requestDtoToEntity(doctor));
            appointmentEntityRepository.save(appointment);
            return true;
        }
        return false;
    }

    public Boolean approve(UUID appointmentUuid, boolean approve) {
        Optional<AppointmentEntity> appointmentEntityOptional
                = appointmentEntityRepository.findByUuid(appointmentUuid);
        if(appointmentEntityOptional.isPresent()){
            AppointmentEntity appointment = appointmentEntityOptional.get();
            appointment.setConfirmed(approve);
            appointmentEntityRepository.save(appointment);
            return true;
        }
        return false;
    }
}
