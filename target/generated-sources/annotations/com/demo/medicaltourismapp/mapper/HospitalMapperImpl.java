package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.DoctorEntity;
import com.demo.medicaltourismapp.database.entity.HospitalEntity;
import com.demo.medicaltourismapp.model.HospitalDTO;
import com.demo.medicaltourismapp.model.PageDTO;
import com.demo.medicaltourismapp.model.requestDTO.HospitalRequestDTO;
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
public class HospitalMapperImpl implements HospitalMapper {

    @Override
    public HospitalEntity dtoToEntity(HospitalDTO dto) {
        if ( dto == null ) {
            return null;
        }

        HospitalEntity hospitalEntity = new HospitalEntity();

        hospitalEntity.setId( dto.getId() );
        hospitalEntity.setUuid( dto.getUuid() );
        hospitalEntity.setCreationDate( dto.getCreationDate() );
        hospitalEntity.setUpdatedDate( dto.getUpdatedDate() );
        hospitalEntity.setName( dto.getName() );
        List<DoctorEntity> list = dto.getDoctorList();
        if ( list != null ) {
            hospitalEntity.setDoctorList( new ArrayList<DoctorEntity>( list ) );
        }
        hospitalEntity.setCity( dto.getCity() );

        return hospitalEntity;
    }

    @Override
    public HospitalDTO entityToDto(HospitalEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HospitalDTO hospitalDTO = new HospitalDTO();

        hospitalDTO.setId( entity.getId() );
        hospitalDTO.setUuid( entity.getUuid() );
        hospitalDTO.setCreationDate( entity.getCreationDate() );
        hospitalDTO.setUpdatedDate( entity.getUpdatedDate() );
        hospitalDTO.setName( entity.getName() );
        hospitalDTO.setCity( entity.getCity() );
        List<DoctorEntity> list = entity.getDoctorList();
        if ( list != null ) {
            hospitalDTO.setDoctorList( new ArrayList<DoctorEntity>( list ) );
        }

        return hospitalDTO;
    }

    @Override
    public HospitalEntity requestDtoToEntity(HospitalRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        HospitalEntity hospitalEntity = new HospitalEntity();

        hospitalEntity.setId( requestDTO.getId() );
        hospitalEntity.setUuid( requestDTO.getUuid() );
        hospitalEntity.setCreationDate( requestDTO.getCreationDate() );
        hospitalEntity.setUpdatedDate( requestDTO.getUpdatedDate() );
        hospitalEntity.setName( requestDTO.getName() );
        List<DoctorEntity> list = requestDTO.getDoctorList();
        if ( list != null ) {
            hospitalEntity.setDoctorList( new ArrayList<DoctorEntity>( list ) );
        }
        hospitalEntity.setCity( requestDTO.getCity() );

        return hospitalEntity;
    }

    @Override
    public HospitalRequestDTO entityToRequestDto(HospitalEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HospitalRequestDTO hospitalRequestDTO = new HospitalRequestDTO();

        hospitalRequestDTO.setId( entity.getId() );
        hospitalRequestDTO.setUuid( entity.getUuid() );
        hospitalRequestDTO.setCreationDate( entity.getCreationDate() );
        hospitalRequestDTO.setUpdatedDate( entity.getUpdatedDate() );
        hospitalRequestDTO.setName( entity.getName() );
        hospitalRequestDTO.setCity( entity.getCity() );
        List<DoctorEntity> list = entity.getDoctorList();
        if ( list != null ) {
            hospitalRequestDTO.setDoctorList( new ArrayList<DoctorEntity>( list ) );
        }

        return hospitalRequestDTO;
    }

    @Override
    public List<HospitalEntity> requestDtoListToEntityList(List<HospitalRequestDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<HospitalEntity> list = new ArrayList<HospitalEntity>( dtoList.size() );
        for ( HospitalRequestDTO hospitalRequestDTO : dtoList ) {
            list.add( requestDtoToEntity( hospitalRequestDTO ) );
        }

        return list;
    }

    @Override
    public List<HospitalRequestDTO> entityListToRequestDtoList(List<HospitalEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HospitalRequestDTO> list = new ArrayList<HospitalRequestDTO>( entityList.size() );
        for ( HospitalEntity hospitalEntity : entityList ) {
            list.add( entityToRequestDto( hospitalEntity ) );
        }

        return list;
    }

    @Override
    public List<HospitalEntity> dtoListToEntityList(List<HospitalDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<HospitalEntity> list = new ArrayList<HospitalEntity>( dtoList.size() );
        for ( HospitalDTO hospitalDTO : dtoList ) {
            list.add( dtoToEntity( hospitalDTO ) );
        }

        return list;
    }

    @Override
    public List<HospitalDTO> entityListToDtoList(List<HospitalEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HospitalDTO> list = new ArrayList<HospitalDTO>( entityList.size() );
        for ( HospitalEntity hospitalEntity : entityList ) {
            list.add( entityToDto( hospitalEntity ) );
        }

        return list;
    }

    @Override
    public HospitalEntity requestDtoToExistEntity(HospitalRequestDTO requestDTO, HospitalEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setId( requestDTO.getId() );
        entity.setUuid( requestDTO.getUuid() );
        entity.setCreationDate( requestDTO.getCreationDate() );
        entity.setUpdatedDate( requestDTO.getUpdatedDate() );
        entity.setName( requestDTO.getName() );
        if ( entity.getDoctorList() != null ) {
            List<DoctorEntity> list = requestDTO.getDoctorList();
            if ( list != null ) {
                entity.getDoctorList().clear();
                entity.getDoctorList().addAll( list );
            }
            else {
                entity.setDoctorList( null );
            }
        }
        else {
            List<DoctorEntity> list = requestDTO.getDoctorList();
            if ( list != null ) {
                entity.setDoctorList( new ArrayList<DoctorEntity>( list ) );
            }
        }
        entity.setCity( requestDTO.getCity() );

        return entity;
    }

    @Override
    public PageDTO<HospitalDTO> pageEntityToPageDTO(Page<HospitalEntity> entityPage) {
        if ( entityPage == null ) {
            return null;
        }

        PageDTO<HospitalDTO> pageDTO = new PageDTO<HospitalDTO>();

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
