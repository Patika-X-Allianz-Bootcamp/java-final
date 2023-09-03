package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.AppointmentEntity;
import com.allianz.healthtourism.database.entity.ExaminationRecordEntity;
import com.allianz.healthtourism.database.entity.PatientEntity;
import com.allianz.healthtourism.model.requestDTO.ExaminationRecordRequestDTO;
import com.allianz.healthtourism.model.responseDTO.AppointmentWithPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationRecordResponseDTO;
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
public class ExaminationRecordMapperImpl implements ExaminationRecordMapper {

    @Override
    public ExaminationRecordResponseDTO entityToResponseDto(ExaminationRecordEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ExaminationRecordResponseDTO examinationRecordResponseDTO = new ExaminationRecordResponseDTO();

        examinationRecordResponseDTO.setId( entity.getId() );
        examinationRecordResponseDTO.setUuid( entity.getUuid() );
        examinationRecordResponseDTO.setCreationDate( entity.getCreationDate() );
        examinationRecordResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        examinationRecordResponseDTO.setNotes( entity.getNotes() );
        examinationRecordResponseDTO.setAppointment( appointmentEntityToAppointmentWithPatientResponseDTO( entity.getAppointment() ) );

        return examinationRecordResponseDTO;
    }

    @Override
    public List<ExaminationRecordResponseDTO> entityListToResponseDtoList(List<ExaminationRecordEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ExaminationRecordResponseDTO> list = new ArrayList<ExaminationRecordResponseDTO>( entityList.size() );
        for ( ExaminationRecordEntity examinationRecordEntity : entityList ) {
            list.add( entityToResponseDto( examinationRecordEntity ) );
        }

        return list;
    }

    @Override
    public ExaminationRecordEntity updateEntityFromRequestDTO(ExaminationRecordRequestDTO requestDTO, ExaminationRecordEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setNotes( requestDTO.getNotes() );

        return entity;
    }

    @Override
    public ExaminationRecordEntity requestDtoToEntity(ExaminationRecordRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        ExaminationRecordEntity examinationRecordEntity = new ExaminationRecordEntity();

        examinationRecordEntity.setAppointment( examinationRecordRequestDTOToAppointmentEntity( requestDTO ) );
        examinationRecordEntity.setNotes( requestDTO.getNotes() );

        return examinationRecordEntity;
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

    protected AppointmentEntity examinationRecordRequestDTOToAppointmentEntity(ExaminationRecordRequestDTO examinationRecordRequestDTO) {
        if ( examinationRecordRequestDTO == null ) {
            return null;
        }

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        appointmentEntity.setId( examinationRecordRequestDTO.getAppointmentId() );

        return appointmentEntity;
    }
}
