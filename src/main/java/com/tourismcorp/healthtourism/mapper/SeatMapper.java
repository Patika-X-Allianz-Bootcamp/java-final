package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.SeatEntity;
import com.tourismcorp.healthtourism.model.SeatDTO;
import com.tourismcorp.healthtourism.model.requestDTO.SeatRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatMapper implements IBaseMapper<SeatEntity, SeatDTO, SeatRequestDTO> {

    private final FlightMapper flightMapper;

    @Autowired
    public SeatMapper(@Lazy FlightMapper flightMapper) {
        this.flightMapper = flightMapper;
    }

    @Override
    public SeatDTO entityToDTO(SeatEntity entity) {
        SeatDTO seatDTO = new SeatDTO();
        if (entity == null)
            return seatDTO;
        seatDTO.setUuid(entity.getUuid());
        seatDTO.setCreationDate(entity.getCreationDate());
        seatDTO.setUpdatedDate(entity.getUpdatedDate());
        seatDTO.setId(entity.getId());
        seatDTO.setSeatNumber(entity.getSeatNumber());

        return seatDTO;
    }

    @Override
    public SeatEntity dtoToEntity(SeatDTO dto) {
        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setUuid(dto.getUuid());
        seatEntity.setCreationDate(dto.getCreationDate());
        seatEntity.setUpdatedDate(dto.getUpdatedDate());
        seatEntity.setId(dto.getId());
        seatEntity.setSeatNumber(dto.getSeatNumber());

        return seatEntity;
    }

    @Override
    public List<SeatDTO> entityListToDTOList(List<SeatEntity> entityList) {
        List<SeatDTO> seatDTOList = new ArrayList<>();
        for (SeatEntity entity : entityList) {
            SeatDTO dto = entityToDTO(entity);
            seatDTOList.add(dto);
        }
        return seatDTOList;
    }

    @Override
    public List<SeatEntity> dtoListToEntityList(List<SeatDTO> dtoList) {
        List<SeatEntity> seatEntityList = new ArrayList<>();
        for (SeatDTO dto : dtoList) {
            SeatEntity entity = dtoToEntity(dto);
            seatEntityList.add(entity);
        }
        return seatEntityList;
    }

    @Override
    public SeatEntity requestDTOToEntity(SeatRequestDTO requestDTO) {
        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setUuid(requestDTO.getUuid());
        seatEntity.setCreationDate(requestDTO.getCreationDate());
        seatEntity.setUpdatedDate(requestDTO.getUpdatedDate());
        seatEntity.setId(requestDTO.getId());
        seatEntity.setSeatNumber(requestDTO.getSeatNumber());

        return seatEntity;
    }

    @Override
    public List<SeatEntity> requestDTOListToEntityList(List<SeatRequestDTO> dtoList) {
        List<SeatEntity> seatEntityList = new ArrayList<>();
        if (dtoList == null)
            return seatEntityList;
        for (SeatRequestDTO dto : dtoList) {
            SeatEntity entity = requestDTOToEntity(dto);
            seatEntityList.add(entity);
        }
        return seatEntityList;
    }

    @Override
    public SeatEntity requestDTOToExistEntity(SeatRequestDTO requestDTO, SeatEntity entity) {
        if (requestDTO.getSeatNumber() != 0)
            entity.setSeatNumber(requestDTO.getSeatNumber());

        return entity;

    }

    @Override
    public Page<SeatDTO> pageEntityToPageDTO(Page<SeatEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
