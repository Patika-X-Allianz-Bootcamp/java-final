package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.model.DTO.HotelDTO;
import com.allianz.healthtourism.model.DTO.PageDTO;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelMapper implements IBaseMapper<HotelDTO, HotelEntity, HotelRequestDTO> {

    private final RoomMapper roomMapper;

    private final PatientMapper patientMapper;

    private final CityMapper cityMapper;

    public HotelMapper(RoomMapper roomMapper, PatientMapper patientMapper, CityMapper cityMapper) {
        this.roomMapper = roomMapper;
        this.patientMapper = patientMapper;
        this.cityMapper = cityMapper;
    }

    @Override
    public HotelDTO entityToDTO(HotelEntity entity) {
        HotelDTO dto = new HotelDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setCity(cityMapper.entityToDTO(entity.getCity()));
        dto.setRooms(roomMapper.entityListToDTOList(entity.getRooms()));
        dto.setPatientList(patientMapper.entityListToDTOList(entity.getPatientList()));
        return dto;
    }

    @Override
    public HotelEntity dtoToEntity(HotelDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCity(cityMapper.dtoToEntity(dto.getCity()));
        entity.setName(dto.getName());
        entity.setRooms(roomMapper.dtoListTOEntityList(dto.getRooms()));

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
    public List<HotelEntity> dtoListTOEntityList(List<HotelDTO> dtoList) {
        List<HotelEntity> entities = new ArrayList<>();

        for (HotelDTO dto: dtoList){
            entities.add(dtoToEntity(dto));
        }

        return entities;
    }

    @Override
    public HotelEntity requestDTOToEntity(HotelRequestDTO dto) {
        return null;
    }

    @Override
    public List<HotelEntity> requestDtoListTOEntityList(List<HotelRequestDTO> hotelRequestDTOS) {
        return null;
    }

    @Override
    public HotelEntity requestDtoToExistEntity(HotelEntity entity, HotelRequestDTO hotelRequestDTO) {
        return null;
    }

    @Override
    public HotelEntity dtoToExistEntity(HotelEntity entity, HotelDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCity(cityMapper.dtoToEntity(dto.getCity()));
        entity.setName(dto.getName());
        entity.setRooms(roomMapper.dtoListTOEntityList(dto.getRooms()));
        entity.setPatientList(patientMapper.dtoListTOEntityList(dto.getPatientList()));

        return entity;
    }

    @Override
    public PageDTO<HotelDTO> pageEntityToPageDTO(Page<HotelEntity> hotelEntities) {
        return null;
    }
}
