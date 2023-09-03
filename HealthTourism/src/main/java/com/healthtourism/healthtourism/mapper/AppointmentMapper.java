package com.healthtourism.healthtourism.mapper;

import com.healthtourism.healthtourism.database.entities.AppointmentEntity;
import com.healthtourism.healthtourism.model.AppointmentDTO;
import com.healthtourism.healthtourism.model.RequestDTO.AppointmentRequestDTO;
import com.healthtourism.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapper implements IBaseMapper<AppointmentEntity, AppointmentDTO, AppointmentRequestDTO> {
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    FlightInfoMapper flightInfoMapper;
    @Autowired
    HotelInfoMapper hotelInfoMapper;
    @Autowired
    HealthServiceMapper healthServiceMapper;


    @Override
    public AppointmentDTO entityToDTO(AppointmentEntity entity) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setDateAndTime(entity.getDateAndTime());
        dto.setStatus(entity.getStatus());
        dto.setAppointmentDate(entity.getAppointmentDate());
        dto.setCreationDate(entity.getCreationDate());
        dto.setAppointmentTime(entity.getAppointmentTime());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setStatus(entity.getStatus());
        dto.setPatient(patientMapper.entityToDTO(entity.getPatient()));
        dto.setDoctor(doctorMapper.entityToDTO(entity.getDoctor()));
        return dto;
    }

    @Override
    public AppointmentEntity dtoToEntity(AppointmentDTO dto) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setDateAndTime(dto.getDateAndTime());
        entity.setStatus(dto.getStatus());
        entity.setAppointmentDate(dto.getAppointmentDate());
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setStatus(dto.getStatus());
        entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        return entity;
    }

    @Override
    public List<AppointmentDTO> entityListToDTOList(List<AppointmentEntity> appointmentEntities) {
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        for (AppointmentEntity entity : appointmentEntities)
            appointmentDTOS.add(entityToDTO(entity));
        return appointmentDTOS;
    }

    @Override
    public List<AppointmentEntity> dtoListToEntityList(List<AppointmentDTO> appointmentDTOS) {
        List<AppointmentEntity> appointmentEntities = new ArrayList<>();
        for (AppointmentDTO dto : appointmentDTOS)
            appointmentEntities.add(dtoToEntity(dto));
        return appointmentEntities;
    }

    @Override
    public AppointmentEntity requestDTOToEntity(AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setDateAndTime(appointmentRequestDTO.getDateAndTime());
        entity.setStatus(appointmentRequestDTO.getStatus());
        entity.setId(appointmentRequestDTO.getId());
        entity.setUuid(appointmentRequestDTO.getUuid());
        entity.setAppointmentDate(appointmentRequestDTO.getAppointmentDate());
        entity.setAppointmentTime(appointmentRequestDTO.getAppointmentTime());
        entity.setCreationDate(appointmentRequestDTO.getCreationDate());
        entity.setStatus(appointmentRequestDTO.getStatus());
        entity.setUpdatedDate(appointmentRequestDTO.getUpdatedDate());
        entity.setPatient(patientMapper.dtoToEntity(appointmentRequestDTO.getPatient()));
        entity.setDoctor(doctorMapper.dtoToEntity(appointmentRequestDTO.getDoctor()));
        return entity;
    }

    @Override
    public List<AppointmentEntity> requestDTOListToEntityList(List<AppointmentRequestDTO> appointmentRequestDTOS) {
        List<AppointmentEntity> entityList = new ArrayList<>();
        for (AppointmentRequestDTO requestDTO : appointmentRequestDTOS) {
            entityList.add(requestDTOToEntity(requestDTO));
        }
        return entityList;
    }

    @Override
    public AppointmentEntity requestDTOToExistEntity(AppointmentRequestDTO appointmentRequestDTO, AppointmentEntity entity) {
        entity.setDateAndTime(appointmentRequestDTO.getDateAndTime());
        entity.setStatus(appointmentRequestDTO.getStatus());
        entity.setUuid(appointmentRequestDTO.getUuid());
        entity.setId(appointmentRequestDTO.getId());
        entity.setCreationDate(appointmentRequestDTO.getCreationDate());
        entity.setUpdatedDate(appointmentRequestDTO.getUpdatedDate());
        entity.setStatus(appointmentRequestDTO.getStatus());
        entity.setAppointmentDate(appointmentRequestDTO.getAppointmentDate());
        entity.setStatus(appointmentRequestDTO.getStatus());
        entity.setAppointmentTime(appointmentRequestDTO.getAppointmentTime());
        entity.setPatient(patientMapper.dtoToEntity(appointmentRequestDTO.getPatient()));
        entity.setDoctor(doctorMapper.dtoToEntity(appointmentRequestDTO.getDoctor()));

        return entity;

    }
}
