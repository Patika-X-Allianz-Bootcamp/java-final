package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.model.DTO.PageDTO;
import com.allianz.healthtourism.model.DTO.PatientDTO;
import com.allianz.healthtourism.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PatientMapper implements IBaseMapper<PatientDTO, PatientEntity, PatientRequestDTO> {

    private final DoctorMapper doctorMapper;

    private final FlightMapper flightMapper;

    private final AppointmentMapper appointmentMapper;

    public PatientMapper(DoctorMapper doctorMapper, FlightMapper flightMapper, AppointmentMapper appointmentMapper) {
        this.doctorMapper = doctorMapper;
        this.flightMapper = flightMapper;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public PatientDTO entityToDTO(PatientEntity entity) {
        PatientDTO dto = new PatientDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setTc(entity.getTc());
        dto.setEmail(entity.getEmail());
        dto.setAppointment(appointmentMapper.entityToDTO(entity.getAppointment()));
        dto.setDoctor(doctorMapper.entityToDTO(entity.getDoctor()));
        dto.setFlight(flightMapper.entityToDTO(entity.getFlight()));
        return dto;
    }

    @Override
    public PatientEntity dtoToEntity(PatientDTO dto) {
        PatientEntity entity = new PatientEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAppointment(appointmentMapper.dtoToEntity(dto.getAppointment()));
        entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        entity.setFlight(flightMapper.dtoToEntity(dto.getFlight()));
        return entity;
    }

    @Override
    public List<PatientDTO> entityListToDTOList(List<PatientEntity> entityList) {
        List<PatientDTO> dtoList = new ArrayList<>();

        for (PatientEntity entity: entityList){
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<PatientEntity> dtoListTOEntityList(List<PatientDTO> dtoList) {

        List<PatientEntity> entityList = new ArrayList<>();

        for (PatientDTO dto: dtoList){
            entityList.add(dtoToEntity(dto));
        }

        return entityList;
    }

    @Override
    public PatientEntity requestDTOToEntity(PatientRequestDTO dto) {
        return null;
    }

    @Override
    public List<PatientEntity> requestDtoListTOEntityList(List<PatientRequestDTO> patientRequestDTOS) {
        return null;
    }

    @Override
    public PatientEntity requestDtoToExistEntity(PatientEntity entity, PatientRequestDTO patientRequestDTO) {
        return null;
    }

    @Override
    public PatientEntity dtoToExistEntity(PatientEntity entity, PatientDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setTc(dto.getTc());
        entity.setEmail(dto.getEmail());
        entity.setAppointment(appointmentMapper.dtoToEntity(dto.getAppointment()));
        entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        entity.setFlight(flightMapper.dtoToEntity(dto.getFlight()));

        return entity;
    }

    @Override
    public PageDTO<PatientDTO> pageEntityToPageDTO(Page<PatientEntity> patientEntities) {
        return null;
    }
}
