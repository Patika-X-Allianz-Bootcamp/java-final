package com.healthtourism.healthtourism.mapper;

import com.healthtourism.healthtourism.database.entities.HotelInfoEntity;
import com.healthtourism.healthtourism.model.HotelInfoDTO;
import com.healthtourism.healthtourism.model.RequestDTO.HoteInfoRequestDTO;
import com.healthtourism.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelInfoMapper implements IBaseMapper<HotelInfoEntity, HotelInfoDTO, HoteInfoRequestDTO> {

    @Autowired
    PatientMapper patientMapper;

    public HotelInfoMapper(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    @Override
    public HotelInfoDTO entityToDTO(HotelInfoEntity entity) {
        HotelInfoDTO dto = new HotelInfoDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setHotelName(entity.getHotelName());
        dto.setCity(entity.getCity());
        dto.setReservationStatus(entity.getReservationStatus());
        dto.setPatient(patientMapper.entityToDTO(entity.getPatient()));


        return dto;
    }

    @Override
    public HotelInfoEntity dtoToEntity(HotelInfoDTO dto) {
        HotelInfoEntity entity = new HotelInfoEntity();
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setHotelName(dto.getHotelName());
        entity.setCity(dto.getCity());
        entity.setReservationStatus(dto.getReservationStatus());

        entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));

        return entity;
    }

    @Override
    public List<HotelInfoDTO> entityListToDTOList(List<HotelInfoEntity> entityList) {
        List<HotelInfoDTO> dtoList = new ArrayList<>();
        for (HotelInfoEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<HotelInfoEntity> dtoListToEntityList(List<HotelInfoDTO> dtoList) {
        List<HotelInfoEntity> entityList = new ArrayList<>();
        for (HotelInfoDTO dto : dtoList) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public HotelInfoEntity requestDTOToEntity(HoteInfoRequestDTO hotelInfoRequestDTO) {
        HotelInfoEntity hotelInfoEntity = new HotelInfoEntity();
        hotelInfoEntity.setCity(hotelInfoRequestDTO.getCity());
        hotelInfoEntity.setHotelName(hotelInfoRequestDTO.getHotelName());
        hotelInfoEntity.setReservationStatus(hotelInfoRequestDTO.getReservationStatus());
        hotelInfoEntity.setId(hotelInfoRequestDTO.getId());
        hotelInfoEntity.setCreationDate(hotelInfoRequestDTO.getCreationDate());
        hotelInfoEntity.setUuid(hotelInfoRequestDTO.getUuid());
        hotelInfoEntity.setPatient(patientMapper.dtoToEntity(hotelInfoRequestDTO.getPatient()));
        return hotelInfoEntity;
    }

    @Override
    public List<HotelInfoEntity> requestDTOListToEntityList(List<HoteInfoRequestDTO> hotelInfoRequestDTOS) {
        List<HotelInfoEntity> hotelInfoEntities = new ArrayList<>();
        for (HoteInfoRequestDTO hotelInfoRequestDTO : hotelInfoRequestDTOS)
            hotelInfoEntities.add(requestDTOToEntity(hotelInfoRequestDTO));
        return hotelInfoEntities;
    }

    @Override
    public HotelInfoEntity requestDTOToExistEntity(HoteInfoRequestDTO hotelInfoRequestDTO, HotelInfoEntity hotelInfoEntity) {
        hotelInfoEntity.setHotelName(hotelInfoRequestDTO.getHotelName());
        hotelInfoEntity.setCity(hotelInfoRequestDTO.getCity());
        hotelInfoEntity.setReservationStatus(hotelInfoRequestDTO.getReservationStatus());
        hotelInfoEntity.setPatient(patientMapper.dtoToEntity(hotelInfoRequestDTO.getPatient()));


        return hotelInfoEntity;
    }
}
