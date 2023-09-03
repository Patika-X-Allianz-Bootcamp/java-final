package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.AppointmentEntity;
import com.example.healthtourismapp.model.AppointmentDTO;
import com.example.healthtourismapp.model.requestDTO.AppointmentRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapper implements IBaseMapper<AppointmentEntity, AppointmentDTO, AppointmentRequestDTO> {

    private final PatientMapper patientMapper;

    private final HotelMapper hotelMapper;

    private final FlightMapper flightMapper;

    private final HospitalMapper hospitalMapper;

    @Autowired
    @Lazy
    public AppointmentMapper(PatientMapper patientMapper, HotelMapper hotelMapper, FlightMapper flightMapper, HospitalMapper hospitalMapper) {
        this.patientMapper = patientMapper;
        this.hotelMapper = hotelMapper;
        this.flightMapper = flightMapper;
        this.hospitalMapper = hospitalMapper;
    }


    @Override
    public AppointmentDTO entityToDTO(AppointmentEntity entity) {

        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setUuid(entity.getUuid());
        appointmentDTO.setDate(entity.getDate());
        appointmentDTO.setHotel(hotelMapper.entityToDTO(entity.getHotel()));
        appointmentDTO.setPatient(patientMapper.entityToDTO(entity.getPatient()));
        appointmentDTO.setFlight(flightMapper.entityToDTO(entity.getFlight()));
        appointmentDTO.setHospital(hospitalMapper.entityToDTO(entity.getHospital()));
        appointmentDTO.setTotalBill(entity.getTotalBill());
        appointmentDTO.setCreationDate(entity.getCreationDate());
        appointmentDTO.setUpdatedDate(entity.getUpdatedDate());
        appointmentDTO.setId(entity.getId());

        return appointmentDTO;
    }

    @Override
    public AppointmentEntity dtoToEntity(AppointmentDTO dto) {

        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setUuid(dto.getUuid());
        appointmentEntity.setDate(dto.getDate());
        appointmentEntity.setHotel(hotelMapper.dtoToEntity(dto.getHotel()));
        appointmentEntity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        appointmentEntity.setFlight(flightMapper.dtoToEntity(dto.getFlight()));
        appointmentEntity.setHospital(hospitalMapper.dtoToEntity(dto.getHospital()));
        appointmentEntity.setTotalBill(dto.getTotalBill());
        appointmentEntity.setCreationDate(dto.getCreationDate());
        appointmentEntity.setUpdatedDate(dto.getUpdatedDate());
        appointmentEntity.setId(dto.getId());

        return appointmentEntity;
    }

    @Override
    public List<AppointmentDTO> entityListToDTOList(List<AppointmentEntity> appointmentEntities) {

        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        for (AppointmentEntity entity : appointmentEntities) {
            appointmentDTOS.add(entityToDTO(entity));
        }
        return appointmentDTOS;
    }

    @Override
    public List<AppointmentEntity> dtoListToEntityList(List<AppointmentDTO> appointmentDTOS) {

        List<AppointmentEntity> appointmentEntities = new ArrayList<>();
        for (AppointmentDTO dto : appointmentDTOS) {
            appointmentEntities.add(dtoToEntity(dto));
        }
        return appointmentEntities;
    }

    @Override
    public AppointmentEntity requestDTOToEntity(AppointmentRequestDTO appointmentRequestDTO) {

        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setUuid(appointmentRequestDTO.getUuid());
        appointmentEntity.setDate(appointmentRequestDTO.getDate());
        appointmentEntity.setHotel(hotelMapper.dtoToEntity(appointmentRequestDTO.getHotel()));
        appointmentEntity.setPatient(patientMapper.dtoToEntity(appointmentRequestDTO.getPatient()));
        appointmentEntity.setFlight(flightMapper.dtoToEntity(appointmentRequestDTO.getFlight()));
        appointmentEntity.setHospital(hospitalMapper.dtoToEntity(appointmentRequestDTO.getHospital()));
        appointmentEntity.setTotalBill(appointmentRequestDTO.getTotalBill());
        appointmentEntity.setCreationDate(appointmentRequestDTO.getCreationDate());
        appointmentEntity.setUpdatedDate(appointmentRequestDTO.getUpdatedDate());
        appointmentEntity.setId(appointmentRequestDTO.getId());

        return appointmentEntity;
    }

    @Override
    public List<AppointmentEntity> requestDTOListToEntityList(List<AppointmentRequestDTO> appointmentRequestDTOS) {
        List<AppointmentEntity> appointmentEntities = new ArrayList<>();
        for (AppointmentRequestDTO requestDTO : appointmentRequestDTOS) {
            appointmentEntities.add(requestDTOToEntity(requestDTO));
        }
        return appointmentEntities;
    }

    @Override
    public AppointmentEntity requestDTOToExistEntity(AppointmentRequestDTO appointmentRequestDTO, AppointmentEntity entity) {

        entity.setDate(appointmentRequestDTO.getDate());
        entity.setHotel(hotelMapper.dtoToEntity(appointmentRequestDTO.getHotel()));
        entity.setPatient(patientMapper.dtoToEntity(appointmentRequestDTO.getPatient()));
        entity.setFlight(flightMapper.dtoToEntity(appointmentRequestDTO.getFlight()));
        entity.setHospital(hospitalMapper.dtoToEntity(appointmentRequestDTO.getHospital()));
        entity.setTotalBill(appointmentRequestDTO.getTotalBill());

        return entity;
    }

    @Override
    public Page<AppointmentDTO> pageEntityToPageDTO(Page<AppointmentEntity> appointmentEntities) {
        return appointmentEntities.map(this::entityToDTO);
    }
}
