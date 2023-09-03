package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.HealthCareServiceEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentResponseDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.DoctorPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HealthCareServicePlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HospitalPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
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
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentResponseDTO entityToResponseDto(AppointmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();

        appointmentResponseDTO.setId( entity.getId() );
        appointmentResponseDTO.setUuid( entity.getUuid() );
        appointmentResponseDTO.setCreationDate( entity.getCreationDate() );
        appointmentResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        appointmentResponseDTO.setAppointmentDate( entity.getAppointmentDate() );
        appointmentResponseDTO.setPatient( patientEntityToPatientPlainResponseDTO( entity.getPatient() ) );
        appointmentResponseDTO.setHospital( hospitalEntityToHospitalPlainResponseDTO( entity.getHospital() ) );
        appointmentResponseDTO.setDoctor( doctorEntityToDoctorPlainResponseDTO( entity.getDoctor() ) );
        appointmentResponseDTO.setHealthService( healthCareServiceEntityToHealthCareServicePlainResponseDTO( entity.getHealthService() ) );

        return appointmentResponseDTO;
    }

    @Override
    public List<AppointmentResponseDTO> entityListToResponseDtoList(List<AppointmentEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AppointmentResponseDTO> list = new ArrayList<AppointmentResponseDTO>( entityList.size() );
        for ( AppointmentEntity appointmentEntity : entityList ) {
            list.add( entityToResponseDto( appointmentEntity ) );
        }

        return list;
    }

    @Override
    public AppointmentEntity updateEntityFromRequestDTO(AppointmentRequestDTO requestDTO, AppointmentEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setAppointmentDate( requestDTO.getAppointmentDate() );

        return entity;
    }

    @Override
    public AppointmentEntity requestDtoToEntity(AppointmentRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        appointmentEntity.setPatient( appointmentRequestDTOToPatientEntity( requestDTO ) );
        appointmentEntity.setDoctor( appointmentRequestDTOToDoctorEntity( requestDTO ) );
        appointmentEntity.setHealthService( appointmentRequestDTOToHealthCareServiceEntity( requestDTO ) );
        appointmentEntity.setHospital( appointmentRequestDTOToHospitalEntity( requestDTO ) );
        appointmentEntity.setAppointmentDate( requestDTO.getAppointmentDate() );

        return appointmentEntity;
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

    protected PatientEntity appointmentRequestDTOToPatientEntity(AppointmentRequestDTO appointmentRequestDTO) {
        if ( appointmentRequestDTO == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId( appointmentRequestDTO.getPatientId() );

        return patientEntity;
    }

    protected DoctorEntity appointmentRequestDTOToDoctorEntity(AppointmentRequestDTO appointmentRequestDTO) {
        if ( appointmentRequestDTO == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId( appointmentRequestDTO.getDoctorId() );

        return doctorEntity;
    }

    protected HealthCareServiceEntity appointmentRequestDTOToHealthCareServiceEntity(AppointmentRequestDTO appointmentRequestDTO) {
        if ( appointmentRequestDTO == null ) {
            return null;
        }

        HealthCareServiceEntity healthCareServiceEntity = new HealthCareServiceEntity();

        healthCareServiceEntity.setId( appointmentRequestDTO.getHealthServiceId() );

        return healthCareServiceEntity;
    }

    protected HospitalEntity appointmentRequestDTOToHospitalEntity(AppointmentRequestDTO appointmentRequestDTO) {
        if ( appointmentRequestDTO == null ) {
            return null;
        }

        HospitalEntity hospitalEntity = new HospitalEntity();

        hospitalEntity.setId( appointmentRequestDTO.getHospitalId() );

        return hospitalEntity;
    }
}
