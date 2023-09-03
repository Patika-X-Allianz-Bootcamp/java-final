package com.allianz.HealthTourismSpringBoot.mapper;

import com.allianz.HealthTourismSpringBoot.database.entities.HotelEntity;
import com.allianz.HealthTourismSpringBoot.model.HotelDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.HotelRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelMapper implements IBaseMapper<HotelEntity, HotelDTO, HotelRequestDTO> {

    @Autowired
    @Lazy
    AgencyMapper agencyMapper;

    @Override
    public HotelDTO entityToDTO(HotelEntity entity) {

        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setUuid(entity.getUuid());
        hotelDTO.setId(entity.getId());
        hotelDTO.setCreationDate(entity.getCreationDate());
        hotelDTO.setUpdatedDate(entity.getUpdatedDate());
        hotelDTO.setName(entity.getName());
        hotelDTO.setTotalRooms(entity.getTotalRooms());
        hotelDTO.setAvailableRooms(entity.getAvailableRooms());
        hotelDTO.setAgency(agencyMapper.entityToDTO(entity.getAgency()));

        return hotelDTO;
    }

    @Override
    public HotelEntity dtoToEntity(HotelDTO dto) {

        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setUuid(dto.getUuid());
        hotelEntity.setId(dto.getId());
        hotelEntity.setCreationDate(dto.getCreationDate());
        hotelEntity.setUpdatedDate(dto.getUpdatedDate());
        hotelEntity.setName(dto.getName());
        hotelEntity.setTotalRooms(dto.getTotalRooms());
        hotelEntity.setAvailableRooms(dto.getAvailableRooms());
        hotelEntity.setAgency(agencyMapper.dtoToEntity(dto.getAgency()));

        return hotelEntity;
    }

    @Override
    public List<HotelDTO> entityListToDTOList(List<HotelEntity> hotelEntities) {

        List<HotelDTO> hotelDTOList = new ArrayList<>();
        for (HotelEntity entity : hotelEntities){
            hotelDTOList.add(entityToDTO(entity));
        }
        return hotelDTOList;
    }

    @Override
    public List<HotelEntity> dtoListToEntityList(List<HotelDTO> hotelDTOS) {

        List<HotelEntity> hotelEntityList = new ArrayList<>();
        for (HotelDTO dto : hotelDTOS){
            hotelEntityList.add(dtoToEntity(dto));
        }
        return hotelEntityList;
    }

    @Override
    public HotelEntity requestDTOToEntity(HotelRequestDTO hotelRequestDTO) {

        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setUuid(hotelRequestDTO.getUuid());
        hotelEntity.setId(hotelRequestDTO.getId());
        hotelEntity.setCreationDate(hotelRequestDTO.getCreationDate());
        hotelEntity.setUpdatedDate(hotelRequestDTO.getUpdatedDate());
        hotelEntity.setName(hotelRequestDTO.getName());
        hotelEntity.setTotalRooms(hotelRequestDTO.getTotalRooms());
        hotelEntity.setAvailableRooms(hotelRequestDTO.getAvailableRooms());
        hotelEntity.setAgency(agencyMapper.requestDTOToEntity(hotelRequestDTO.getAgency()));

        return hotelEntity;
    }

    @Override
    public List<HotelEntity> requestDTOListToEntityList(List<HotelRequestDTO> hotelRequestDTOS) {

        List<HotelEntity> hotelEntityList = new ArrayList<>();
        for (HotelRequestDTO requestDTO : hotelRequestDTOS){
            hotelEntityList.add(requestDTOToEntity(requestDTO));
        }
        return hotelEntityList;
    }

    @Override
    public HotelEntity requestDTOToExistEntity(HotelRequestDTO hotelRequestDTO, HotelEntity entity) {

        entity.setName(hotelRequestDTO.getName());
        entity.setTotalRooms(hotelRequestDTO.getTotalRooms());
        entity.setAvailableRooms(hotelRequestDTO.getAvailableRooms());
        entity.setAgency(agencyMapper.requestDTOToEntity(hotelRequestDTO.getAgency()));

        return entity;
    }

    @Override
    public Page<HotelDTO> pageEntityToPageDTO(Page<HotelEntity> hotelEntities) {
        return hotelEntities.map(this::entityToDTO);
    }
}
