package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.database.entity.PlaneTicketEntity;
import com.allianz.healthtourism.database.entity.SeatEntity;
import com.allianz.healthtourism.model.requestDTO.PlaneTicketRequestDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.FlightForTicketResponseDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneTicketResponseDTO;
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
public class PlaneTicketMapperImpl implements PlaneTicketMapper {

    @Override
    public PlaneTicketResponseDTO entityToResponseDto(PlaneTicketEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PlaneTicketResponseDTO planeTicketResponseDTO = new PlaneTicketResponseDTO();

        planeTicketResponseDTO.setId( entity.getId() );
        planeTicketResponseDTO.setUuid( entity.getUuid() );
        planeTicketResponseDTO.setCreationDate( entity.getCreationDate() );
        planeTicketResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        planeTicketResponseDTO.setFlight( flightEntityToFlightForTicketResponseDTO( entity.getFlight() ) );
        planeTicketResponseDTO.setSeat( seatEntityToSeatPlainResponseDTO( entity.getSeat() ) );
        planeTicketResponseDTO.setPatient( patientEntityToPatientPlainResponseDTO( entity.getPatient() ) );

        return planeTicketResponseDTO;
    }

    @Override
    public List<PlaneTicketResponseDTO> entityListToResponseDtoList(List<PlaneTicketEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PlaneTicketResponseDTO> list = new ArrayList<PlaneTicketResponseDTO>( entityList.size() );
        for ( PlaneTicketEntity planeTicketEntity : entityList ) {
            list.add( entityToResponseDto( planeTicketEntity ) );
        }

        return list;
    }

    @Override
    public PlaneTicketEntity updateEntityFromRequestDTO(PlaneTicketRequestDTO requestDTO, PlaneTicketEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        return entity;
    }

    @Override
    public PlaneTicketEntity requestDtoToEntity(PlaneTicketRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        PlaneTicketEntity planeTicketEntity = new PlaneTicketEntity();

        planeTicketEntity.setPatient( planeTicketRequestDTOToPatientEntity( requestDTO ) );
        planeTicketEntity.setSeat( planeTicketRequestDTOToSeatEntity( requestDTO ) );
        planeTicketEntity.setFlight( planeTicketRequestDTOToFlightEntity( requestDTO ) );

        return planeTicketEntity;
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

    protected FlightForTicketResponseDTO flightEntityToFlightForTicketResponseDTO(FlightEntity flightEntity) {
        if ( flightEntity == null ) {
            return null;
        }

        FlightForTicketResponseDTO flightForTicketResponseDTO = new FlightForTicketResponseDTO();

        flightForTicketResponseDTO.setId( flightEntity.getId() );
        flightForTicketResponseDTO.setUuid( flightEntity.getUuid() );
        flightForTicketResponseDTO.setCreationDate( flightEntity.getCreationDate() );
        flightForTicketResponseDTO.setLastModifiedDate( flightEntity.getLastModifiedDate() );
        flightForTicketResponseDTO.setPrice( flightEntity.getPrice() );
        flightForTicketResponseDTO.setFlightDate( flightEntity.getFlightDate() );
        flightForTicketResponseDTO.setCityTo( cityEntityToCityResponseDTO( flightEntity.getCityTo() ) );
        flightForTicketResponseDTO.setCityFrom( cityEntityToCityResponseDTO( flightEntity.getCityFrom() ) );
        flightForTicketResponseDTO.setPlane( planeEntityToPlanePlainResponseDTO( flightEntity.getPlane() ) );

        return flightForTicketResponseDTO;
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

    protected PatientEntity planeTicketRequestDTOToPatientEntity(PlaneTicketRequestDTO planeTicketRequestDTO) {
        if ( planeTicketRequestDTO == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId( planeTicketRequestDTO.getPatientId() );

        return patientEntity;
    }

    protected SeatEntity planeTicketRequestDTOToSeatEntity(PlaneTicketRequestDTO planeTicketRequestDTO) {
        if ( planeTicketRequestDTO == null ) {
            return null;
        }

        SeatEntity seatEntity = new SeatEntity();

        seatEntity.setId( planeTicketRequestDTO.getSeatId() );

        return seatEntity;
    }

    protected FlightEntity planeTicketRequestDTOToFlightEntity(PlaneTicketRequestDTO planeTicketRequestDTO) {
        if ( planeTicketRequestDTO == null ) {
            return null;
        }

        FlightEntity flightEntity = new FlightEntity();

        flightEntity.setId( planeTicketRequestDTO.getFlightId() );

        return flightEntity;
    }
}
