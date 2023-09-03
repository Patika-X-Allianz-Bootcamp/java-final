package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.model.DTO.HospitalDTO;
import com.allianz.healthtourism.model.DTO.PageDTO;
import com.allianz.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HospitalMapper implements IBaseMapper<HospitalDTO, HospitalEntity, HospitalRequestDTO> {

    private final DoctorMapper doctorMapper;

    private final CityMapper cityMapper;

    public HospitalMapper(DoctorMapper doctorMapper, CityMapper cityMapper) {
        this.cityMapper = cityMapper;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public HospitalDTO entityToDTO(HospitalEntity entity) {
        HospitalDTO dto = new HospitalDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setCity(cityMapper.entityToDTO(entity.getCity()));
        dto.setName(entity.getName());
        dto.setDoctorList(doctorMapper.entityListToDTOList(entity.getDoctorList()));
        return dto;
    }

    @Override
    public HospitalEntity dtoToEntity(HospitalDTO dto) {
        HospitalEntity entity = new HospitalEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCity(cityMapper.dtoToEntity(dto.getCity()));
        entity.setName(dto.getName());
        entity.setDoctorList(doctorMapper.dtoListTOEntityList(dto.getDoctorList()));
        return entity;
    }

    @Override
    public List<HospitalDTO> entityListToDTOList(List<HospitalEntity> entityList) {
        List<HospitalDTO> dtoList = new ArrayList<>();

        for (HospitalEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<HospitalEntity> dtoListTOEntityList(List<HospitalDTO> dtoList) {
        List<HospitalEntity> entities = new ArrayList<>();

        for (HospitalDTO dto: dtoList){
            entities.add(dtoToEntity(dto));
        }

        return entities;
    }

    @Override
    public HospitalEntity requestDTOToEntity(HospitalRequestDTO dto) {
        return null;
    }

    @Override
    public List<HospitalEntity> requestDtoListTOEntityList(List<HospitalRequestDTO> hospitalRequestDTOS) {
        return null;
    }

    @Override
    public HospitalEntity requestDtoToExistEntity(HospitalEntity entity, HospitalRequestDTO hospitalRequestDTO) {
        return null;
    }

    @Override
    public PageDTO<HospitalDTO> pageEntityToPageDTO(Page<HospitalEntity> hospitalEntities) {
        return null;
    }

    @Override
    public HospitalEntity dtoToExistEntity(HospitalEntity entity, HospitalDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCity(cityMapper.dtoToEntity(dto.getCity()));
        entity.setName(dto.getName());
        entity.setDoctorList(doctorMapper.dtoListTOEntityList(dto.getDoctorList()));

        return entity;
    }
}
