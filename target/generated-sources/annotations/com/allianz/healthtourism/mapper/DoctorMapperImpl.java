package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.ExaminationRecordEntity;
import com.allianz.healthtourism.database.entity.HealthCareServiceEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentWithPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorForPatientWithAppointmentResponseDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorResponseDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationRecordResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HealthCareServiceResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.AppointmentPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HospitalPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
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
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorResponseDTO entityToResponseDto(DoctorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();

        doctorResponseDTO.setId( entity.getId() );
        doctorResponseDTO.setUuid( entity.getUuid() );
        doctorResponseDTO.setCreationDate( entity.getCreationDate() );
        doctorResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        doctorResponseDTO.setHospital( hospitalEntityToHospitalPlainResponseDTO( entity.getHospital() ) );
        doctorResponseDTO.setHealthCareService( healthCareServiceEntityToHealthCareServiceResponseDTO( entity.getHealthCareService() ) );
        doctorResponseDTO.setExaminationRecords( examinationRecordEntityListToExaminationRecordResponseDTOList( entity.getExaminationRecords() ) );
        doctorResponseDTO.setUser( userEntityToUserResponseDTO( entity.getUser() ) );
        doctorResponseDTO.setAppointments( appointmentEntityListToAppointmentWithPatientResponseDTOList( entity.getAppointments() ) );

        return doctorResponseDTO;
    }

    @Override
    public List<DoctorResponseDTO> entityListToResponseDtoList(List<DoctorEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DoctorResponseDTO> list = new ArrayList<DoctorResponseDTO>( entityList.size() );
        for ( DoctorEntity doctorEntity : entityList ) {
            list.add( entityToResponseDto( doctorEntity ) );
        }

        return list;
    }

    @Override
    public DoctorEntity updateEntityFromRequestDTO(DoctorRequestDTO requestDTO, DoctorEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        if ( requestDTO.getUser() != null ) {
            if ( entity.getUser() == null ) {
                entity.setUser( new UserEntity() );
            }
            userRequestDTOToUserEntity( requestDTO.getUser(), entity.getUser() );
        }
        else {
            entity.setUser( null );
        }

        return entity;
    }

    @Override
    public DoctorEntity requestDtoToEntity(DoctorRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setHospital( doctorRequestDTOToHospitalEntity( requestDTO ) );
        doctorEntity.setHealthCareService( doctorRequestDTOToHealthCareServiceEntity( requestDTO ) );
        doctorEntity.setUser( userRequestDTOToUserEntity1( requestDTO.getUser() ) );

        return doctorEntity;
    }

    @Override
    public DoctorForPatientWithAppointmentResponseDTO entityToPatientResponseDto(DoctorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DoctorForPatientWithAppointmentResponseDTO doctorForPatientWithAppointmentResponseDTO = new DoctorForPatientWithAppointmentResponseDTO();

        doctorForPatientWithAppointmentResponseDTO.setId( entity.getId() );
        doctorForPatientWithAppointmentResponseDTO.setUuid( entity.getUuid() );
        doctorForPatientWithAppointmentResponseDTO.setCreationDate( entity.getCreationDate() );
        doctorForPatientWithAppointmentResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        doctorForPatientWithAppointmentResponseDTO.setUser( userEntityToUserPlainResponseDTO( entity.getUser() ) );
        doctorForPatientWithAppointmentResponseDTO.setHealthCareService( healthCareServiceEntityToHealthCareServiceResponseDTO( entity.getHealthCareService() ) );
        doctorForPatientWithAppointmentResponseDTO.setAppointments( appointmentEntityListToAppointmentPlainResponseDTOList( entity.getAppointments() ) );

        return doctorForPatientWithAppointmentResponseDTO;
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

    protected List<HospitalPlainResponseDTO> hospitalEntityListToHospitalPlainResponseDTOList(List<HospitalEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<HospitalPlainResponseDTO> list1 = new ArrayList<HospitalPlainResponseDTO>( list.size() );
        for ( HospitalEntity hospitalEntity : list ) {
            list1.add( hospitalEntityToHospitalPlainResponseDTO( hospitalEntity ) );
        }

        return list1;
    }

    protected HealthCareServiceResponseDTO healthCareServiceEntityToHealthCareServiceResponseDTO(HealthCareServiceEntity healthCareServiceEntity) {
        if ( healthCareServiceEntity == null ) {
            return null;
        }

        HealthCareServiceResponseDTO healthCareServiceResponseDTO = new HealthCareServiceResponseDTO();

        healthCareServiceResponseDTO.setId( healthCareServiceEntity.getId() );
        healthCareServiceResponseDTO.setUuid( healthCareServiceEntity.getUuid() );
        healthCareServiceResponseDTO.setCreationDate( healthCareServiceEntity.getCreationDate() );
        healthCareServiceResponseDTO.setLastModifiedDate( healthCareServiceEntity.getLastModifiedDate() );
        healthCareServiceResponseDTO.setName( healthCareServiceEntity.getName() );
        healthCareServiceResponseDTO.setPrice( healthCareServiceEntity.getPrice() );
        healthCareServiceResponseDTO.setHospitals( hospitalEntityListToHospitalPlainResponseDTOList( healthCareServiceEntity.getHospitals() ) );

        return healthCareServiceResponseDTO;
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

    protected List<AppointmentWithPatientResponseDTO> appointmentEntityListToAppointmentWithPatientResponseDTOList(List<AppointmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentWithPatientResponseDTO> list1 = new ArrayList<AppointmentWithPatientResponseDTO>( list.size() );
        for ( AppointmentEntity appointmentEntity : list ) {
            list1.add( appointmentEntityToAppointmentWithPatientResponseDTO( appointmentEntity ) );
        }

        return list1;
    }

    protected void userRequestDTOToUserEntity(UserRequestDTO userRequestDTO, UserEntity mappingTarget) {
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

    protected HospitalEntity doctorRequestDTOToHospitalEntity(DoctorRequestDTO doctorRequestDTO) {
        if ( doctorRequestDTO == null ) {
            return null;
        }

        HospitalEntity hospitalEntity = new HospitalEntity();

        hospitalEntity.setId( doctorRequestDTO.getHospitalId() );

        return hospitalEntity;
    }

    protected HealthCareServiceEntity doctorRequestDTOToHealthCareServiceEntity(DoctorRequestDTO doctorRequestDTO) {
        if ( doctorRequestDTO == null ) {
            return null;
        }

        HealthCareServiceEntity healthCareServiceEntity = new HealthCareServiceEntity();

        healthCareServiceEntity.setId( doctorRequestDTO.getHealthCareServiceId() );

        return healthCareServiceEntity;
    }

    protected UserEntity userRequestDTOToUserEntity1(UserRequestDTO userRequestDTO) {
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

    protected AppointmentPlainResponseDTO appointmentEntityToAppointmentPlainResponseDTO(AppointmentEntity appointmentEntity) {
        if ( appointmentEntity == null ) {
            return null;
        }

        AppointmentPlainResponseDTO appointmentPlainResponseDTO = new AppointmentPlainResponseDTO();

        appointmentPlainResponseDTO.setId( appointmentEntity.getId() );
        appointmentPlainResponseDTO.setUuid( appointmentEntity.getUuid() );
        appointmentPlainResponseDTO.setCreationDate( appointmentEntity.getCreationDate() );
        appointmentPlainResponseDTO.setLastModifiedDate( appointmentEntity.getLastModifiedDate() );
        appointmentPlainResponseDTO.setAppointmentDate( appointmentEntity.getAppointmentDate() );

        return appointmentPlainResponseDTO;
    }

    protected List<AppointmentPlainResponseDTO> appointmentEntityListToAppointmentPlainResponseDTOList(List<AppointmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentPlainResponseDTO> list1 = new ArrayList<AppointmentPlainResponseDTO>( list.size() );
        for ( AppointmentEntity appointmentEntity : list ) {
            list1.add( appointmentEntityToAppointmentPlainResponseDTO( appointmentEntity ) );
        }

        return list1;
    }
}
