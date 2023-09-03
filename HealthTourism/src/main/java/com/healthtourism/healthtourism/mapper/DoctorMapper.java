package com.healthtourism.healthtourism.mapper;

import com.healthtourism.healthtourism.database.entities.DoctorEntity;
import com.healthtourism.healthtourism.model.DoctorDTO;
import com.healthtourism.healthtourism.model.RequestDTO.DoctorRequestDTO;
import com.healthtourism.healthtourism.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper implements IBaseMapper<DoctorEntity, DoctorDTO, DoctorRequestDTO> {
    @Override
    public DoctorDTO entityToDTO(DoctorEntity doctorEntity) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setFirstName(doctorEntity.getFirstName());
        doctorDTO.setLastName(doctorEntity.getLastName());
        doctorDTO.setSpecialization(doctorEntity.getSpecialization());
        doctorDTO.setId((doctorEntity.getId()));
        doctorDTO.setUuid(doctorEntity.getUuid());
        doctorDTO.setCreationDate(doctorEntity.getCreationDate());
        doctorDTO.setUpdatedDate(doctorEntity.getUpdatedDate());

        return doctorDTO;
    }

    @Override
    public DoctorEntity dtoToEntity(DoctorDTO doctorDTO) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setFirstName(doctorDTO.getFirstName());
        doctorEntity.setLastName(doctorDTO.getLastName());
        doctorEntity.setSpecialization(doctorDTO.getSpecialization());
        doctorEntity.setUpdatedDate(doctorDTO.getUpdatedDate());
        doctorEntity.setUuid(doctorDTO.getUuid());
        doctorEntity.setId(doctorDTO.getId());
        doctorEntity.setCreationDate(doctorDTO.getCreationDate());
        doctorEntity.setSpecialization(doctorDTO.getSpecialization());
        return doctorEntity;
    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<DoctorEntity> doctorEntities) {
        List<DoctorDTO> doctorDTOList = new ArrayList<>();

        for (DoctorEntity doctorEntity : doctorEntities) {
            doctorDTOList.add(entityToDTO(doctorEntity));
        }

        return doctorDTOList;
    }

    @Override
    public List<DoctorEntity> dtoListToEntityList(List<DoctorDTO> doctorDTOS) {
        List<DoctorEntity> doctorEntityList = new ArrayList<>();

        for (DoctorDTO doctorDTO : doctorDTOS) {
            doctorEntityList.add(dtoToEntity(doctorDTO));
        }
        return doctorEntityList;
    }

    @Override
    public DoctorEntity requestDTOToEntity (DoctorRequestDTO doctorRequestDTO) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setFirstName(doctorRequestDTO.getFirstName());
        doctorEntity.setLastName(doctorRequestDTO.getLastName());
       doctorEntity.setSpecialization(doctorRequestDTO.getSpecialization());
        doctorEntity.setId(doctorRequestDTO.getId());
        doctorEntity.setUuid(doctorRequestDTO.getUuid());
        doctorEntity.setCreationDate(doctorRequestDTO.getCreationDate());
        doctorEntity.setUpdatedDate(doctorRequestDTO.getUpdatedDate());


        return doctorEntity;
    }

    @Override
    public List<DoctorEntity> requestDTOListToEntityList(List<DoctorRequestDTO> doctorRequestDTOS) {
        List<DoctorEntity> doctorEntities = new ArrayList<>();
        for (DoctorRequestDTO doctorDTO : doctorRequestDTOS) {
            doctorEntities.add(requestDTOToEntity(doctorDTO));
        }
        return doctorEntities;
    }

    @Override
    public DoctorEntity requestDTOToExistEntity(DoctorRequestDTO doctorRequestDTO, DoctorEntity doctorEntity) {
        doctorEntity.setFirstName(doctorRequestDTO.getFirstName());
        doctorEntity.setLastName(doctorRequestDTO.getLastName());
        doctorEntity.setSpecialization(doctorRequestDTO.getSpecialization());
        doctorEntity.setUpdatedDate(doctorRequestDTO.getUpdatedDate());
        doctorEntity.setCreationDate(doctorRequestDTO.getCreationDate());
        doctorEntity.setId(doctorRequestDTO.getId());
        doctorEntity.setUuid(doctorRequestDTO.getUuid());

        return doctorEntity;
    }
}
