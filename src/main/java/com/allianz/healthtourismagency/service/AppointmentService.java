package com.allianz.healthtourismagency.service;

import com.allianz.healthtourismagency.database.entity.AppointmentEntity;
import com.allianz.healthtourismagency.database.repository.AppointmentRepository;
import com.allianz.healthtourismagency.database.specification.AppointmentSpecification;
import com.allianz.healthtourismagency.mapper.AppointmentMapper;
import com.allianz.healthtourismagency.model.AppointmentDTO;
import com.allianz.healthtourismagency.model.FlightDTO;
import com.allianz.healthtourismagency.model.SeatDTO;
import com.allianz.healthtourismagency.model.enums.AppointmentStatusEnum;
import com.allianz.healthtourismagency.model.enums.OccupancyStatusEnum;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourismagency.model.requestDTO.AppointmentStatusRequestDTO;
import com.allianz.healthtourismagency.util.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService extends BaseService<AppointmentEntity, AppointmentDTO, AppointmentRequestDTO,
        AppointmentMapper, AppointmentRepository, AppointmentSpecification> {

    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentSpecification appointmentSpecification;

    public AppointmentService(AppointmentMapper appointmentMapper, AppointmentRepository appointmentRepository,
                              AppointmentSpecification appointmentSpecification) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepository = appointmentRepository;
        this.appointmentSpecification = appointmentSpecification;
    }

    @Override
    protected AppointmentMapper getMapper() {
        return appointmentMapper;
    }

    @Override
    protected AppointmentRepository getRepository() {
        return appointmentRepository;
    }

    @Override
    protected AppointmentSpecification getSpecification() {
        return appointmentSpecification;
    }

    @Override
    public AppointmentDTO save(AppointmentRequestDTO appointmentRequestDTO) {
        appointmentRequestDTO.setEndTime(null);
        appointmentRequestDTO.setAppointmentStatus(null);

        AppointmentDTO appointmentDTO = appointmentMapper.entityToDto(appointmentMapper.requestDtoToEntity(appointmentRequestDTO));
        addEndTimeToAppointment(appointmentDTO);
        appointmentDTO.setAppointmentStatus(AppointmentStatusEnum.CREATED);

        appointmentRepository.save(appointmentMapper.dtoToEntity(appointmentDTO));
        return appointmentDTO;
    }

    public void addEndTimeToAppointment(AppointmentDTO appointmentDTO){
        if (appointmentDTO.getStartTime() != null) {
            Duration duration = Duration.ofMinutes(45);
            appointmentDTO.setEndTime(appointmentDTO.getStartTime().plus(duration));
        } else {
            throw new NullPointerException("The appointment startTime is null.");
        }
    }

    @Transactional
    public AppointmentDTO updateAppointmentStatus(UUID uuid, AppointmentStatusRequestDTO appointmentStatusRequestDTO){
        AppointmentEntity appointmentEntity =  getRepository().findByUuid(uuid).orElse(null);
        if (appointmentEntity != null) {
            AppointmentDTO appointmentDTO = getMapper().entityToDto(appointmentEntity);
            appointmentDTO.setAppointmentStatus(appointmentStatusRequestDTO.getAppointmentStatus());
            return getMapper().entityToDto(getRepository().save(getMapper().dtoToEntity(appointmentDTO)));
        } else {
            return null;
        }
    }


}
