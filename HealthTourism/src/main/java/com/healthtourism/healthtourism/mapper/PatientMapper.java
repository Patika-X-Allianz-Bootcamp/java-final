package com.healthtourism.healthtourism.mapper;

import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.model.PatientDTO;
import com.healthtourism.healthtourism.model.RequestDTO.PatientRequestDTO;
import com.healthtourism.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper implements IBaseMapper<PatientEntity, PatientDTO, PatientRequestDTO> {

    @Override
    public PatientDTO entityToDTO(PatientEntity patientEntity) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setCreationDate(patientEntity.getCreationDate());
        patientDTO.setId(patientEntity.getId());
        patientDTO.setUuid(patientEntity.getUuid());
        patientDTO.setId(patientEntity.getId());
        patientDTO.setFirstName(patientEntity.getFirstName());
        patientDTO.setLastName(patientEntity.getLastName());
        patientDTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientDTO.setGender(patientEntity.getGender());
        patientDTO.setPhoneNumber(patientEntity.getPhoneNumber());
        return patientDTO;
    }

    @Override
    public PatientEntity dtoToEntity(PatientDTO patientDTO) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setUuid(patientDTO.getUuid());
        patientEntity.setFirstName(patientDTO.getFirstName());
        patientEntity.setLastName(patientDTO.getLastName());
        patientEntity.setPhoneNumber(patientDTO.getPhoneNumber());
        patientEntity.setDateOfBirth(patientDTO.getDateOfBirth());
        patientEntity.setGender(patientDTO.getGender());
        patientEntity.setCreationDate(patientDTO.getCreationDate());
        patientEntity.setId(patientDTO.getId());
        patientEntity.setUpdatedDate(patientDTO.getUpdatedDate());
        return patientEntity;

    }

    @Override
    public List<PatientDTO> entityListToDTOList(List<PatientEntity> patientEntities) {
        List<PatientDTO> patientDTOList = new ArrayList<>();

        for (PatientEntity patientEntity : patientEntities) {
            patientDTOList.add(entityToDTO(patientEntity));
        }

        return patientDTOList;
    }

    @Override
    public List<PatientEntity> dtoListToEntityList(List<PatientDTO> patientDTOS) {
        List<PatientEntity> patientEntityList = new ArrayList<>();

        for (PatientDTO patientDTO : patientDTOS) {
            patientEntityList.add(dtoToEntity(patientDTO));
        }
        return patientEntityList;
    }

    @Override
    public PatientEntity requestDTOToEntity(PatientRequestDTO patientRequestDTO) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName(patientRequestDTO.getFirstName());
        patientEntity.setLastName(patientRequestDTO.getLastName());
        patientEntity.setId(patientRequestDTO.getId());
        patientEntity.setUuid(patientRequestDTO.getUuid());
        patientEntity.setCreationDate(patientRequestDTO.getCreationDate());
        patientEntity.setUpdatedDate(patientRequestDTO.getUpdatedDate());
        patientEntity.setGender(patientRequestDTO.getGender());
        patientEntity.setPhoneNumber(patientRequestDTO.getPhoneNumber());
        patientEntity.setDateOfBirth(patientRequestDTO.getDateOfBirth());

        return patientEntity;
    }

    @Override
    public List<PatientEntity> requestDTOListToEntityList(List<PatientRequestDTO> patientRequestDTOS) {
        List<PatientEntity> patientEntityList = new ArrayList<>();
        for (PatientRequestDTO patientRequestDTO : patientRequestDTOS) {
            patientEntityList.add(requestDTOToEntity(patientRequestDTO));
        }
        return patientEntityList;
    }

    @Override
    public PatientEntity requestDTOToExistEntity(PatientRequestDTO patientRequestDTO, PatientEntity patientEntity) {
        patientEntity.setPhoneNumber(patientRequestDTO.getPhoneNumber());
        patientEntity.setGender(patientRequestDTO.getGender());
        patientEntity.setFirstName(patientRequestDTO.getFirstName());
        patientEntity.setLastName(patientRequestDTO.getLastName());
        return patientEntity;
    }

}


