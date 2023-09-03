package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.database.entity.SeatEntity;
import com.allianz.healthtourism.model.requestDTO.FlightRequestDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.FlightForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.FlightResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PlanePlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.SeatPlainResponseDTO;
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
public class FlightMapperImpl implements FlightMapper {

    @Override
    public FlightResponseDTO entityToResponseDto(FlightEntity entity) {
        if ( entity == null ) {
            return null;
        }

        FlightResponseDTO flightResponseDTO = new FlightResponseDTO();

        flightResponseDTO.setId( entity.getId() );
        flightResponseDTO.setUuid( entity.getUuid() );
        flightResponseDTO.setCreationDate( entity.getCreationDate() );
        flightResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        flightResponseDTO.setPrice( entity.getPrice() );
        flightResponseDTO.setFlightDate( entity.getFlightDate() );
        flightResponseDTO.setCityTo( cityEntityToCityResponseDTO( entity.getCityTo() ) );
        flightResponseDTO.setCityFrom( cityEntityToCityResponseDTO( entity.getCityFrom() ) );
        flightResponseDTO.setPlane( planeEntityToPlanePlainResponseDTO( entity.getPlane() ) );
        flightResponseDTO.setPatients( patientEntityListToPatientPlainResponseDTOList( entity.getPatients() ) );
        flightResponseDTO.setSeats( seatEntityListToSeatPlainResponseDTOList( entity.getSeats() ) );

        return flightResponseDTO;
    }

    @Override
    public List<FlightResponseDTO> entityListToResponseDtoList(List<FlightEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FlightResponseDTO> list = new ArrayList<FlightResponseDTO>( entityList.size() );
        for ( FlightEntity flightEntity : entityList ) {
            list.add( entityToResponseDto( flightEntity ) );
        }

        return list;
    }

    @Override
    public FlightEntity updateEntityFromRequestDTO(FlightRequestDTO requestDTO, FlightEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setPrice( requestDTO.getPrice() );
        entity.setFlightDate( requestDTO.getFlightDate() );

        return entity;
    }

    @Override
    public FlightEntity requestDtoToEntity(FlightRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        FlightEntity flightEntity = new FlightEntity();

        flightEntity.setCityTo( flightRequestDTOToCityEntity( requestDTO ) );
        flightEntity.setCityFrom( flightRequestDTOToCityEntity1( requestDTO ) );
        flightEntity.setPlane( flightRequestDTOToPlaneEntity( requestDTO ) );
        flightEntity.setPrice( requestDTO.getPrice() );
        flightEntity.setFlightDate( requestDTO.getFlightDate() );

        return flightEntity;
    }

    @Override
    public List<FlightForPatientResponseDTO> entityListToResponseDtoListForPatient(List<FlightEntity> flightEntities) {
        if ( flightEntities == null ) {
            return null;
        }

        List<FlightForPatientResponseDTO> list = new ArrayList<FlightForPatientResponseDTO>( flightEntities.size() );
        for ( FlightEntity flightEntity : flightEntities ) {
            list.add( flightEntityToFlightForPatientResponseDTO( flightEntity ) );
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

    protected PlanePlainResponseDTO planeEntityToPlanePlainResponseDTO(PlaneEntity planeEntity) {
        if ( planeEntity == null ) {
            return null;
        }

        PlanePlainResponseDTO planePlainResponseDTO = new PlanePlainResponseDTO();

        planePlainResponseDTO.setId( planeEntity.getId() );
        planePlainResponseDTO.setUuid( planeEntity.getUuid() );
        planePlainResponseDTO.setCreationDate( planeEntity.getCreationDate() );
        planePlainResponseDTO.setLastModifiedDate( planeEntity.getLastModifiedDate() );
        planePlainResponseDTO.setName( planeEntity.getName() );

        return planePlainResponseDTO;
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

    protected SeatPlainResponseDTO seatEntityToSeatPlainResponseDTO(SeatEntity seatEntity) {
        if ( seatEntity == null ) {
            return null;
        }

        SeatPlainResponseDTO seatPlainResponseDTO = new SeatPlainResponseDTO();

        seatPlainResponseDTO.setId( seatEntity.getId() );
        seatPlainResponseDTO.setUuid( seatEntity.getUuid() );
        seatPlainResponseDTO.setCreationDate( seatEntity.getCreationDate() );
        seatPlainResponseDTO.setLastModifiedDate( seatEntity.getLastModifiedDate() );
        seatPlainResponseDTO.setSeatNo( seatEntity.getSeatNo() );
        seatPlainResponseDTO.setAvailable( seatEntity.isAvailable() );

        return seatPlainResponseDTO;
    }

    protected List<SeatPlainResponseDTO> seatEntityListToSeatPlainResponseDTOList(List<SeatEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SeatPlainResponseDTO> list1 = new ArrayList<SeatPlainResponseDTO>( list.size() );
        for ( SeatEntity seatEntity : list ) {
            list1.add( seatEntityToSeatPlainResponseDTO( seatEntity ) );
        }

        return list1;
    }

    protected CityEntity flightRequestDTOToCityEntity(FlightRequestDTO flightRequestDTO) {
        if ( flightRequestDTO == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setId( flightRequestDTO.getCityToId() );

        return cityEntity;
    }

    protected CityEntity flightRequestDTOToCityEntity1(FlightRequestDTO flightRequestDTO) {
        if ( flightRequestDTO == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setId( flightRequestDTO.getCityFromId() );

        return cityEntity;
    }

    protected PlaneEntity flightRequestDTOToPlaneEntity(FlightRequestDTO flightRequestDTO) {
        if ( flightRequestDTO == null ) {
            return null;
        }

        PlaneEntity planeEntity = new PlaneEntity();

        planeEntity.setId( flightRequestDTO.getPlaneId() );

        return planeEntity;
    }

    protected FlightForPatientResponseDTO flightEntityToFlightForPatientResponseDTO(FlightEntity flightEntity) {
        if ( flightEntity == null ) {
            return null;
        }

        FlightForPatientResponseDTO flightForPatientResponseDTO = new FlightForPatientResponseDTO();

        flightForPatientResponseDTO.setId( flightEntity.getId() );
        flightForPatientResponseDTO.setUuid( flightEntity.getUuid() );
        flightForPatientResponseDTO.setCreationDate( flightEntity.getCreationDate() );
        flightForPatientResponseDTO.setLastModifiedDate( flightEntity.getLastModifiedDate() );
        flightForPatientResponseDTO.setPrice( flightEntity.getPrice() );
        flightForPatientResponseDTO.setFlightDate( flightEntity.getFlightDate() );
        flightForPatientResponseDTO.setCityTo( cityEntityToCityResponseDTO( flightEntity.getCityTo() ) );
        flightForPatientResponseDTO.setCityFrom( cityEntityToCityResponseDTO( flightEntity.getCityFrom() ) );
        flightForPatientResponseDTO.setPlane( planeEntityToPlanePlainResponseDTO( flightEntity.getPlane() ) );
        flightForPatientResponseDTO.setSeats( seatEntityListToSeatPlainResponseDTOList( flightEntity.getSeats() ) );

        return flightForPatientResponseDTO;
    }
}
