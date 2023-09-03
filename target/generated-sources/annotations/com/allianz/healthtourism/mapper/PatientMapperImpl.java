package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.entity.BookingEntity;
import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.ExaminationRecordEntity;
import com.allianz.healthtourism.database.entity.FlightEntity;
import com.allianz.healthtourism.database.entity.HealthCareServiceEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.database.entity.PlaneTicketEntity;
import com.allianz.healthtourism.database.entity.SeatEntity;
import com.allianz.healthtourism.model.requestDTO.PatientRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentWithPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.BookingForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationRecordResponseDTO;
import com.allianz.healthtourism.model.responseDTO.FlightForTicketResponseDTO;
import com.allianz.healthtourism.model.responseDTO.PatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneTicketResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.DoctorPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HealthCareServicePlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HospitalPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PlanePlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.SeatPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.UserPlainResponseDTO;
import com.allianz.healthtourism.util.security.RoleEntity;
import com.allianz.healthtourism.util.security.RoleResponseDTO;
import com.allianz.healthtourism.util.security.UserEntity;
import com.allianz.healthtourism.util.security.UserRequestDTO;
import com.allianz.healthtourism.util.security.UserResponseDTO;
import com.allianz.healthtourism.util.security.UserResponseWithoutRoleDTO;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T12:58:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientEntity requestDtoToEntity(PatientRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setUser( userRequestDTOToUserEntity( requestDTO.getUser() ) );

        return patientEntity;
    }

    @Override
    public PatientResponseDTO entityToResponseDto(PatientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId( entity.getId() );
        patientResponseDTO.setUuid( entity.getUuid() );
        patientResponseDTO.setCreationDate( entity.getCreationDate() );
        patientResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        patientResponseDTO.setUser( userEntityToUserResponseDTO( entity.getUser() ) );
        patientResponseDTO.setExaminationRecords( examinationRecordEntityListToExaminationRecordResponseDTOList( entity.getExaminationRecords() ) );
        patientResponseDTO.setBookings( bookingEntityListToBookingForPatientResponseDTOList( entity.getBookings() ) );
        patientResponseDTO.setAppointments( appointmentEntityListToAppointmentResponseDTOList( entity.getAppointments() ) );
        patientResponseDTO.setPlaneTickets( planeTicketEntityListToPlaneTicketResponseDTOList( entity.getPlaneTickets() ) );

        return patientResponseDTO;
    }

    @Override
    public List<PatientResponseDTO> entityListToResponseDtoList(List<PatientEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PatientResponseDTO> list = new ArrayList<PatientResponseDTO>( entityList.size() );
        for ( PatientEntity patientEntity : entityList ) {
            list.add( entityToResponseDto( patientEntity ) );
        }

        return list;
    }

    @Override
    public PatientEntity updateEntityFromRequestDTO(PatientRequestDTO requestDTO, PatientEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        if ( requestDTO.getUser() != null ) {
            if ( entity.getUser() == null ) {
                entity.setUser( new UserEntity() );
            }
            userRequestDTOToUserEntity1( requestDTO.getUser(), entity.getUser() );
        }
        else {
            entity.setUser( null );
        }

        return entity;
    }

    protected UserEntity userRequestDTOToUserEntity(UserRequestDTO userRequestDTO) {
        if ( userRequestDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( userRequestDTO.getUsername() );
        userEntity.setFirstName( userRequestDTO.getFirstName() );
        userEntity.setLastName( userRequestDTO.getLastName() );
        userEntity.setPassword( userRequestDTO.getPassword() );
        userEntity.setEmail( userRequestDTO.getEmail() );
        userEntity.setPhotoLink( userRequestDTO.getPhotoLink() );

        return userEntity;
    }

    protected UserResponseWithoutRoleDTO userEntityToUserResponseWithoutRoleDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponseWithoutRoleDTO userResponseWithoutRoleDTO = new UserResponseWithoutRoleDTO();

        userResponseWithoutRoleDTO.setUsername( userEntity.getUsername() );
        userResponseWithoutRoleDTO.setEmail( userEntity.getEmail() );
        userResponseWithoutRoleDTO.setFirstName( userEntity.getFirstName() );
        userResponseWithoutRoleDTO.setLastName( userEntity.getLastName() );
        userResponseWithoutRoleDTO.setPassword( userEntity.getPassword() );
        userResponseWithoutRoleDTO.setPhotoLink( userEntity.getPhotoLink() );
        userResponseWithoutRoleDTO.setEnable( userEntity.isEnable() );

        return userResponseWithoutRoleDTO;
    }

    protected List<UserResponseWithoutRoleDTO> userEntityListToUserResponseWithoutRoleDTOList(List<UserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<UserResponseWithoutRoleDTO> list1 = new ArrayList<UserResponseWithoutRoleDTO>( list.size() );
        for ( UserEntity userEntity : list ) {
            list1.add( userEntityToUserResponseWithoutRoleDTO( userEntity ) );
        }

        return list1;
    }

    protected RoleResponseDTO roleEntityToRoleResponseDTO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();

        roleResponseDTO.setId( roleEntity.getId() );
        roleResponseDTO.setUuid( roleEntity.getUuid() );
        roleResponseDTO.setCreationDate( roleEntity.getCreationDate() );
        roleResponseDTO.setLastModifiedDate( roleEntity.getLastModifiedDate() );
        roleResponseDTO.setName( roleEntity.getName() );
        roleResponseDTO.setDescription( roleEntity.getDescription() );
        roleResponseDTO.setUsers( userEntityListToUserResponseWithoutRoleDTOList( roleEntity.getUsers() ) );

        return roleResponseDTO;
    }

    protected Set<RoleResponseDTO> roleEntitySetToRoleResponseDTOSet(Set<RoleEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleResponseDTO> set1 = new LinkedHashSet<RoleResponseDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleEntity roleEntity : set ) {
            set1.add( roleEntityToRoleResponseDTO( roleEntity ) );
        }

        return set1;
    }

    protected UserResponseDTO userEntityToUserResponseDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId( userEntity.getId() );
        userResponseDTO.setUuid( userEntity.getUuid() );
        userResponseDTO.setCreationDate( userEntity.getCreationDate() );
        userResponseDTO.setLastModifiedDate( userEntity.getLastModifiedDate() );
        userResponseDTO.setUsername( userEntity.getUsername() );
        userResponseDTO.setEmail( userEntity.getEmail() );
        userResponseDTO.setFirstName( userEntity.getFirstName() );
        userResponseDTO.setLastName( userEntity.getLastName() );
        userResponseDTO.setPassword( userEntity.getPassword() );
        userResponseDTO.setPhotoLink( userEntity.getPhotoLink() );
        userResponseDTO.setEnable( userEntity.isEnable() );
        userResponseDTO.setRoles( roleEntitySetToRoleResponseDTOSet( userEntity.getRoles() ) );

        return userResponseDTO;
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

    protected AppointmentWithPatientResponseDTO appointmentEntityToAppointmentWithPatientResponseDTO(AppointmentEntity appointmentEntity) {
        if ( appointmentEntity == null ) {
            return null;
        }

        AppointmentWithPatientResponseDTO appointmentWithPatientResponseDTO = new AppointmentWithPatientResponseDTO();

        appointmentWithPatientResponseDTO.setId( appointmentEntity.getId() );
        appointmentWithPatientResponseDTO.setUuid( appointmentEntity.getUuid() );
        appointmentWithPatientResponseDTO.setCreationDate( appointmentEntity.getCreationDate() );
        appointmentWithPatientResponseDTO.setLastModifiedDate( appointmentEntity.getLastModifiedDate() );
        appointmentWithPatientResponseDTO.setAppointmentDate( appointmentEntity.getAppointmentDate() );
        appointmentWithPatientResponseDTO.setPatient( patientEntityToPatientPlainResponseDTO( appointmentEntity.getPatient() ) );

        return appointmentWithPatientResponseDTO;
    }

    protected ExaminationRecordResponseDTO examinationRecordEntityToExaminationRecordResponseDTO(ExaminationRecordEntity examinationRecordEntity) {
        if ( examinationRecordEntity == null ) {
            return null;
        }

        ExaminationRecordResponseDTO examinationRecordResponseDTO = new ExaminationRecordResponseDTO();

        examinationRecordResponseDTO.setId( examinationRecordEntity.getId() );
        examinationRecordResponseDTO.setUuid( examinationRecordEntity.getUuid() );
        examinationRecordResponseDTO.setCreationDate( examinationRecordEntity.getCreationDate() );
        examinationRecordResponseDTO.setLastModifiedDate( examinationRecordEntity.getLastModifiedDate() );
        examinationRecordResponseDTO.setNotes( examinationRecordEntity.getNotes() );
        examinationRecordResponseDTO.setAppointment( appointmentEntityToAppointmentWithPatientResponseDTO( examinationRecordEntity.getAppointment() ) );

        return examinationRecordResponseDTO;
    }

    protected List<ExaminationRecordResponseDTO> examinationRecordEntityListToExaminationRecordResponseDTOList(List<ExaminationRecordEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ExaminationRecordResponseDTO> list1 = new ArrayList<ExaminationRecordResponseDTO>( list.size() );
        for ( ExaminationRecordEntity examinationRecordEntity : list ) {
            list1.add( examinationRecordEntityToExaminationRecordResponseDTO( examinationRecordEntity ) );
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

    protected HospitalPlainResponseDTO hospitalEntityToHospitalPlainResponseDTO(HospitalEntity hospitalEntity) {
        if ( hospitalEntity == null ) {
            return null;
        }

        HospitalPlainResponseDTO hospitalPlainResponseDTO = new HospitalPlainResponseDTO();

        hospitalPlainResponseDTO.setId( hospitalEntity.getId() );
        hospitalPlainResponseDTO.setUuid( hospitalEntity.getUuid() );
        hospitalPlainResponseDTO.setCreationDate( hospitalEntity.getCreationDate() );
        hospitalPlainResponseDTO.setLastModifiedDate( hospitalEntity.getLastModifiedDate() );
        hospitalPlainResponseDTO.setName( hospitalEntity.getName() );
        hospitalPlainResponseDTO.setCity( cityEntityToCityResponseDTO( hospitalEntity.getCity() ) );

        return hospitalPlainResponseDTO;
    }

    protected DoctorPlainResponseDTO doctorEntityToDoctorPlainResponseDTO(DoctorEntity doctorEntity) {
        if ( doctorEntity == null ) {
            return null;
        }

        DoctorPlainResponseDTO doctorPlainResponseDTO = new DoctorPlainResponseDTO();

        doctorPlainResponseDTO.setId( doctorEntity.getId() );
        doctorPlainResponseDTO.setUuid( doctorEntity.getUuid() );
        doctorPlainResponseDTO.setCreationDate( doctorEntity.getCreationDate() );
        doctorPlainResponseDTO.setLastModifiedDate( doctorEntity.getLastModifiedDate() );
        doctorPlainResponseDTO.setUser( userEntityToUserPlainResponseDTO( doctorEntity.getUser() ) );

        return doctorPlainResponseDTO;
    }

    protected HealthCareServicePlainResponseDTO healthCareServiceEntityToHealthCareServicePlainResponseDTO(HealthCareServiceEntity healthCareServiceEntity) {
        if ( healthCareServiceEntity == null ) {
            return null;
        }

        HealthCareServicePlainResponseDTO healthCareServicePlainResponseDTO = new HealthCareServicePlainResponseDTO();

        healthCareServicePlainResponseDTO.setId( healthCareServiceEntity.getId() );
        healthCareServicePlainResponseDTO.setUuid( healthCareServiceEntity.getUuid() );
        healthCareServicePlainResponseDTO.setCreationDate( healthCareServiceEntity.getCreationDate() );
        healthCareServicePlainResponseDTO.setLastModifiedDate( healthCareServiceEntity.getLastModifiedDate() );
        healthCareServicePlainResponseDTO.setName( healthCareServiceEntity.getName() );
        healthCareServicePlainResponseDTO.setPrice( healthCareServiceEntity.getPrice() );

        return healthCareServicePlainResponseDTO;
    }

    protected AppointmentResponseDTO appointmentEntityToAppointmentResponseDTO(AppointmentEntity appointmentEntity) {
        if ( appointmentEntity == null ) {
            return null;
        }

        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();

        appointmentResponseDTO.setId( appointmentEntity.getId() );
        appointmentResponseDTO.setUuid( appointmentEntity.getUuid() );
        appointmentResponseDTO.setCreationDate( appointmentEntity.getCreationDate() );
        appointmentResponseDTO.setLastModifiedDate( appointmentEntity.getLastModifiedDate() );
        appointmentResponseDTO.setAppointmentDate( appointmentEntity.getAppointmentDate() );
        appointmentResponseDTO.setPatient( patientEntityToPatientPlainResponseDTO( appointmentEntity.getPatient() ) );
        appointmentResponseDTO.setHospital( hospitalEntityToHospitalPlainResponseDTO( appointmentEntity.getHospital() ) );
        appointmentResponseDTO.setDoctor( doctorEntityToDoctorPlainResponseDTO( appointmentEntity.getDoctor() ) );
        appointmentResponseDTO.setHealthService( healthCareServiceEntityToHealthCareServicePlainResponseDTO( appointmentEntity.getHealthService() ) );

        return appointmentResponseDTO;
    }

    protected List<AppointmentResponseDTO> appointmentEntityListToAppointmentResponseDTOList(List<AppointmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentResponseDTO> list1 = new ArrayList<AppointmentResponseDTO>( list.size() );
        for ( AppointmentEntity appointmentEntity : list ) {
            list1.add( appointmentEntityToAppointmentResponseDTO( appointmentEntity ) );
        }

        return list1;
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

    protected PlaneTicketResponseDTO planeTicketEntityToPlaneTicketResponseDTO(PlaneTicketEntity planeTicketEntity) {
        if ( planeTicketEntity == null ) {
            return null;
        }

        PlaneTicketResponseDTO planeTicketResponseDTO = new PlaneTicketResponseDTO();

        planeTicketResponseDTO.setId( planeTicketEntity.getId() );
        planeTicketResponseDTO.setUuid( planeTicketEntity.getUuid() );
        planeTicketResponseDTO.setCreationDate( planeTicketEntity.getCreationDate() );
        planeTicketResponseDTO.setLastModifiedDate( planeTicketEntity.getLastModifiedDate() );
        planeTicketResponseDTO.setFlight( flightEntityToFlightForTicketResponseDTO( planeTicketEntity.getFlight() ) );
        planeTicketResponseDTO.setSeat( seatEntityToSeatPlainResponseDTO( planeTicketEntity.getSeat() ) );
        planeTicketResponseDTO.setPatient( patientEntityToPatientPlainResponseDTO( planeTicketEntity.getPatient() ) );

        return planeTicketResponseDTO;
    }

    protected List<PlaneTicketResponseDTO> planeTicketEntityListToPlaneTicketResponseDTOList(List<PlaneTicketEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PlaneTicketResponseDTO> list1 = new ArrayList<PlaneTicketResponseDTO>( list.size() );
        for ( PlaneTicketEntity planeTicketEntity : list ) {
            list1.add( planeTicketEntityToPlaneTicketResponseDTO( planeTicketEntity ) );
        }

        return list1;
    }

    protected void userRequestDTOToUserEntity1(UserRequestDTO userRequestDTO, UserEntity mappingTarget) {
        if ( userRequestDTO == null ) {
            return;
        }

        mappingTarget.setUsername( userRequestDTO.getUsername() );
        mappingTarget.setFirstName( userRequestDTO.getFirstName() );
        mappingTarget.setLastName( userRequestDTO.getLastName() );
        mappingTarget.setPassword( userRequestDTO.getPassword() );
        mappingTarget.setEmail( userRequestDTO.getEmail() );
        mappingTarget.setPhotoLink( userRequestDTO.getPhotoLink() );
    }
}
