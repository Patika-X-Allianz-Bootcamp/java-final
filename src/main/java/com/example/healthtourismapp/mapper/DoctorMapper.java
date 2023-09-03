package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.DoctorEntity;
import com.example.healthtourismapp.model.DoctorDTO;
import com.example.healthtourismapp.model.requestDTO.DoctorRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper implements IBaseMapper<DoctorEntity, DoctorDTO, DoctorRequestDTO> {

    @Override
    public DoctorDTO entityToDTO(DoctorEntity entity) {

        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setAge(entity.getAge());
        doctorDTO.setName(entity.getName());
        doctorDTO.setTitle(entity.getTitle());
        doctorDTO.setId(entity.getId());
        doctorDTO.setSurname(entity.getSurname());
        doctorDTO.setCreationDate(entity.getCreationDate());
        doctorDTO.setUpdatedDate(entity.getUpdatedDate());
        doctorDTO.setUuid(entity.getUuid());

        return doctorDTO;
    }

    @Override
    public DoctorEntity dtoToEntity(DoctorDTO dto) {

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setAge(dto.getAge());
        doctorEntity.setName(dto.getName());
        doctorEntity.setTitle(dto.getTitle());
        doctorEntity.setId(dto.getId());
        doctorEntity.setSurname(dto.getSurname());
        doctorEntity.setCreationDate(dto.getCreationDate());
        doctorEntity.setUpdatedDate(dto.getUpdatedDate());
        doctorEntity.setUuid(dto.getUuid());

        return doctorEntity;
    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<DoctorEntity> doctorEntities) {

        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        for (DoctorEntity entity : doctorEntities) {
            doctorDTOS.add(entityToDTO(entity));
        }
        return doctorDTOS;
    }

    @Override
    public List<DoctorEntity> dtoListToEntityList(List<DoctorDTO> doctorDTOS) {

        List<DoctorEntity> doctorEntities = new ArrayList<>();
        for (DoctorDTO dto : doctorDTOS) {
            doctorEntities.add(dtoToEntity(dto));
        }
        return doctorEntities;
    }

    @Override
    public DoctorEntity requestDTOToEntity(DoctorRequestDTO doctorRequestDTO) {

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setAge(doctorRequestDTO.getAge());
        doctorEntity.setName(doctorRequestDTO.getName());
        doctorEntity.setTitle(doctorRequestDTO.getTitle());
        doctorEntity.setId(doctorRequestDTO.getId());
        doctorEntity.setSurname(doctorRequestDTO.getSurname());
        doctorEntity.setCreationDate(doctorRequestDTO.getCreationDate());
        doctorEntity.setUpdatedDate(doctorRequestDTO.getUpdatedDate());
        doctorEntity.setUuid(doctorRequestDTO.getUuid());

        return doctorEntity;
    }

    @Override
    public List<DoctorEntity> requestDTOListToEntityList(List<DoctorRequestDTO> doctorRequestDTOS) {

        List<DoctorEntity> doctorEntities = new ArrayList<>();
        for (DoctorRequestDTO requestDTO : doctorRequestDTOS) {
            doctorEntities.add(requestDTOToEntity(requestDTO));
        }
        return doctorEntities;
    }

    @Override
    public DoctorEntity requestDTOToExistEntity(DoctorRequestDTO doctorRequestDTO, DoctorEntity entity) {

        entity.setAge(doctorRequestDTO.getAge());
        entity.setTitle(doctorRequestDTO.getTitle());
        entity.setName(doctorRequestDTO.getName());
        entity.setSurname(doctorRequestDTO.getSurname());

        return entity;
    }

    @Override
    public Page<DoctorDTO> pageEntityToPageDTO(Page<DoctorEntity> doctorEntities) {
        return doctorEntities.map(this::entityToDTO);
    }
}
