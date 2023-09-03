package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.HotelEntity;
import com.tourismcorp.healthtourism.model.HotelDTO;
import com.tourismcorp.healthtourism.model.requestDTO.HotelRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelMapper implements IBaseMapper<HotelEntity, HotelDTO, HotelRequestDTO> {

    private final RoomMapper roomMapper;
    private final BankAccountMapper bankAccountMapper;

    @Autowired
    protected HotelMapper(@Lazy RoomMapper roomMapper, BankAccountMapper bankAccountMapper) {
        this.roomMapper = roomMapper;
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public HotelDTO entityToDTO(HotelEntity entity) {
        HotelDTO dto = new HotelDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setHotelName(entity.getHotelName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        dto.setRoom(roomMapper.entityListToDTOList(entity.getRoom()));
        if (entity.getBankAccount() == null)
            dto.setBankAccount(null);
        else
            dto.setBankAccount(bankAccountMapper.entityToDTO(entity.getBankAccount()));

        return dto;
    }

    @Override
    public HotelEntity dtoToEntity(HotelDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setHotelName(dto.getHotelName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setRoom(roomMapper.dtoListToEntityList(dto.getRoom()));
        if (dto.getBankAccount() == null)
            entity.setBankAccount(null);
        else
            entity.setBankAccount(bankAccountMapper.dtoToEntity(dto.getBankAccount()));

        return entity;
    }

    @Override
    public List<HotelDTO> entityListToDTOList(List<HotelEntity> entityList) {
        List<HotelDTO> dtoList = new ArrayList<>();
        for (HotelEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<HotelEntity> dtoListToEntityList(List<HotelDTO> dtoList) {
        List<HotelEntity> entityList = new ArrayList<>();
        for (HotelDTO dto : dtoList) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public HotelEntity requestDTOToEntity(HotelRequestDTO requestDTO) {
        HotelEntity entity = new HotelEntity();
        entity.setId(requestDTO.getId());
        entity.setUuid(requestDTO.getUuid());
        entity.setCreationDate(requestDTO.getCreationDate());
        entity.setUpdatedDate(requestDTO.getUpdatedDate());
        entity.setHotelName(requestDTO.getHotelName());
        entity.setPhoneNumber(requestDTO.getPhoneNumber());
        entity.setEmail(requestDTO.getEmail());
        entity.setRoom(roomMapper.requestDTOListToEntityList(requestDTO.getRoom()));
        if (requestDTO.getBankAccount() == null)
            entity.setBankAccount(null);
        else
            entity.setBankAccount(bankAccountMapper.requestDTOToEntity(requestDTO.getBankAccount()));

        return entity;
    }

    @Override
    public List<HotelEntity> requestDTOListToEntityList(List<HotelRequestDTO> dtoList) {
        List<HotelEntity> entityList = new ArrayList<>();
        for (HotelRequestDTO dto : dtoList) {
            entityList.add(requestDTOToEntity(dto));
        }
        return entityList;
    }

    @Override
    public HotelEntity requestDTOToExistEntity(HotelRequestDTO requestDTO, HotelEntity entity) {
        if (requestDTO.getHotelName() != null)
            entity.setHotelName(requestDTO.getHotelName());
        if (requestDTO.getPhoneNumber() != null)
            entity.setPhoneNumber(requestDTO.getPhoneNumber());
        if (requestDTO.getEmail() != null)
            entity.setEmail(requestDTO.getEmail());
        if (requestDTO.getRoom() != null)
            entity.setRoom(roomMapper.requestDTOListToEntityList(requestDTO.getRoom()));
        if (requestDTO.getBankAccount() != null)
            entity.setBankAccount(bankAccountMapper.requestDTOToEntity(requestDTO.getBankAccount()));

        return entity;
    }

    @Override
    public Page<HotelDTO> pageEntityToPageDTO(Page<HotelEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
