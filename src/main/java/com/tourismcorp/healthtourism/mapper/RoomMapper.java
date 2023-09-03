package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.RoomEntity;
import com.tourismcorp.healthtourism.model.RoomDTO;
import com.tourismcorp.healthtourism.model.requestDTO.RoomRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapper implements IBaseMapper<RoomEntity, RoomDTO, RoomRequestDTO> {

    private final HotelMapper hotelMapper;

    @Autowired
    protected RoomMapper(@Lazy HotelMapper hotelMapper) {
        this.hotelMapper = hotelMapper;
    }

    @Override
    public RoomDTO entityToDTO(RoomEntity entity) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setUuid(entity.getUuid());
        roomDTO.setCreationDate(entity.getCreationDate());
        roomDTO.setUpdatedDate(entity.getUpdatedDate());
        roomDTO.setId(entity.getId());
        roomDTO.setRoomNumber(entity.getRoomNumber());
        roomDTO.setReservationDate(entity.getReservationDate());
        roomDTO.setPrice(entity.getPrice());
        roomDTO.setIsReserved(entity.getIsReserved());

        return roomDTO;
    }

    @Override
    public RoomEntity dtoToEntity(RoomDTO dto) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setUuid(dto.getUuid());
        roomEntity.setCreationDate(dto.getCreationDate());
        roomEntity.setUpdatedDate(dto.getUpdatedDate());
        roomEntity.setId(dto.getId());
        roomEntity.setRoomNumber(dto.getRoomNumber());
        roomEntity.setReservationDate(dto.getReservationDate());
        roomEntity.setPrice(dto.getPrice());
        roomEntity.setIsReserved(dto.getIsReserved());

        return roomEntity;
    }

    @Override
    public List<RoomDTO> entityListToDTOList(List<RoomEntity> entityList) {
        List<RoomDTO> roomDTOList = new ArrayList<>();
        for (RoomEntity entity : entityList) {
            RoomDTO dto = entityToDTO(entity);
            roomDTOList.add(dto);
        }
        return roomDTOList;
    }

    @Override
    public List<RoomEntity> dtoListToEntityList(List<RoomDTO> dtoList) {
        List<RoomEntity> roomEntityList = new ArrayList<>();
        for (RoomDTO dto : dtoList) {
            RoomEntity entity = dtoToEntity(dto);
            roomEntityList.add(entity);
        }
        return roomEntityList;
    }

    @Override
    public RoomEntity requestDTOToEntity(RoomRequestDTO requestDTO) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setUuid(requestDTO.getUuid());
        roomEntity.setCreationDate(requestDTO.getCreationDate());
        roomEntity.setUpdatedDate(requestDTO.getUpdatedDate());
        roomEntity.setId(requestDTO.getId());
        roomEntity.setRoomNumber(requestDTO.getRoomNumber());
        roomEntity.setReservationDate(requestDTO.getReservationDate());
        roomEntity.setPrice(requestDTO.getPrice());
        roomEntity.setIsReserved(requestDTO.getIsReserved());

        return roomEntity;
    }

    @Override
    public List<RoomEntity> requestDTOListToEntityList(List<RoomRequestDTO> dtoList) {
        List<RoomEntity> roomEntityList = new ArrayList<>();
        if (dtoList == null)
            return roomEntityList;
        for (RoomRequestDTO dto : dtoList) {
            RoomEntity entity = requestDTOToEntity(dto);
            roomEntityList.add(entity);
        }
        return roomEntityList;
    }

    @Override
    public RoomEntity requestDTOToExistEntity(RoomRequestDTO requestDTO, RoomEntity entity) {
        if(requestDTO.getRoomNumber() != null)
            entity.setRoomNumber(requestDTO.getRoomNumber());
        if(requestDTO.getReservationDate() != null)
            entity.setReservationDate(requestDTO.getReservationDate());
        if(requestDTO.getPrice() != null)
            entity.setPrice(requestDTO.getPrice());
        if(requestDTO.getIsReserved() != null)
            entity.setIsReserved(requestDTO.getIsReserved());
        return entity;

    }

    @Override
    public Page<RoomDTO> pageEntityToPageDTO(Page<RoomEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
