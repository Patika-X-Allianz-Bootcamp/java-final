package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.model.DTO.AppointmentDTO;
import com.allianz.healthtourism.model.DTO.PageDTO;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapper implements IBaseMapper<AppointmentDTO, AppointmentEntity, AppointmentRequestDTO> {
    private final DoctorMapper doctorMapper;
    private final PatientMapper patientMapper;

    public AppointmentMapper(DoctorMapper doctorMapper, PatientMapper patientMapper) {
        this.doctorMapper = doctorMapper;
        this.patientMapper = patientMapper;
    }

    @Override
    public AppointmentDTO entityToDTO(AppointmentEntity entity) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setAppointmentDateTime(entity.getAppointmentDateTime());
        dto.setDoctor(doctorMapper.entityToDTO(entity.getDoctor()));
        dto.setPatient(patientMapper.entityToDTO(entity.getPatient()));



        return dto;
    }

    @Override
    public AppointmentEntity dtoToEntity(AppointmentDTO dto) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        entity.setAppointmentDateTime(dto.getAppointmentDateTime());

        return entity;
    }

    @Override
    public List<AppointmentDTO> entityListToDTOList(List<AppointmentEntity> entityList) {
        List<AppointmentDTO> dtoList = new ArrayList<>();

        for (AppointmentEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<AppointmentEntity> dtoListTOEntityList(List<AppointmentDTO> dtoList) {
        List<AppointmentEntity> entities = new ArrayList<>();

        for (AppointmentDTO dto: dtoList){
            entities.add(dtoToEntity(dto));
        }

        return entities;
    }

    @Override
    public AppointmentEntity requestDTOToEntity(AppointmentRequestDTO dto) {
        return null;
    }

    @Override
    public List<AppointmentEntity> requestDtoListTOEntityList(List<AppointmentRequestDTO> appointmentRequestDTOS) {
        return null;
    }

    @Override
    public AppointmentEntity requestDtoToExistEntity(AppointmentEntity entity, AppointmentRequestDTO appointmentRequestDTO) {
        return null;
    }

    @Override
    public PageDTO<AppointmentDTO> pageEntityToPageDTO(Page<AppointmentEntity> appointmentEntities) {
        return null;
    }

    @Override
    public AppointmentEntity dtoToExistEntity(AppointmentEntity entity, AppointmentDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        entity.setAppointmentDateTime(dto.getAppointmentDateTime());

        return entity;
    }
}

