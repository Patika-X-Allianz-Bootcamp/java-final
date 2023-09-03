package com.allianz.HealthTourismSpringBoot.mapper;

import com.allianz.HealthTourismSpringBoot.database.entities.DoctorEntity;
import com.allianz.HealthTourismSpringBoot.model.DoctorDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.DoctorRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper implements IBaseMapper<DoctorEntity, DoctorDTO, DoctorRequestDTO> {

    @Autowired
    @Lazy
    HospitalMapper hospitalMapper;

    @Override
    public DoctorDTO entityToDTO(DoctorEntity entity) {

        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setUuid(entity.getUuid());
        doctorDTO.setId(entity.getId());
        doctorDTO.setCreationDate(entity.getCreationDate());
        doctorDTO.setUpdatedDate(entity.getUpdatedDate());
        doctorDTO.setName(entity.getName());
        doctorDTO.setSurname(entity.getSurname());
        doctorDTO.setProfession(entity.getProfession());
        doctorDTO.setHospital(hospitalMapper.entityToDTO(entity.getHospital()));

        return doctorDTO;
    }

    @Override
    public DoctorEntity dtoToEntity(DoctorDTO dto) {

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setUuid(dto.getUuid());
        doctorEntity.setId(dto.getId());
        doctorEntity.setCreationDate(dto.getCreationDate());
        doctorEntity.setUpdatedDate(dto.getUpdatedDate());
        doctorEntity.setName(dto.getName());
        doctorEntity.setSurname(dto.getSurname());
        doctorEntity.setProfession(dto.getProfession());
        doctorEntity.setHospital(hospitalMapper.dtoToEntity(dto.getHospital()));

        return doctorEntity;
    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<DoctorEntity> doctorEntities) {

        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        for (DoctorEntity entity : doctorEntities){
            doctorDTOList.add(entityToDTO(entity));
        }
        return doctorDTOList;
    }

    @Override
    public List<DoctorEntity> dtoListToEntityList(List<DoctorDTO> doctorDTOS) {

        List<DoctorEntity> doctorEntityList = new ArrayList<>();
        for (DoctorDTO dto : doctorDTOS){
            doctorEntityList.add(dtoToEntity(dto));
        }
        return doctorEntityList;
    }

    @Override
    public DoctorEntity requestDTOToEntity(DoctorRequestDTO doctorRequestDTO) {

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setUuid(doctorRequestDTO.getUuid());
        doctorEntity.setId(doctorRequestDTO.getId());
        doctorEntity.setCreationDate(doctorRequestDTO.getCreationDate());
        doctorEntity.setUpdatedDate(doctorRequestDTO.getUpdatedDate());
        doctorEntity.setName(doctorRequestDTO.getName());
        doctorEntity.setSurname(doctorRequestDTO.getSurname());
        doctorEntity.setProfession(doctorRequestDTO.getProfession());
        doctorEntity.setHospital(hospitalMapper.requestDTOToEntity(doctorRequestDTO.getHospital()));

        return doctorEntity;
    }

    @Override
    public List<DoctorEntity> requestDTOListToEntityList(List<DoctorRequestDTO> doctorRequestDTOS) {

        List<DoctorEntity> doctorEntityList = new ArrayList<>();
        for (DoctorRequestDTO requestDTO : doctorRequestDTOS){
            doctorEntityList.add(requestDTOToEntity(requestDTO));
        }
        return doctorEntityList;
    }

    @Override
    public DoctorEntity requestDTOToExistEntity(DoctorRequestDTO doctorRequestDTO, DoctorEntity entity) {

        entity.setName(doctorRequestDTO.getName());
        entity.setSurname(doctorRequestDTO.getSurname());
        entity.setProfession(doctorRequestDTO.getProfession());
        entity.setHospital(hospitalMapper.requestDTOToEntity(doctorRequestDTO.getHospital()));

        return entity;
    }

    @Override
    public Page<DoctorDTO> pageEntityToPageDTO(Page<DoctorEntity> doctorEntities) {
        return doctorEntities.map(this::entityToDTO);
    }
}
