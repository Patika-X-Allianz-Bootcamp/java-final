package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.ReportEntity;
import com.example.healthtourismapp.model.ReportDTO;
import com.example.healthtourismapp.model.requestDTO.ReportRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReportMapper implements IBaseMapper<ReportEntity, ReportDTO, ReportRequestDTO> {

    private final DoctorMapper doctorMapper;

    private final PatientMapper patientMapper;

    public ReportMapper(DoctorMapper doctorMapper, PatientMapper patientMapper) {
        this.doctorMapper = doctorMapper;
        this.patientMapper = patientMapper;
    }

    @Override
    public ReportDTO entityToDTO(ReportEntity entity) {

        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setId(entity.getId());
        reportDTO.setUuid(entity.getUuid());
        reportDTO.setDate(entity.getDate());
        reportDTO.setCreationDate(entity.getCreationDate());
        reportDTO.setUpdatedDate(entity.getUpdatedDate());
        reportDTO.setContent(entity.getContent());
        reportDTO.setDoctor(doctorMapper.entityToDTO(entity.getDoctor()));
        reportDTO.setPatient(patientMapper.entityToDTO(entity.getPatient()));

        return reportDTO;
    }

    @Override
    public ReportEntity dtoToEntity(ReportDTO dto) {

        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setId(dto.getId());
        reportEntity.setUuid(dto.getUuid());
        reportEntity.setDate(dto.getDate());
        reportEntity.setCreationDate(dto.getCreationDate());
        reportEntity.setUpdatedDate(dto.getUpdatedDate());
        reportEntity.setContent(dto.getContent());
        reportEntity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        reportEntity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));

        return reportEntity;
    }

    @Override
    public List<ReportDTO> entityListToDTOList(List<ReportEntity> reportEntities) {

        List<ReportDTO> reportDTOS = new ArrayList<>();
        for (ReportEntity entity : reportEntities) {
            reportDTOS.add(entityToDTO(entity));
        }
        return reportDTOS;
    }

    @Override
    public List<ReportEntity> dtoListToEntityList(List<ReportDTO> reportDTOS) {

        List<ReportEntity> reportEntities = new ArrayList<>();
        for (ReportDTO dto : reportDTOS) {
            reportEntities.add(dtoToEntity(dto));
        }
        return reportEntities;
    }

    @Override
    public ReportEntity requestDTOToEntity(ReportRequestDTO reportRequestDTO) {

        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setId(reportRequestDTO.getId());
        reportEntity.setUuid(reportRequestDTO.getUuid());
        reportEntity.setDate(reportRequestDTO.getDate());
        reportEntity.setCreationDate(reportRequestDTO.getCreationDate());
        reportEntity.setUpdatedDate(reportRequestDTO.getUpdatedDate());
        reportEntity.setContent(reportRequestDTO.getContent());
        reportEntity.setDoctor(doctorMapper.dtoToEntity(reportRequestDTO.getDoctor()));
        reportEntity.setPatient(patientMapper.dtoToEntity(reportRequestDTO.getPatient()));

        return reportEntity;
    }

    @Override
    public List<ReportEntity> requestDTOListToEntityList(List<ReportRequestDTO> reportRequestDTOS) {

        List<ReportEntity> reportEntities = new ArrayList<>();
        for (ReportRequestDTO requestDTO : reportRequestDTOS) {
            reportEntities.add(requestDTOToEntity(requestDTO));
        }
        return reportEntities;
    }

    @Override
    public ReportEntity requestDTOToExistEntity(ReportRequestDTO reportRequestDTO, ReportEntity entity) {

        entity.setDate(reportRequestDTO.getDate());
        entity.setContent(reportRequestDTO.getContent());
        entity.setDoctor(doctorMapper.dtoToEntity(reportRequestDTO.getDoctor()));
        entity.setPatient(patientMapper.dtoToEntity(reportRequestDTO.getPatient()));

        return entity;
    }

    @Override
    public Page<ReportDTO> pageEntityToPageDTO(Page<ReportEntity> reportEntities) {
        return reportEntities.map(this::entityToDTO);
    }


}
