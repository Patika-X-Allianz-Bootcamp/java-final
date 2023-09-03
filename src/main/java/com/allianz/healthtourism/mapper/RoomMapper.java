package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.RoomEntity;
import com.allianz.healthtourism.model.DTO.PageDTO;
import com.allianz.healthtourism.model.DTO.RoomDTO;
import com.allianz.healthtourism.model.requestDTO.RoomRequestDTO;

import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapper implements IBaseMapper<RoomDTO, RoomEntity, RoomRequestDTO> {

    private final HotelMapper hotelMapper;

    public RoomMapper(HotelMapper hotelMapper) {
        this.hotelMapper = hotelMapper;
    }

    @Override
    public RoomDTO entityToDTO(RoomEntity entity) {
        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setCapacity(entity.getCapacity());
        dto.setCheckInDate(entity.getCheckInDate());
        dto.setCheckOutDate(entity.getCheckOutDate());
        dto.setHotel(hotelMapper.entityToDTO(entity.getHotel()));
        return dto;
    }
    @Override
    public RoomEntity dtoToEntity(RoomDTO dto){
        RoomEntity entity = new RoomEntity();
        entity.setId(dto.getId());
        entity.setCapacity(dto.getCapacity());
        entity.setCheckInDate(dto.getCheckInDate());
        entity.setCheckOutDate(dto.getCheckOutDate());
        entity.setHotel(hotelMapper.dtoToEntity(dto.getHotel()));

        return entity;
    }

    @Override
    public List<RoomDTO> entityListToDTOList(List<RoomEntity> entityList) {
        List<RoomDTO> dtoList = new ArrayList<>();

        for (RoomEntity entity: entityList){
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<RoomEntity> dtoListTOEntityList(List<RoomDTO> dtoList) {

        List<RoomEntity> entityList = new ArrayList<>();

        for (RoomDTO dto: dtoList){
            entityList.add(dtoToEntity(dto));
        }

        return entityList;
    }

    @Override
    public RoomEntity requestDTOToEntity(RoomRequestDTO dto) {
        return null;
    }

    @Override
    public List<RoomEntity> requestDtoListTOEntityList(List<RoomRequestDTO> roomRequestDTOS) {
        return null;
    }

    @Override
    public RoomEntity requestDtoToExistEntity(RoomEntity entity, RoomRequestDTO roomRequestDTO) {
        return null;
    }

    @Override
    public RoomEntity dtoToExistEntity(RoomEntity entity, RoomDTO dto) {
        entity.setId(dto.getId());
        entity.setCapacity(dto.getCapacity());
        entity.setCheckInDate(dto.getCheckInDate());
        entity.setCheckOutDate(dto.getCheckOutDate());
        entity.setHotel(hotelMapper.dtoToEntity(dto.getHotel()));

        return entity;
    }

    @Override
    public PageDTO<RoomDTO> pageEntityToPageDTO(Page<RoomEntity> roomEntities) {
        return null;
    }

}