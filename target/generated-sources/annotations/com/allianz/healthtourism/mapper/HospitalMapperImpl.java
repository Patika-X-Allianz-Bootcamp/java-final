package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.ExaminationRecordEntity;
import com.allianz.healthtourism.database.entity.HealthCareServiceEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentWithPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationRecordResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HealthCareServiceResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HospitalForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HospitalResponseDTO;
import com.allianz.healthtourism.model.responseDTO.PatientWithExaminationRecordResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.DoctorPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.ExaminationRecordPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HealthCareServicePlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HospitalPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.UserPlainResponseDTO;
import com.allianz.healthtourism.util.security.RoleEntity;
import com.allianz.healthtourism.util.security.RoleResponseDTO;
import com.allianz.healthtourism.util.security.UserEntity;
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
public class HospitalMapperImpl implements HospitalMapper {

    @Override
    public HospitalResponseDTO entityToResponseDto(HospitalEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HospitalResponseDTO hospitalResponseDTO = new HospitalResponseDTO();

        hospitalResponseDTO.setId( entity.getId() );
        hospitalResponseDTO.setUuid( entity.getUuid() );
        hospitalResponseDTO.setCreationDate( entity.getCreationDate() );
        hospitalResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        hospitalResponseDTO.setName( entity.getName() );
        hospitalResponseDTO.setCity( cityEntityToCityResponseDTO( entity.getCity() ) );
        hospitalResponseDTO.setExaminationRecords( examinationRecordEntityListToExaminationRecordPlainResponseDTOList( entity.getExaminationRecords() ) );
        hospitalResponseDTO.setPatients( patientEntityListToPatientWithExaminationRecordResponseDTOList( entity.getPatients() ) );
        hospitalResponseDTO.setDoctors( doctorEntityListToDoctorPlainResponseDTOList( entity.getDoctors() ) );
        hospitalResponseDTO.setHealthCareServices( healthCareServiceEntityListToHealthCareServiceResponseDTOList( entity.getHealthCareServices() ) );

        return hospitalResponseDTO;
    }

    @Override
    public List<HospitalResponseDTO> entityListToResponseDtoList(List<HospitalEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HospitalResponseDTO> list = new ArrayList<HospitalResponseDTO>( entityList.size() );
        for ( HospitalEntity hospitalEntity : entityList ) {
            list.add( entityToResponseDto( hospitalEntity ) );
        }

        return list;
    }

    @Override
    public HospitalEntity updateEntityFromRequestDTO(HospitalRequestDTO requestDTO, HospitalEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setName( requestDTO.getName() );

        return entity;
    }

    @Override
    public HospitalEntity requestDtoToEntity(HospitalRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        HospitalEntity hospitalEntity = new HospitalEntity();

        hospitalEntity.setCity( hospitalRequestDTOToCityEntity( requestDTO ) );
        hospitalEntity.setName( requestDTO.getName() );

        return hospitalEntity;
    }

