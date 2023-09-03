package com.allianz.HealthTourismSpringBoot.mapper;

import com.allianz.HealthTourismSpringBoot.database.entities.HospitalEntity;
import com.allianz.HealthTourismSpringBoot.model.HospitalDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.HospitalRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HospitalMapper implements IBaseMapper<HospitalEntity, HospitalDTO, HospitalRequestDTO> {

    @Autowired
    @Lazy
    AgencyMapper agencyMapper;

    @Override
    public HospitalDTO entityToDTO(HospitalEntity entity) {

        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setUuid(entity.getUuid());
        hospitalDTO.setId(entity.getId());
        hospitalDTO.setCreationDate(entity.getCreationDate());
        hospitalDTO.setUpdatedDate(entity.getUpdatedDate());
        hospitalDTO.setName(entity.getName());
        hospitalDTO.setAgency(agencyMapper.entityToDTO(entity.getAgency()));

        return hospitalDTO;
    }

    @Override
    public HospitalEntity dtoToEntity(HospitalDTO dto) {

        HospitalEntity hospitalEntity = new HospitalEntity();
        hospitalEntity.setUuid(dto.getUuid());
        hospitalEntity.setId(dto.getId());
        hospitalEntity.setCreationDate(dto.getCreationDate());
        hospitalEntity.setUpdatedDate(dto.getUpdatedDate());
        hospitalEntity.setName(dto.getName());
        hospitalEntity.setAgency(agencyMapper.dtoToEntity(dto.getAgency()));

        return hospitalEntity;
    }

    @Override
    public List<HospitalDTO> entityListToDTOList(List<HospitalEntity> hospitalEntities) {

        List<HospitalDTO> hospitalDTOList = new ArrayList<>();
        for (HospitalEntity entity : hospitalEntities){
            hospitalDTOList.add(entityToDTO(entity));
        }
        return hospitalDTOList;
    }

    @Override
    public List<HospitalEntity> dtoListToEntityList(List<HospitalDTO> hospitalDTOS) {

        List<HospitalEntity> hospitalEntityList = new ArrayList<>();
        for (HospitalDTO dto : hospitalDTOS){
            hospitalEntityList.add(dtoToEntity(dto));
        }
        return hospitalEntityList;
    }

    @Override
    public HospitalEntity requestDTOToEntity(HospitalRequestDTO hospitalRequestDTO) {

        HospitalEntity hospitalEntity = new HospitalEntity();
        hospitalEntity.setUuid(hospitalRequestDTO.getUuid());
        hospitalEntity.setId(hospitalRequestDTO.getId());
        hospitalEntity.setCreationDate(hospitalRequestDTO.getCreationDate());
        hospitalEntity.setUpdatedDate(hospitalRequestDTO.getUpdatedDate());
        hospitalEntity.setName(hospitalRequestDTO.getName());
        hospitalEntity.setAgency(agencyMapper.requestDTOToEntity(hospitalRequestDTO.getAgency()));

        return hospitalEntity;
    }

    @Override
    public List<HospitalEntity> requestDTOListToEntityList(List<HospitalRequestDTO> hospitalRequestDTOS) {

        List<HospitalEntity> hospitalEntityList = new ArrayList<>();
        for (HospitalRequestDTO requestDTO : hospitalRequestDTOS){
            hospitalEntityList.add(requestDTOToEntity(requestDTO));
        }
        return hospitalEntityList;
    }

    @Override
    public HospitalEntity requestDTOToExistEntity(HospitalRequestDTO hospitalRequestDTO, HospitalEntity entity) {

        entity.setName(hospitalRequestDTO.getName());
        entity.setAgency(agencyMapper.requestDTOToEntity(hospitalRequestDTO.getAgency()));

        return entity;
    }

    @Override
    public Page<HospitalDTO> pageEntityToPageDTO(Page<HospitalEntity> hospitalEntities) {
        return hospitalEntities.map(this::entityToDTO);
    }
}
