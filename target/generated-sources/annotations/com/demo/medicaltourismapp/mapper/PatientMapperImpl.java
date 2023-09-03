package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.AppointmentEntity;
import com.demo.medicaltourismapp.database.entity.PatientEntity;
import com.demo.medicaltourismapp.model.PageDTO;
import com.demo.medicaltourismapp.model.PatientDTO;
import com.demo.medicaltourismapp.model.requestDTO.PatientRequestDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T21:56:59+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8 (JetBrains s.r.o.)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientEntity dtoToEntity(PatientDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId( dto.getId() );
        patientEntity.setUuid( dto.getUuid() );
        patientEntity.setCreationDate( dto.getCreationDate() );
        patientEntity.setUpdatedDate( dto.getUpdatedDate() );
        patientEntity.setName( dto.getName() );
        List<AppointmentEntity> list = dto.getAppointmentList();
        if ( list != null ) {
            patientEntity.setAppointmentList( new ArrayList<AppointmentEntity>( list ) );
        }
        patientEntity.setSessionActive( dto.isSessionActive() );

        return patientEntity;
    }

    @Override
    public PatientDTO entityToDto(PatientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();

        patientDTO.setId( entity.getId() );
        patientDTO.setUuid( entity.getUuid() );
        patientDTO.setCreationDate( entity.getCreationDate() );
        patientDTO.setUpdatedDate( entity.getUpdatedDate() );
        patientDTO.setName( entity.getName() );
        List<AppointmentEntity> list = entity.getAppointmentList();
        if ( list != null ) {
            patientDTO.setAppointmentList( new ArrayList<AppointmentEntity>( list ) );
        }
        patientDTO.setSessionActive( entity.isSessionActive() );

        return patientDTO;
    }

    @Override
    public PatientEntity requestDtoToEntity(PatientRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId( requestDTO.getId() );
        patientEntity.setUuid( requestDTO.getUuid() );
        patientEntity.setCreationDate( requestDTO.getCreationDate() );
        patientEntity.setUpdatedDate( requestDTO.getUpdatedDate() );
        patientEntity.setName( requestDTO.getName() );
        List<AppointmentEntity> list = requestDTO.getAppointmentList();
        if ( list != null ) {
            patientEntity.setAppointmentList( new ArrayList<AppointmentEntity>( list ) );
        }
        patientEntity.setSessionActive( requestDTO.isSessionActive() );

        return patientEntity;
    }

    @Override
    public PatientRequestDTO entityToRequestDto(PatientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PatientRequestDTO patientRequestDTO = new PatientRequestDTO();

        patientRequestDTO.setId( entity.getId() );
        patientRequestDTO.setUuid( entity.getUuid() );
        patientRequestDTO.setCreationDate( entity.getCreationDate() );
        patientRequestDTO.setUpdatedDate( entity.getUpdatedDate() );
        patientRequestDTO.setName( entity.getName() );
        List<AppointmentEntity> list = entity.getAppointmentList();
        if ( list != null ) {
            patientRequestDTO.setAppointmentList( new ArrayList<AppointmentEntity>( list ) );
        }
        patientRequestDTO.setSessionActive( entity.isSessionActive() );

        return patientRequestDTO;
    }

    @Override
    public List<PatientEntity> requestDtoListToEntityList(List<PatientRequestDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<PatientEntity> list = new ArrayList<PatientEntity>( dtoList.size() );
        for ( PatientRequestDTO patientRequestDTO : dtoList ) {
            list.add( requestDtoToEntity( patientRequestDTO ) );
        }

        return list;
    }

    @Override
    public List<PatientRequestDTO> entityListToRequestDtoList(List<PatientEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PatientRequestDTO> list = new ArrayList<PatientRequestDTO>( entityList.size() );
        for ( PatientEntity patientEntity : entityList ) {
            list.add( entityToRequestDto( patientEntity ) );
        }

        return list;
    }

    @Override
    public List<PatientEntity> dtoListToEntityList(List<PatientDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<PatientEntity> list = new ArrayList<PatientEntity>( dtoList.size() );
        for ( PatientDTO patientDTO : dtoList ) {
            list.add( dtoToEntity( patientDTO ) );
        }

        return list;
    }

    @Override
    public List<PatientDTO> entityListToDtoList(List<PatientEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PatientDTO> list = new ArrayList<PatientDTO>( entityList.size() );
        for ( PatientEntity patientEntity : entityList ) {
            list.add( entityToDto( patientEntity ) );
        }

        return list;
    }

    @Override
    public PatientEntity requestDtoToExistEntity(PatientRequestDTO requestDTO, PatientEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setId( requestDTO.getId() );
        entity.setUuid( requestDTO.getUuid() );
        entity.setCreationDate( requestDTO.getCreationDate() );
        entity.setUpdatedDate( requestDTO.getUpdatedDate() );
        entity.setName( requestDTO.getName() );
        if ( entity.getAppointmentList() != null ) {
            List<AppointmentEntity> list = requestDTO.getAppointmentList();
            if ( list != null ) {
                entity.getAppointmentList().clear();
                entity.getAppointmentList().addAll( list );
            }
            else {
                entity.setAppointmentList( null );
            }
        }
        else {
            List<AppointmentEntity> list = requestDTO.getAppointmentList();
            if ( list != null ) {
                entity.setAppointmentList( new ArrayList<AppointmentEntity>( list ) );
            }
        }
        entity.setSessionActive( requestDTO.isSessionActive() );

        return entity;
    }

    @Override
    public PageDTO<PatientDTO> pageEntityToPageDTO(Page<PatientEntity> entityPage) {
        if ( entityPage == null ) {
            return null;
        }

        PageDTO<PatientDTO> pageDTO = new PageDTO<PatientDTO>();

        pageDTO.setNumber( entityPage.getNumber() );
        pageDTO.setSize( entityPage.getSize() );
        pageDTO.setTotalPages( entityPage.getTotalPages() );
        pageDTO.setTotalElements( entityPage.getTotalElements() );
        if ( entityPage.hasContent() ) {
            pageDTO.setContent( entityListToDtoList( entityPage.getContent() ) );
        }
        pageDTO.setSort( entityPage.getSort() );

        return pageDTO;
    }
}
