package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.BookingEntity;
import com.allianz.healthtourism.database.entity.RoomEntity;
import com.allianz.healthtourism.model.requestDTO.RoomRequestDTO;
import com.allianz.healthtourism.model.responseDTO.BookingForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.RoomResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T12:58:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomEntity requestDtoToEntity(RoomRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setRoomNo( requestDTO.getRoomNo() );

        return roomEntity;
    }

    @Override
    public RoomResponseDTO entityToResponseDto(RoomEntity entity) {
        if ( entity == null ) {
            return null;
        }

        RoomResponseDTO roomResponseDTO = new RoomResponseDTO();

        roomResponseDTO.setId( entity.getId() );
        roomResponseDTO.setUuid( entity.getUuid() );
        roomResponseDTO.setCreationDate( entity.getCreationDate() );
        roomResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        roomResponseDTO.setRoomNo( entity.getRoomNo() );
        roomResponseDTO.setBookings( bookingEntityListToBookingForPatientResponseDTOList( entity.getBookings() ) );

        return roomResponseDTO;
    }

    @Override
    public List<RoomResponseDTO> entityListToResponseDtoList(List<RoomEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RoomResponseDTO> list = new ArrayList<RoomResponseDTO>( entityList.size() );
        for ( RoomEntity roomEntity : entityList ) {
            list.add( entityToResponseDto( roomEntity ) );
        }

        return list;
    }

    @Override
    public RoomEntity updateEntityFromRequestDTO(RoomRequestDTO requestDTO, RoomEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setRoomNo( requestDTO.getRoomNo() );

        return entity;
    }

    protected BookingForPatientResponseDTO bookingEntityToBookingForPatientResponseDTO(BookingEntity bookingEntity) {
        if ( bookingEntity == null ) {
            return null;
        }

        BookingForPatientResponseDTO bookingForPatientResponseDTO = new BookingForPatientResponseDTO();

        bookingForPatientResponseDTO.setId( bookingEntity.getId() );
        bookingForPatientResponseDTO.setUuid( bookingEntity.getUuid() );
        bookingForPatientResponseDTO.setCreationDate( bookingEntity.getCreationDate() );
        bookingForPatientResponseDTO.setLastModifiedDate( bookingEntity.getLastModifiedDate() );
        bookingForPatientResponseDTO.setBookingDate( bookingEntity.getBookingDate() );

        return bookingForPatientResponseDTO;
    }

    protected List<BookingForPatientResponseDTO> bookingEntityListToBookingForPatientResponseDTOList(List<BookingEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<BookingForPatientResponseDTO> list1 = new ArrayList<BookingForPatientResponseDTO>( list.size() );
        for ( BookingEntity bookingEntity : list ) {
            list1.add( bookingEntityToBookingForPatientResponseDTO( bookingEntity ) );
        }

        return list1;
    }
}
