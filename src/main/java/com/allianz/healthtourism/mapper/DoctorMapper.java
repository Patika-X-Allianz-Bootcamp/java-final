package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.model.DTO.DoctorDTO;
import com.allianz.healthtourism.model.DTO.PageDTO;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DoctorMapper implements IBaseMapper<DoctorDTO, DoctorEntity, DoctorRequestDTO> {

    private final HospitalMapper hospitalMapper;
    private final PatientMapper patientMapper;
    private final ReportMapper reportMapper;
    private final AppointmentMapper appointmentMapper;

    private final HealthCareMapper healthCareMapper;

    public DoctorMapper(HospitalMapper hospitalMapper, PatientMapper patientMapper, ReportMapper reportMapper, AppointmentMapper appointmentMapper, HealthCareMapper healthCareMapper) {
        this.hospitalMapper = hospitalMapper;
        this.patientMapper = patientMapper;
        this.reportMapper = reportMapper;
        this.appointmentMapper = appointmentMapper;
        this.healthCareMapper = healthCareMapper;
    }

    @Override
    public DoctorDTO entityToDTO(DoctorEntity entity) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setHospital(hospitalMapper.entityToDTO(entity.getHospital()));
        dto.setPatientEntityList(patientMapper.entityListToDTOList(entity.getPatientEntityList()));
        dto.setAppointmentList(appointmentMapper.entityListToDTOList(entity.getAppointmentList()));
        dto.setHealthCare(healthCareMapper.entityToDTO(entity.getHealthCare()));
        return dto;
    }

    @Override
    public DoctorEntity dtoToEntity(DoctorDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setHealthCare(healthCareMapper.dtoToEntity(dto.getHealthCare()));
        entity.setHospital(hospitalMapper.dtoToEntity(dto.getHospital()));
        entity.setPatientEntityList(patientMapper.dtoListTOEntityList(dto.getPatientEntityList()));
        entity.setAppointmentList(appointmentMapper.dtoListTOEntityList(dto.getAppointmentList()));

        return entity;
    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<DoctorEntity> entityList) {
        List<DoctorDTO> dtoList = new ArrayList<>();

        for (DoctorEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<DoctorEntity> dtoListTOEntityList(List<DoctorDTO> dtoList) {
        List<DoctorEntity> entities = new ArrayList<>();

        for (DoctorDTO dto: dtoList){
            entities.add(dtoToEntity(dto));
        }

        return entities;
    }

    @Override
    public DoctorEntity requestDTOToEntity(DoctorRequestDTO dto) {
        return null;
    }

    @Override
    public List<DoctorEntity> requestDtoListTOEntityList(List<DoctorRequestDTO> doctorRequestDTOS) {
        return null;
    }

    @Override
    public DoctorEntity requestDtoToExistEntity(DoctorEntity entity, DoctorRequestDTO doctorRequestDTO) {
        return null;
    }

    @Override
    public PageDTO<DoctorDTO> pageEntityToPageDTO(Page<DoctorEntity> doctorEntities) {
        return null;
    }

    @Override
    public DoctorEntity dtoToExistEntity(DoctorEntity entity, DoctorDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setHospital(hospitalMapper.dtoToEntity(dto.getHospital()));
        entity.setPatientEntityList(patientMapper.dtoListTOEntityList(dto.getPatientEntityList()));
        entity.setAppointmentList(appointmentMapper.dtoListTOEntityList(dto.getAppointmentList()));

        return entity;
    }
}