package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.AppointmentEntity;
import com.allianz.healthtourismagency.database.entity.DoctorEntity;
import com.allianz.healthtourismagency.database.repository.DoctorRepository;
import com.allianz.healthtourismagency.database.specification.DoctorSpecification;
import com.allianz.healthtourismagency.mapper.AppointmentMapper;
import com.allianz.healthtourismagency.mapper.DoctorMapper;
import com.allianz.healthtourismagency.model.AppointmentDTO;
import com.allianz.healthtourismagency.model.DoctorDTO;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class DoctorService extends BaseService<DoctorEntity, DoctorDTO, DoctorRequestDTO, DoctorMapper, DoctorRepository,
        DoctorSpecification> {

    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;
    private final DoctorSpecification doctorSpecification;
    private final AppointmentMapper appointmentMapper;

    public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository,
                         DoctorSpecification doctorSpecification, AppointmentMapper appointmentMapper) {
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
        this.doctorSpecification = doctorSpecification;
        this.appointmentMapper = appointmentMapper;
    }


    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }

    @Override
    protected DoctorRepository getRepository() {
        return doctorRepository;
    }

    @Override
    protected DoctorSpecification getSpecification() {
        return doctorSpecification;
    }

    @Transactional
    public DoctorDTO addAppointmentToDoctor(UUID uuid, AppointmentRequestDTO appointmentRequestDTO) {
        DoctorEntity doctorEntity = getRepository().findByUuid(uuid).orElse(null);
        if (doctorEntity != null) {
            if (isDoctorAvailable(doctorEntity.getAppointmentList(), appointmentRequestDTO)){
                DoctorDTO doctorDTO = getMapper().entityToDto(doctorEntity);
                AppointmentDTO appointmentDTO = appointmentMapper.entityToDto
                        (appointmentMapper.requestDtoToEntity(appointmentRequestDTO));
                doctorDTO.getAppointmentHistory().add(appointmentDTO);

                doctorEntity = getMapper().dtoToEntity(doctorDTO);
                getRepository().save(doctorEntity);
                return doctorDTO;
            }
            else {
                throw new IllegalArgumentException("Doctor not available.");
            }
        } else {
            throw new NullPointerException("Doctor not found.");
        }
    }

    public boolean isDoctorAvailable(List<AppointmentEntity> appointmentList, AppointmentRequestDTO appointmentRequestDTO) {
        for (AppointmentEntity appointment : appointmentList) {
            if (appointment.getDate().equals(appointmentRequestDTO.getDate())){

                if (!appointment.getStartTime().isAfter(appointmentRequestDTO.getStartTime().plus(Duration.ofMinutes(45)))
                        && !appointment.getEndTime().isBefore(appointmentRequestDTO.getStartTime())) {
                    return false;
                }
            }
        } return true;
    }

}
