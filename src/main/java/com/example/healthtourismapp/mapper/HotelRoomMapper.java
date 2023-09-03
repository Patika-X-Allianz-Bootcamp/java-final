package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.HotelRoomEntity;
import com.example.healthtourismapp.model.HotelRoomDTO;
import com.example.healthtourismapp.model.requestDTO.HotelRoomRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class HotelRoomMapper implements IBaseMapper<HotelRoomEntity, HotelRoomDTO, HotelRoomRequestDTO> {
    @Override
    public HotelRoomDTO entityToDTO(HotelRoomEntity entity) {

        HotelRoomDTO hotelRoomDTO = new HotelRoomDTO();
        hotelRoomDTO.setRoomNumber(entity.getRoomNumber());
        hotelRoomDTO.setRoomType(entity.getRoomType());
        hotelRoomDTO.setUuid(entity.getUuid());
        hotelRoomDTO.setId(entity.getId());
        hotelRoomDTO.setUpdatedDate(entity.getUpdatedDate());
        hotelRoomDTO.setCreationDate(entity.getCreationDate());

        return hotelRoomDTO;
    }

    @Override
    public HotelRoomEntity dtoToEntity(HotelRoomDTO dto) {

        HotelRoomEntity hotelRoomEntity = new HotelRoomEntity();
        hotelRoomEntity.setRoomNumber(dto.getRoomNumber());
        hotelRoomEntity.setRoomType(dto.getRoomType());
        hotelRoomEntity.setUuid(dto.getUuid());
        hotelRoomEntity.setUpdatedDate(dto.getUpdatedDate());
        hotelRoomEntity.setCreationDate(dto.getCreationDate());
        hotelRoomEntity.setId(dto.getId());

        return hotelRoomEntity;
    }

    @Override
    public List<HotelRoomDTO> entityListToDTOList(List<HotelRoomEntity> hotelRoomEntities) {

        List<HotelRoomDTO> hotelRoomDTOS = new ArrayList<>();
        for (HotelRoomEntity entity : hotelRoomEntities) {
            hotelRoomDTOS.add(entityToDTO(entity));
        }
        return hotelRoomDTOS;
    }

    @Override
    public List<HotelRoomEntity> dtoListToEntityList(List<HotelRoomDTO> hotelRoomDTOS) {

        List<HotelRoomEntity> hotelRoomEntities = new ArrayList<>();
        for (HotelRoomDTO dto : hotelRoomDTOS) {
            hotelRoomEntities.add(dtoToEntity(dto));
        }
        return hotelRoomEntities;
    }

    @Override
    public HotelRoomEntity requestDTOToEntity(HotelRoomRequestDTO hotelRoomRequestDTO) {

        HotelRoomEntity hotelRoomEntity = new HotelRoomEntity();
        hotelRoomEntity.setRoomNumber(hotelRoomRequestDTO.getRoomNumber());
        hotelRoomEntity.setRoomType(hotelRoomRequestDTO.getRoomType());
        hotelRoomEntity.setUuid(hotelRoomRequestDTO.getUuid());
        hotelRoomEntity.setUpdatedDate(hotelRoomRequestDTO.getUpdatedDate());
        hotelRoomEntity.setCreationDate(hotelRoomRequestDTO.getCreationDate());
        hotelRoomEntity.setId(hotelRoomRequestDTO.getId());

        return hotelRoomEntity;
    }

    @Override
    public List<HotelRoomEntity> requestDTOListToEntityList(List<HotelRoomRequestDTO> hotelRoomRequestDTOS) {

        List<HotelRoomEntity> hotelRoomEntities = new ArrayList<>();
        for (HotelRoomRequestDTO requestDTO : hotelRoomRequestDTOS) {
            hotelRoomEntities.add(requestDTOToEntity(requestDTO));
        }
        return hotelRoomEntities;
    }

    @Override
    public HotelRoomEntity requestDTOToExistEntity(HotelRoomRequestDTO hotelRoomRequestDTO, HotelRoomEntity entity) {

        entity.setRoomNumber(hotelRoomRequestDTO.getRoomNumber());
        entity.setRoomType(hotelRoomRequestDTO.getRoomType());

        return entity;
    }

    @Override
    public Page<HotelRoomDTO> pageEntityToPageDTO(Page<HotelRoomEntity> hotelRoomEntities) {
        return hotelRoomEntities.map(this::entityToDTO);
    }
}