    @Override
    public HospitalForPatientResponseDTO entityToPatientResponseDto(HospitalEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HospitalForPatientResponseDTO hospitalForPatientResponseDTO = new HospitalForPatientResponseDTO();

        hospitalForPatientResponseDTO.setId( entity.getId() );
        hospitalForPatientResponseDTO.setUuid( entity.getUuid() );
        hospitalForPatientResponseDTO.setCreationDate( entity.getCreationDate() );
        hospitalForPatientResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        hospitalForPatientResponseDTO.setName( entity.getName() );
        hospitalForPatientResponseDTO.setCity( cityEntityToCityResponseDTO( entity.getCity() ) );
        hospitalForPatientResponseDTO.setDoctors( doctorEntityListToDoctorForPatientResponseDTOList( entity.getDoctors() ) );
        hospitalForPatientResponseDTO.setHealthCareServices( healthCareServiceEntityListToHealthCareServicePlainResponseDTOList( entity.getHealthCareServices() ) );

        return hospitalForPatientResponseDTO;
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

    protected ExaminationRecordPlainResponseDTO examinationRecordEntityToExaminationRecordPlainResponseDTO(ExaminationRecordEntity examinationRecordEntity) {
        if ( examinationRecordEntity == null ) {
            return null;
        }

        ExaminationRecordPlainResponseDTO examinationRecordPlainResponseDTO = new ExaminationRecordPlainResponseDTO();

        examinationRecordPlainResponseDTO.setId( examinationRecordEntity.getId() );
        examinationRecordPlainResponseDTO.setUuid( examinationRecordEntity.getUuid() );
        examinationRecordPlainResponseDTO.setCreationDate( examinationRecordEntity.getCreationDate() );
        examinationRecordPlainResponseDTO.setLastModifiedDate( examinationRecordEntity.getLastModifiedDate() );
        examinationRecordPlainResponseDTO.setNotes( examinationRecordEntity.getNotes() );

        return examinationRecordPlainResponseDTO;
    }

    protected List<ExaminationRecordPlainResponseDTO> examinationRecordEntityListToExaminationRecordPlainResponseDTOList(List<ExaminationRecordEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ExaminationRecordPlainResponseDTO> list1 = new ArrayList<ExaminationRecordPlainResponseDTO>( list.size() );
        for ( ExaminationRecordEntity examinationRecordEntity : list ) {
            list1.add( examinationRecordEntityToExaminationRecordPlainResponseDTO( examinationRecordEntity ) );
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

    protected PatientWithExaminationRecordResponseDTO patientEntityToPatientWithExaminationRecordResponseDTO(PatientEntity patientEntity) {
        if ( patientEntity == null ) {
            return null;
        }

        PatientWithExaminationRecordResponseDTO patientWithExaminationRecordResponseDTO = new PatientWithExaminationRecordResponseDTO();

        patientWithExaminationRecordResponseDTO.setId( patientEntity.getId() );
        patientWithExaminationRecordResponseDTO.setUuid( patientEntity.getUuid() );
        patientWithExaminationRecordResponseDTO.setCreationDate( patientEntity.getCreationDate() );
        patientWithExaminationRecordResponseDTO.setLastModifiedDate( patientEntity.getLastModifiedDate() );
        patientWithExaminationRecordResponseDTO.setUser( userEntityToUserResponseDTO( patientEntity.getUser() ) );
        patientWithExaminationRecordResponseDTO.setExaminationRecords( examinationRecordEntityListToExaminationRecordResponseDTOList( patientEntity.getExaminationRecords() ) );

        return patientWithExaminationRecordResponseDTO;
    }

    protected List<PatientWithExaminationRecordResponseDTO> patientEntityListToPatientWithExaminationRecordResponseDTOList(List<PatientEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PatientWithExaminationRecordResponseDTO> list1 = new ArrayList<PatientWithExaminationRecordResponseDTO>( list.size() );
        for ( PatientEntity patientEntity : list ) {
            list1.add( patientEntityToPatientWithExaminationRecordResponseDTO( patientEntity ) );
        }

        return list1;
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

    protected List<DoctorPlainResponseDTO> doctorEntityListToDoctorPlainResponseDTOList(List<DoctorEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<DoctorPlainResponseDTO> list1 = new ArrayList<DoctorPlainResponseDTO>( list.size() );
        for ( DoctorEntity doctorEntity : list ) {
            list1.add( doctorEntityToDoctorPlainResponseDTO( doctorEntity ) );
        }

        return list1;
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

    protected List<HealthCareServiceResponseDTO> healthCareServiceEntityListToHealthCareServiceResponseDTOList(List<HealthCareServiceEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<HealthCareServiceResponseDTO> list1 = new ArrayList<HealthCareServiceResponseDTO>( list.size() );
        for ( HealthCareServiceEntity healthCareServiceEntity : list ) {
            list1.add( healthCareServiceEntityToHealthCareServiceResponseDTO( healthCareServiceEntity ) );
        }

        return list1;
    }

    protected CityEntity hospitalRequestDTOToCityEntity(HospitalRequestDTO hospitalRequestDTO) {
        if ( hospitalRequestDTO == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setId( hospitalRequestDTO.getCityId() );

        return cityEntity;
    }

    protected DoctorForPatientResponseDTO doctorEntityToDoctorForPatientResponseDTO(DoctorEntity doctorEntity) {
        if ( doctorEntity == null ) {
            return null;
        }

        DoctorForPatientResponseDTO doctorForPatientResponseDTO = new DoctorForPatientResponseDTO();

        doctorForPatientResponseDTO.setId( doctorEntity.getId() );
        doctorForPatientResponseDTO.setUuid( doctorEntity.getUuid() );
        doctorForPatientResponseDTO.setCreationDate( doctorEntity.getCreationDate() );
        doctorForPatientResponseDTO.setLastModifiedDate( doctorEntity.getLastModifiedDate() );
        doctorForPatientResponseDTO.setUser( userEntityToUserPlainResponseDTO( doctorEntity.getUser() ) );
        doctorForPatientResponseDTO.setHealthCareService( healthCareServiceEntityToHealthCareServiceResponseDTO( doctorEntity.getHealthCareService() ) );

        return doctorForPatientResponseDTO;
    }

    protected List<DoctorForPatientResponseDTO> doctorEntityListToDoctorForPatientResponseDTOList(List<DoctorEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<DoctorForPatientResponseDTO> list1 = new ArrayList<DoctorForPatientResponseDTO>( list.size() );
        for ( DoctorEntity doctorEntity : list ) {
            list1.add( doctorEntityToDoctorForPatientResponseDTO( doctorEntity ) );
        }

        return list1;
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

    protected List<HealthCareServicePlainResponseDTO> healthCareServiceEntityListToHealthCareServicePlainResponseDTOList(List<HealthCareServiceEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<HealthCareServicePlainResponseDTO> list1 = new ArrayList<HealthCareServicePlainResponseDTO>( list.size() );
        for ( HealthCareServiceEntity healthCareServiceEntity : list ) {
            list1.add( healthCareServiceEntityToHealthCareServicePlainResponseDTO( healthCareServiceEntity ) );
        }

        return list1;
    }
}
