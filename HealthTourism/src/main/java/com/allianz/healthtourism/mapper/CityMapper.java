package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.model.DTO.CityDTO;
import com.allianz.healthtourism.model.DTO.DoctorDTO;
import com.allianz.healthtourism.model.DTO.PageDTO;
import com.allianz.healthtourism.model.requestDTO.CityRequestDTO;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityMapper implements IBaseMapper<CityDTO, CityEntity, CityRequestDTO> {
    @Override
    public CityDTO entityToDTO(CityEntity entity) {
        return null;
    }

    @Override
    public CityEntity dtoToEntity(CityDTO dto) {
        return null;
    }

    @Override
    public List<CityDTO> entityListToDTOList(List<CityEntity> cityEntities) {
        return null;
    }

    @Override
    public List<CityEntity> dtoListTOEntityList(List<CityDTO> cityDTOS) {
        return null;
    }

    @Override
    public CityEntity requestDTOToEntity(CityRequestDTO dto) {
        return null;
    }

    @Override
    public List<CityEntity> requestDtoListTOEntityList(List<CityRequestDTO> cityRequestDTOS) {
        return null;
    }

    @Override
    public CityEntity requestDtoToExistEntity(CityEntity entity, CityRequestDTO cityRequestDTO) {
        return null;
    }

    @Override
    public CityEntity dtoToExistEntity(CityEntity entity, CityDTO dto) {
        return null;
    }

    @Override
    public PageDTO<CityDTO> pageEntityToPageDTO(Page<CityEntity> cityEntities) {
        return null;
    }
}
