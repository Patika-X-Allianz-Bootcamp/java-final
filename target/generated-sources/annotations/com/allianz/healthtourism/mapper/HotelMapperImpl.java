package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.BookingEntity;
import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.entity.RoomEntity;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.model.responseDTO.BookingForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HotelForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HotelResponseDTO;
import com.allianz.healthtourism.model.responseDTO.RoomResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.RoomPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.UserPlainResponseDTO;
import com.allianz.healthtourism.util.security.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T12:58:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class HotelMapperImpl implements HotelMapper {

    @Override
    public HotelResponseDTO entityToResponseDto(HotelEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HotelResponseDTO hotelResponseDTO = new HotelResponseDTO();

        hotelResponseDTO.setId( entity.getId() );
        hotelResponseDTO.setUuid( entity.getUuid() );
        hotelResponseDTO.setCreationDate( entity.getCreationDate() );
        hotelResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        hotelResponseDTO.setName( entity.getName() );
        hotelResponseDTO.setPrice( entity.getPrice() );
        hotelResponseDTO.setCity( cityEntityToCityResponseDTO( entity.getCity() ) );
        hotelResponseDTO.setPatients( patientEntityListToPatientPlainResponseDTOList( entity.getPatients() ) );
        hotelResponseDTO.setRooms( roomEntityListToRoomResponseDTOList( entity.getRooms() ) );

        return hotelResponseDTO;
    }

    @Override
    public List<HotelResponseDTO> entityListToResponseDtoList(List<HotelEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HotelResponseDTO> list = new ArrayList<HotelResponseDTO>( entityList.size() );
        for ( HotelEntity hotelEntity : entityList ) {
            list.add( entityToResponseDto( hotelEntity ) );
        }

        return list;
    }

    @Override
    public HotelEntity updateEntityFromRequestDTO(HotelRequestDTO requestDTO, HotelEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setName( requestDTO.getName() );
        entity.setPrice( requestDTO.getPrice() );

        return entity;
    }

    @Override
    public HotelEntity requestDtoToEntity(HotelRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setCity( hotelRequestDTOToCityEntity( requestDTO ) );
        hotelEntity.setName( requestDTO.getName() );
        hotelEntity.setPrice( requestDTO.getPrice() );

        return hotelEntity;
    }

    @Override
    public List<HotelForPatientResponseDTO> entityListToResponseDtoListForPatient(List<HotelEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HotelForPatientResponseDTO> list = new ArrayList<HotelForPatientResponseDTO>( entityList.size() );
        for ( HotelEntity hotelEntity : entityList ) {
            list.add( hotelEntityToHotelForPatientResponseDTO( hotelEntity ) );
        }

        return list;
    }

    protected CityResponseDTO cityEntityToCityResponseDTO(CityEntity cityEntity) {
        if ( cityEntity == null ) {
            return null;
        }

        CityResponseDTO cityResponseDTO = new CityResponseDTO();

        cityResponseDTO.setId( cityEntity.getId() );
        cityResponseDTO.setUuid( cityEntity.getUuid() );
        cityResponseDTO.setCreationDate( cityEntity.getCreationDate() );
        cityResponseDTO.setLastModifiedDate( cityEntity.getLastModifiedDate() );
        cityResponseDTO.setName( cityEntity.getName() );
        cityResponseDTO.setCountry( cityEntity.getCountry() );

        return cityResponseDTO;
    }

    protected UserPlainResponseDTO userEntityToUserPlainResponseDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserPlainResponseDTO userPlainResponseDTO = new UserPlainResponseDTO();

        userPlainResponseDTO.setId( userEntity.getId() );
        userPlainResponseDTO.setUuid( userEntity.getUuid() );
        userPlainResponseDTO.setCreationDate( userEntity.getCreationDate() );
        userPlainResponseDTO.setLastModifiedDate( userEntity.getLastModifiedDate() );
        userPlainResponseDTO.setEmail( userEntity.getEmail() );
        userPlainResponseDTO.setFirstName( userEntity.getFirstName() );
        userPlainResponseDTO.setLastName( userEntity.getLastName() );

        return userPlainResponseDTO;
    }

    protected PatientPlainResponseDTO patientEntityToPatientPlainResponseDTO(PatientEntity patientEntity) {
        if ( patientEntity == null ) {
            return null;
        }

        PatientPlainResponseDTO patientPlainResponseDTO = new PatientPlainResponseDTO();

        patientPlainResponseDTO.setId( patientEntity.getId() );
        patientPlainResponseDTO.setUuid( patientEntity.getUuid() );
        patientPlainResponseDTO.setCreationDate( patientEntity.getCreationDate() );
        patientPlainResponseDTO.setLastModifiedDate( patientEntity.getLastModifiedDate() );
        patientPlainResponseDTO.setUser( userEntityToUserPlainResponseDTO( patientEntity.getUser() ) );

        return patientPlainResponseDTO;
    }

    protected List<PatientPlainResponseDTO> patientEntityListToPatientPlainResponseDTOList(List<PatientEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PatientPlainResponseDTO> list1 = new ArrayList<PatientPlainResponseDTO>( list.size() );
        for ( PatientEntity patientEntity : list ) {
            list1.add( patientEntityToPatientPlainResponseDTO( patientEntity ) );
        }

        return list1;
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

    protected RoomResponseDTO roomEntityToRoomResponseDTO(RoomEntity roomEntity) {
        if ( roomEntity == null ) {
            return null;
        }

        RoomResponseDTO roomResponseDTO = new RoomResponseDTO();

        roomResponseDTO.setId( roomEntity.getId() );
        roomResponseDTO.setUuid( roomEntity.getUuid() );
        roomResponseDTO.setCreationDate( roomEntity.getCreationDate() );
        roomResponseDTO.setLastModifiedDate( roomEntity.getLastModifiedDate() );
        roomResponseDTO.setRoomNo( roomEntity.getRoomNo() );
        roomResponseDTO.setBookings( bookingEntityListToBookingForPatientResponseDTOList( roomEntity.getBookings() ) );

        return roomResponseDTO;
    }

    protected List<RoomResponseDTO> roomEntityListToRoomResponseDTOList(List<RoomEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<RoomResponseDTO> list1 = new ArrayList<RoomResponseDTO>( list.size() );
        for ( RoomEntity roomEntity : list ) {
            list1.add( roomEntityToRoomResponseDTO( roomEntity ) );
        }

        return list1;
    }

    protected CityEntity hotelRequestDTOToCityEntity(HotelRequestDTO hotelRequestDTO) {
        if ( hotelRequestDTO == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setId( hotelRequestDTO.getCityId() );

        return cityEntity;
    }

    protected RoomPlainResponseDTO roomEntityToRoomPlainResponseDTO(RoomEntity roomEntity) {
        if ( roomEntity == null ) {
            return null;
        }

        RoomPlainResponseDTO roomPlainResponseDTO = new RoomPlainResponseDTO();

        roomPlainResponseDTO.setId( roomEntity.getId() );
        roomPlainResponseDTO.setUuid( roomEntity.getUuid() );
        roomPlainResponseDTO.setCreationDate( roomEntity.getCreationDate() );
        roomPlainResponseDTO.setLastModifiedDate( roomEntity.getLastModifiedDate() );
        roomPlainResponseDTO.setRoomNo( roomEntity.getRoomNo() );
        roomPlainResponseDTO.setBookings( bookingEntityListToBookingForPatientResponseDTOList( roomEntity.getBookings() ) );

        return roomPlainResponseDTO;
    }

    protected List<RoomPlainResponseDTO> roomEntityListToRoomPlainResponseDTOList(List<RoomEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<RoomPlainResponseDTO> list1 = new ArrayList<RoomPlainResponseDTO>( list.size() );
        for ( RoomEntity roomEntity : list ) {
            list1.add( roomEntityToRoomPlainResponseDTO( roomEntity ) );
        }

        return list1;
    }

    protected HotelForPatientResponseDTO hotelEntityToHotelForPatientResponseDTO(HotelEntity hotelEntity) {
        if ( hotelEntity == null ) {
            return null;
        }

        HotelForPatientResponseDTO hotelForPatientResponseDTO = new HotelForPatientResponseDTO();

        hotelForPatientResponseDTO.setId( hotelEntity.getId() );
        hotelForPatientResponseDTO.setUuid( hotelEntity.getUuid() );
        hotelForPatientResponseDTO.setCreationDate( hotelEntity.getCreationDate() );
        hotelForPatientResponseDTO.setLastModifiedDate( hotelEntity.getLastModifiedDate() );
        hotelForPatientResponseDTO.setName( hotelEntity.getName() );
        hotelForPatientResponseDTO.setPrice( hotelEntity.getPrice() );
        hotelForPatientResponseDTO.setCity( cityEntityToCityResponseDTO( hotelEntity.getCity() ) );
        hotelForPatientResponseDTO.setRooms( roomEntityListToRoomPlainResponseDTOList( hotelEntity.getRooms() ) );

        return hotelForPatientResponseDTO;
    }
}
