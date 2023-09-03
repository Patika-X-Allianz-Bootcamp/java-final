package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.AppointmentEntity;
import com.tourismcorp.healthtourism.model.AppointmentDTO;
import com.tourismcorp.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapper implements IBaseMapper<AppointmentEntity, AppointmentDTO, AppointmentRequestDTO> {

    private final DoctorMapper doctorMapper;
    private final UserMapper userMapper;
    private final HospitalMapper hospitalMapper;
    private final HotelMapper hotelMapper;
    private final FlightMapper flightMapper;
    private final RoomMapper roomMapper;
    private final SeatMapper seatMapper;

    @Autowired
    protected AppointmentMapper(DoctorMapper doctorMapper, UserMapper userMapper,
                                HospitalMapper hospitalMapper, HotelMapper hotelMapper,
                                FlightMapper flightMapper, RoomMapper roomMapper, SeatMapper seatMapper) {
        this.doctorMapper = doctorMapper;
        this.userMapper = userMapper;
        this.hospitalMapper = hospitalMapper;
        this.hotelMapper = hotelMapper;
        this.flightMapper = flightMapper;
        this.roomMapper = roomMapper;
        this.seatMapper = seatMapper;
    }

    @Override
    public AppointmentDTO entityToDTO(AppointmentEntity entity) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setDate(entity.getDate());
        if (entity.getDoctor() == null)
            dto.setDoctor(null);
        else
            dto.setDoctor(doctorMapper.entityToDTO(entity.getDoctor()));
        if (entity.getUser() == null)
            dto.setUser(null);
        else
            dto.setUser(userMapper.entityToDTO(entity.getUser()));
        if (entity.getHospital() == null)
            dto.setHospital(null);
        else
            dto.setHospital(hospitalMapper.entityToDTO(entity.getHospital()));
        if (entity.getHotel() == null)
            dto.setHotel(null);
        else
            dto.setHotel(hotelMapper.entityToDTO(entity.getHotel()));
        if (entity.getFlight() == null)
            dto.setFlight(null);
        else
            dto.setFlight(flightMapper.entityToDTO(entity.getFlight()));
        if (entity.getRoom() == null)
            dto.setRoom(null);
        else
            dto.setRoom(roomMapper.entityToDTO(entity.getRoom()));
        if (entity.getSeat() == null)
            dto.setSeat(null);
        else
            dto.setSeat(seatMapper.entityToDTO(entity.getSeat()));

        return dto;
    }

    @Override
    public AppointmentEntity dtoToEntity(AppointmentDTO dto) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setDate(dto.getDate());
        if (dto.getDoctor() == null)
            entity.setDoctor(null);
        else
            entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        if (dto.getUser() == null)
            entity.setUser(null);
        else
            entity.setUser(userMapper.dtoToEntity(dto.getUser()));
        if (dto.getHospital() == null)
            entity.setHospital(null);
        else
            entity.setHospital(hospitalMapper.dtoToEntity(dto.getHospital()));
        if (dto.getHotel() == null)
            entity.setHotel(null);
        else
            entity.setHotel(hotelMapper.dtoToEntity(dto.getHotel()));
        if (dto.getFlight() == null)
            entity.setFlight(null);
        else
            entity.setFlight(flightMapper.dtoToEntity(dto.getFlight()));
        if (dto.getRoom() == null)
            entity.setRoom(null);
        else
            entity.setRoom(roomMapper.dtoToEntity(dto.getRoom()));
        if (dto.getSeat() == null)
            entity.setSeat(null);
        else
            entity.setSeat(seatMapper.dtoToEntity(dto.getSeat()));

        return entity;
    }

    @Override
    public List<AppointmentDTO> entityListToDTOList(List<AppointmentEntity> entityList) {
        List<AppointmentDTO> dtoList = new ArrayList<>();
        for (AppointmentEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<AppointmentEntity> dtoListToEntityList(List<AppointmentDTO> dtoList) {
        List<AppointmentEntity> entityList = new ArrayList<>();
        for (AppointmentDTO dto : dtoList) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public AppointmentEntity requestDTOToEntity(AppointmentRequestDTO requestDTO) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(requestDTO.getId());
        entity.setUuid(requestDTO.getUuid());
        entity.setCreationDate(requestDTO.getCreationDate());
        entity.setUpdatedDate(requestDTO.getUpdatedDate());
        entity.setDate(requestDTO.getDate());
        if (requestDTO.getDoctor() == null)
            entity.setDoctor(null);
        else
            entity.setDoctor(doctorMapper.requestDTOToEntity(requestDTO.getDoctor()));
        if (requestDTO.getUser() == null)
            entity.setUser(null);
        else
            entity.setUser(userMapper.requestDTOToEntity(requestDTO.getUser()));
        if (requestDTO.getHospital() == null)
            entity.setHospital(null);
        else
            entity.setHospital(hospitalMapper.requestDTOToEntity(requestDTO.getHospital()));
        if (requestDTO.getHotel() == null)
            entity.setHotel(null);
        else
            entity.setHotel(hotelMapper.requestDTOToEntity(requestDTO.getHotel()));
        if (requestDTO.getFlight() == null)
            entity.setFlight(null);
        else
            entity.setFlight(flightMapper.requestDTOToEntity(requestDTO.getFlight()));
        if (requestDTO.getRoom() == null)
            entity.setRoom(null);
        else
            entity.setRoom(roomMapper.requestDTOToEntity(requestDTO.getRoom()));
        if (requestDTO.getSeat() == null)
            entity.setSeat(null);
        else
            entity.setSeat(seatMapper.requestDTOToEntity(requestDTO.getSeat()));


        return entity;
    }

    @Override
    public List<AppointmentEntity> requestDTOListToEntityList(List<AppointmentRequestDTO> dtoList) {
        List<AppointmentEntity> entityList = new ArrayList<>();
        for (AppointmentRequestDTO dto : dtoList) {
            entityList.add(requestDTOToEntity(dto));
        }
        return entityList;
    }

    @Override
    public AppointmentEntity requestDTOToExistEntity(AppointmentRequestDTO requestDTO, AppointmentEntity entity) {
        if (requestDTO.getDate() != null)
            entity.setDate(requestDTO.getDate());
        if (requestDTO.getDoctor() != null)
            entity.setDoctor(doctorMapper.requestDTOToEntity(requestDTO.getDoctor()));
        if (requestDTO.getUser() != null)
            entity.setUser(userMapper.requestDTOToEntity(requestDTO.getUser()));
        if (requestDTO.getHospital() != null)
            entity.setHospital(hospitalMapper.requestDTOToEntity(requestDTO.getHospital()));
        if (requestDTO.getHotel() != null)
            entity.setHotel(hotelMapper.requestDTOToEntity(requestDTO.getHotel()));
        if (requestDTO.getFlight() != null)
            entity.setFlight(flightMapper.requestDTOToEntity(requestDTO.getFlight()));
        if (requestDTO.getRoom() != null)
            entity.setRoom(roomMapper.requestDTOToEntity(requestDTO.getRoom()));
        if (requestDTO.getSeat() != null)
            entity.setSeat(seatMapper.requestDTOToEntity(requestDTO.getSeat()));


        return entity;
    }

    @Override
    public Page<AppointmentDTO> pageEntityToPageDTO(Page<AppointmentEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
