package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.PatientEntity;
import com.example.healthtourismapp.model.PatientDTO;
import com.example.healthtourismapp.model.requestDTO.PatientRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper implements IBaseMapper<PatientEntity, PatientDTO, PatientRequestDTO> {

    private final BankAccountMapper bankAccountMapper;

    public PatientMapper(BankAccountMapper bankAccountMapper) {
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public PatientDTO entityToDTO(PatientEntity entity) {

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setAge(entity.getAge());
        patientDTO.setId(entity.getId());
        patientDTO.setBankAccount(bankAccountMapper.entityListToDTOList(entity.getBankAccount()));
        patientDTO.setTc(entity.getTc());
        patientDTO.setUuid(entity.getUuid());
        patientDTO.setGender(entity.getGender());
        patientDTO.setName(entity.getName());
        patientDTO.setSurname(entity.getSurname());
        patientDTO.setCreationDate(entity.getCreationDate());
        patientDTO.setUpdatedDate(entity.getUpdatedDate());

        return patientDTO;
    }

    @Override
    public PatientEntity dtoToEntity(PatientDTO dto) {

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setAge(dto.getAge());
        patientEntity.setId(dto.getId());
        patientEntity.setBankAccount(bankAccountMapper.dtoListToEntityList(dto.getBankAccount()));
        patientEntity.setTc(dto.getTc());
        patientEntity.setUuid(dto.getUuid());
        patientEntity.setGender(dto.getGender());
        patientEntity.setName(dto.getName());
        patientEntity.setSurname(dto.getSurname());
        patientEntity.setCreationDate(dto.getCreationDate());
        patientEntity.setUpdatedDate(dto.getUpdatedDate());

        return patientEntity;
    }

    @Override
    public List<PatientDTO> entityListToDTOList(List<PatientEntity> patientEntities) {

        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (PatientEntity entity : patientEntities) {
            patientDTOS.add(entityToDTO(entity));
        }
        return patientDTOS;
    }

    @Override
    public List<PatientEntity> dtoListToEntityList(List<PatientDTO> patientDTOS) {

        List<PatientEntity> patientEntities = new ArrayList<>();
        for (PatientDTO dto : patientDTOS) {
            patientEntities.add(dtoToEntity(dto));
        }
        return patientEntities;
    }

    @Override
    public PatientEntity requestDTOToEntity(PatientRequestDTO patientRequestDTO) {

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setAge(patientRequestDTO.getAge());
        patientEntity.setId(patientRequestDTO.getId());
        patientEntity.setBankAccount(bankAccountMapper.dtoListToEntityList(patientRequestDTO.getBankAccount()));
        patientEntity.setTc(patientRequestDTO.getTc());
        patientEntity.setUuid(patientRequestDTO.getUuid());
        patientEntity.setGender(patientRequestDTO.getGender());
        patientEntity.setName(patientRequestDTO.getName());
        patientEntity.setSurname(patientRequestDTO.getSurname());
        patientEntity.setCreationDate(patientRequestDTO.getCreationDate());
        patientEntity.setUpdatedDate(patientRequestDTO.getUpdatedDate());

        return patientEntity;
    }

    @Override
    public List<PatientEntity> requestDTOListToEntityList(List<PatientRequestDTO> patientRequestDTOS) {

        List<PatientEntity> patientEntities = new ArrayList<>();
        for (PatientRequestDTO requestDTO : patientRequestDTOS) {
            patientEntities.add(requestDTOToEntity(requestDTO));
        }
        return patientEntities;
    }

    @Override
    public PatientEntity requestDTOToExistEntity(PatientRequestDTO patientRequestDTO, PatientEntity entity) {

        entity.setAge(patientRequestDTO.getAge());
        entity.setBankAccount(bankAccountMapper.dtoListToEntityList(patientRequestDTO.getBankAccount()));
        entity.setTc(patientRequestDTO.getTc());
        entity.setGender(patientRequestDTO.getGender());
        entity.setName(patientRequestDTO.getName());
        entity.setSurname(patientRequestDTO.getSurname());

        return entity;
    }

    @Override
    public Page<PatientDTO> pageEntityToPageDTO(Page<PatientEntity> patientEntities) {
        return patientEntities.map(this::entityToDTO);
    }
}
