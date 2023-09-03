package com.allianz.HealthTourismSpringBoot.mapper;

import com.allianz.HealthTourismSpringBoot.database.entities.BookingEntity;
import com.allianz.HealthTourismSpringBoot.model.BookingDTO;
import com.allianz.HealthTourismSpringBoot.model.requestDTO.BookingRequestDTO;
import com.allianz.HealthTourismSpringBoot.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingMapper implements IBaseMapper<BookingEntity, BookingDTO, BookingRequestDTO> {

   @Autowired
   @Lazy
   ClientMapper clientMapper;

   @Autowired
   @Lazy
   PlaneMapper planeMapper;

   @Autowired
   @Lazy
   HotelMapper hotelMapper;


    @Override
    public BookingDTO entityToDTO(BookingEntity entity) {

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setUuid(entity.getUuid());
        bookingDTO.setId(entity.getId());
        bookingDTO.setCreationDate(entity.getCreationDate());
        bookingDTO.setUpdatedDate(entity.getUpdatedDate());
        bookingDTO.setClient(clientMapper.entityToDTO(entity.getClient()));
        bookingDTO.setPlane(planeMapper.entityToDTO(entity.getPlane()));
        bookingDTO.setPlaneSeat(entity.getPlaneSeat());
        bookingDTO.setDepartureLocation(entity.getDepartureLocation());
        bookingDTO.setArrivalLocation(entity.getArrivalLocation());
        bookingDTO.setFlightDate(entity.getFligthDate());
        bookingDTO.setHotel(hotelMapper.entityToDTO(entity.getHotel()));
        bookingDTO.setRoomNumber(entity.getRoomNumber());
        bookingDTO.setCheckingDate(entity.getCheckinDate());
        bookingDTO.setCheckoutDate(entity.getCheckoutDate());

        return bookingDTO;
    }

    @Override
    public BookingEntity dtoToEntity(BookingDTO dto) {

        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setUuid(dto.getUuid());
        bookingEntity.setId(dto.getId());
        bookingEntity.setCreationDate(dto.getCreationDate());
        bookingEntity.setUpdatedDate(dto.getUpdatedDate());
        bookingEntity.setClient(clientMapper.dtoToEntity(dto.getClient()));
        bookingEntity.setPlane(planeMapper.dtoToEntity(dto.getPlane()));
        bookingEntity.setPlaneSeat(dto.getPlaneSeat());
        bookingEntity.setDepartureLocation(dto.getDepartureLocation());
        bookingEntity.setArrivalLocation(dto.getArrivalLocation());
        bookingEntity.setFligthDate(dto.getFlightDate());
        bookingEntity.setHotel(hotelMapper.dtoToEntity(dto.getHotel()));
        bookingEntity.setRoomNumber(dto.getRoomNumber());
        bookingEntity.setCheckinDate(dto.getCheckingDate());
        bookingEntity.setCheckoutDate(dto.getCheckoutDate());

        return bookingEntity;
    }

    @Override
    public List<BookingDTO> entityListToDTOList(List<BookingEntity> bookingEntities) {

        List<BookingDTO> bookingDTOList = new ArrayList<>();
        for (BookingEntity entity : bookingEntities){
            bookingDTOList.add(entityToDTO(entity));
        }
        return bookingDTOList;
    }

    @Override
    public List<BookingEntity> dtoListToEntityList(List<BookingDTO> bookingDTOS) {

        List<BookingEntity> bookingEntityList = new ArrayList<>();
        for (BookingDTO dto : bookingDTOS){
            bookingEntityList.add(dtoToEntity(dto));
        }
        return bookingEntityList;
    }

    @Override
    public BookingEntity requestDTOToEntity(BookingRequestDTO bookingRequestDTO) {

        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setUuid(bookingRequestDTO.getUuid());
        bookingEntity.setId(bookingRequestDTO.getId());
        bookingEntity.setCreationDate(bookingRequestDTO.getCreationDate());
        bookingEntity.setUpdatedDate(bookingRequestDTO.getUpdatedDate());
        bookingEntity.setClient(clientMapper.requestDTOToEntity(bookingRequestDTO.getClient()));
        bookingEntity.setPlane(planeMapper.requestDTOToEntity(bookingRequestDTO.getPlane()));
        bookingEntity.setPlaneSeat(bookingRequestDTO.getPlaneSeat());
        bookingEntity.setDepartureLocation(bookingRequestDTO.getDepartureLocation());
        bookingEntity.setArrivalLocation(bookingRequestDTO.getArrivalLocation());
        bookingEntity.setFligthDate(bookingRequestDTO.getFlightDate());
        bookingEntity.setHotel(hotelMapper.requestDTOToEntity(bookingRequestDTO.getHotel()));
        bookingEntity.setRoomNumber(bookingRequestDTO.getRoomNumber());
        bookingEntity.setCheckinDate(bookingRequestDTO.getCheckingDate());
        bookingEntity.setCheckoutDate(bookingRequestDTO.getCheckoutDate());

        return bookingEntity;
    }

    @Override
    public List<BookingEntity> requestDTOListToEntityList(List<BookingRequestDTO> bookingRequestDTOS) {

        List<BookingEntity> bookingEntityList = new ArrayList<>();
        for (BookingRequestDTO requestDTO : bookingRequestDTOS){
            bookingEntityList.add(requestDTOToEntity(requestDTO));
        }
        return bookingEntityList;
    }

    @Override
    public BookingEntity requestDTOToExistEntity(BookingRequestDTO bookingRequestDTO, BookingEntity entity) {

        entity.setClient(clientMapper.requestDTOToEntity(bookingRequestDTO.getClient()));
        entity.setPlane(planeMapper.requestDTOToEntity(bookingRequestDTO.getPlane()));
        entity.setPlaneSeat(bookingRequestDTO.getPlaneSeat());
        entity.setDepartureLocation(bookingRequestDTO.getDepartureLocation());
        entity.setArrivalLocation(bookingRequestDTO.getArrivalLocation());
        entity.setFligthDate(bookingRequestDTO.getFlightDate());
        entity.setHotel(hotelMapper.requestDTOToEntity(bookingRequestDTO.getHotel()));
        entity.setRoomNumber(bookingRequestDTO.getRoomNumber());
        entity.setCheckinDate(bookingRequestDTO.getCheckingDate());
        entity.setCheckoutDate(bookingRequestDTO.getCheckoutDate());

        return entity;
    }

    @Override
    public Page<BookingDTO> pageEntityToPageDTO(Page<BookingEntity> bookingEntities) {
        return bookingEntities.map(this::entityToDTO);
    }
}
