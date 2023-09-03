package com.allianz.HealthTourismSpringBoot.mapper;

import com.allianz.HealthTourismSpringBoot.database.entities.ExaminationEntity;
import com.allianz.HealthTourismSpringBoot.model.ExaminationDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.ExaminationRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExaminationMapper implements IBaseMapper<ExaminationEntity, ExaminationDTO, ExaminationRequestDTO> {

    @Autowired
    @Lazy
    ClientMapper clientMapper;

    @Autowired
    @Lazy
    DoctorMapper doctorMapper;

    @Override
    public ExaminationDTO entityToDTO(ExaminationEntity entity) {

        ExaminationDTO examinationDTO = new ExaminationDTO();
        examinationDTO.setUuid(entity.getUuid());
        examinationDTO.setId(entity.getId());
        examinationDTO.setCreationDate(entity.getCreationDate());
        examinationDTO.setUpdatedDate(entity.getUpdatedDate());
        examinationDTO.setMedicalTreatment(entity.getMedicalTreatment());
        examinationDTO.setExaminationDate(entity.getExaminationDate());
        examinationDTO.setClient(clientMapper.entityToDTO(entity.getClient()));
        examinationDTO.setDoctor(doctorMapper.entityToDTO(entity.getDoctor()));

        return examinationDTO;
    }

    @Override
    public ExaminationEntity dtoToEntity(ExaminationDTO dto) {

        ExaminationEntity examinationEntity = new ExaminationEntity();
        examinationEntity.setUuid(dto.getUuid());
        examinationEntity.setId(dto.getId());
        examinationEntity.setCreationDate(dto.getCreationDate());
        examinationEntity.setUpdatedDate(dto.getUpdatedDate());
        examinationEntity.setMedicalTreatment(dto.getMedicalTreatment());
        examinationEntity.setExaminationDate(dto.getExaminationDate());
        examinationEntity.setClient(clientMapper.dtoToEntity(dto.getClient()));
        examinationEntity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));

        return examinationEntity;
    }

    @Override
    public List<ExaminationDTO> entityListToDTOList(List<ExaminationEntity> examinationEntities) {

        List<ExaminationDTO> examinationDTOList = new ArrayList<>();
        for (ExaminationEntity entity : examinationEntities){
            examinationDTOList.add(entityToDTO(entity));
        }
        return examinationDTOList;
    }

    @Override
    public List<ExaminationEntity> dtoListToEntityList(List<ExaminationDTO> examinationDTOS) {

        List<ExaminationEntity> examinationEntityList = new ArrayList<>();
        for (ExaminationDTO dto : examinationDTOS){
            examinationEntityList.add(dtoToEntity(dto));
        }
        return examinationEntityList;
    }

    @Override
    public ExaminationEntity requestDTOToEntity(ExaminationRequestDTO examinationRequestDTO) {

        ExaminationEntity examinationEntity = new ExaminationEntity();
        examinationEntity.setUuid(examinationRequestDTO.getUuid());
        examinationEntity.setId(examinationRequestDTO.getId());
        examinationEntity.setCreationDate(examinationRequestDTO.getCreationDate());
        examinationEntity.setUpdatedDate(examinationRequestDTO.getUpdatedDate());
        examinationEntity.setMedicalTreatment(examinationRequestDTO.getMedicalTreatment());
        examinationEntity.setExaminationDate(examinationRequestDTO.getExaminationDate());
        examinationEntity.setClient(clientMapper.requestDTOToEntity(examinationRequestDTO.getClient()));
        examinationEntity.setDoctor(doctorMapper.requestDTOToEntity(examinationRequestDTO.getDoctor()));

        return examinationEntity;
    }

    @Override
    public List<ExaminationEntity> requestDTOListToEntityList(List<ExaminationRequestDTO> examinationRequestDTOS) {

        List<ExaminationEntity> examinationEntityList = new ArrayList<>();
        for (ExaminationRequestDTO requestDTO : examinationRequestDTOS){
            examinationEntityList.add(requestDTOToEntity(requestDTO));
        }
        return examinationEntityList;
    }

    @Override
    public ExaminationEntity requestDTOToExistEntity(ExaminationRequestDTO examinationRequestDTO, ExaminationEntity entity) {

        entity.setMedicalTreatment(examinationRequestDTO.getMedicalTreatment());
        entity.setExaminationDate(examinationRequestDTO.getExaminationDate());
        entity.setClient(clientMapper.requestDTOToEntity(examinationRequestDTO.getClient()));
        entity.setDoctor(doctorMapper.requestDTOToEntity(examinationRequestDTO.getDoctor()));
        return entity;
    }

    @Override
    public Page<ExaminationDTO> pageEntityToPageDTO(Page<ExaminationEntity> examinationEntities) {
        return examinationEntities.map(this::entityToDTO);
    }
}
