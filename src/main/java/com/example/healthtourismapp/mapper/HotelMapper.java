package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.HotelEntity;
import com.example.healthtourismapp.model.HotelDTO;
import com.example.healthtourismapp.model.requestDTO.HotelRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class HotelMapper implements IBaseMapper<HotelEntity, HotelDTO, HotelRequestDTO> {

    private final HotelRoomMapper hotelRoomMapper;

    public HotelMapper(HotelRoomMapper hotelRoomMapper) {
        this.hotelRoomMapper = hotelRoomMapper;
    }

    @Override
    public HotelDTO entityToDTO(HotelEntity entity) {

        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setHotelRoomList(hotelRoomMapper.entityListToDTOList(entity.getHotelRoomList()));
        hotelDTO.setName(entity.getName());
        hotelDTO.setId(entity.getId());
        hotelDTO.setNumberOfStars(entity.getNumberOfStars());
        hotelDTO.setCreationDate(entity.getCreationDate());
        hotelDTO.setUpdatedDate(entity.getUpdatedDate());
        hotelDTO.setUuid(entity.getUuid());

        return hotelDTO;
    }

    @Override
    public HotelEntity dtoToEntity(HotelDTO dto) {

        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setHotelRoomList(hotelRoomMapper.dtoListToEntityList(dto.getHotelRoomList()));
        hotelEntity.setName(dto.getName());
        hotelEntity.setId(dto.getId());
        hotelEntity.setNumberOfStars(dto.getNumberOfStars());
        hotelEntity.setCreationDate(dto.getCreationDate());
        hotelEntity.setUpdatedDate(dto.getUpdatedDate());
        hotelEntity.setUuid(dto.getUuid());

        return hotelEntity;
    }

    @Override
    public List<HotelDTO> entityListToDTOList(List<HotelEntity> hotelEntities) {

        List<HotelDTO> hotelDTOS = new ArrayList<>();
        for (HotelEntity entity : hotelEntities) {
            hotelDTOS.add(entityToDTO(entity));
        }
        return hotelDTOS;
    }

    @Override
    public List<HotelEntity> dtoListToEntityList(List<HotelDTO> hotelDTOS) {

        List<HotelEntity> hotelEntities = new ArrayList<>();
        for (HotelDTO dto : hotelDTOS) {
            hotelEntities.add(dtoToEntity(dto));
        }
        return hotelEntities;
    }

    @Override
    public HotelEntity requestDTOToEntity(HotelRequestDTO hotelRequestDTO) {

        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setHotelRoomList(hotelRoomMapper.dtoListToEntityList(hotelRequestDTO.getHotelRoomList()));
        hotelEntity.setName(hotelRequestDTO.getName());
        hotelEntity.setId(hotelRequestDTO.getId());
        hotelEntity.setNumberOfStars(hotelRequestDTO.getNumberOfStars());
        hotelEntity.setCreationDate(hotelRequestDTO.getCreationDate());
        hotelEntity.setUpdatedDate(hotelRequestDTO.getUpdatedDate());
        hotelEntity.setUuid(hotelRequestDTO.getUuid());

        return hotelEntity;
    }

    @Override
    public List<HotelEntity> requestDTOListToEntityList(List<HotelRequestDTO> hotelRequestDTOS) {

        List<HotelEntity> hotelEntities = new ArrayList<>();
        for (HotelRequestDTO dto : hotelRequestDTOS) {
            hotelEntities.add(requestDTOToEntity(dto));
        }
        return hotelEntities;
    }

    @Override
    public HotelEntity requestDTOToExistEntity(HotelRequestDTO hotelRequestDTO, HotelEntity entity) {

        entity.setHotelRoomList(hotelRoomMapper.dtoListToEntityList(hotelRequestDTO.getHotelRoomList()));
        entity.setName(hotelRequestDTO.getName());
        entity.setNumberOfStars(hotelRequestDTO.getNumberOfStars());

        return entity;
    }

    @Override
    public Page<HotelDTO> pageEntityToPageDTO(Page<HotelEntity> hotelEntities) {
        return hotelEntities.map(this::entityToDTO);
    }
}
