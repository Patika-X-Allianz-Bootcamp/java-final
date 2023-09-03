package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.HotelEntity;
import com.demo.medicaltourismapp.model.HotelDTO;
import com.demo.medicaltourismapp.model.PageDTO;
import com.demo.medicaltourismapp.model.requestDTO.HotelRequestDTO;
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
public class HotelMapperImpl implements HotelMapper {

    @Override
    public HotelEntity dtoToEntity(HotelDTO dto) {
        if ( dto == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId( dto.getId() );
        hotelEntity.setUuid( dto.getUuid() );
        hotelEntity.setCreationDate( dto.getCreationDate() );
        hotelEntity.setUpdatedDate( dto.getUpdatedDate() );
        hotelEntity.setName( dto.getName() );
        hotelEntity.setCapacity( dto.getCapacity() );
        hotelEntity.setCity( dto.getCity() );

        return hotelEntity;
    }

    @Override
    public HotelDTO entityToDto(HotelEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HotelDTO hotelDTO = new HotelDTO();

        hotelDTO.setId( entity.getId() );
        hotelDTO.setUuid( entity.getUuid() );
        hotelDTO.setCreationDate( entity.getCreationDate() );
        hotelDTO.setUpdatedDate( entity.getUpdatedDate() );
        hotelDTO.setName( entity.getName() );
        hotelDTO.setCapacity( entity.getCapacity() );
        hotelDTO.setCity( entity.getCity() );

        return hotelDTO;
    }

    @Override
    public HotelEntity requestDtoToEntity(HotelRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId( requestDTO.getId() );
        hotelEntity.setUuid( requestDTO.getUuid() );
        hotelEntity.setCreationDate( requestDTO.getCreationDate() );
        hotelEntity.setUpdatedDate( requestDTO.getUpdatedDate() );
        hotelEntity.setName( requestDTO.getName() );
        hotelEntity.setCapacity( requestDTO.getCapacity() );
        hotelEntity.setCity( requestDTO.getCity() );

        return hotelEntity;
    }

    @Override
    public HotelRequestDTO entityToRequestDto(HotelEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HotelRequestDTO hotelRequestDTO = new HotelRequestDTO();

        hotelRequestDTO.setId( entity.getId() );
        hotelRequestDTO.setUuid( entity.getUuid() );
        hotelRequestDTO.setCreationDate( entity.getCreationDate() );
        hotelRequestDTO.setUpdatedDate( entity.getUpdatedDate() );
        hotelRequestDTO.setName( entity.getName() );
        hotelRequestDTO.setCapacity( entity.getCapacity() );
        hotelRequestDTO.setCity( entity.getCity() );

        return hotelRequestDTO;
    }

    @Override
    public List<HotelEntity> requestDtoListToEntityList(List<HotelRequestDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<HotelEntity> list = new ArrayList<HotelEntity>( dtoList.size() );
        for ( HotelRequestDTO hotelRequestDTO : dtoList ) {
            list.add( requestDtoToEntity( hotelRequestDTO ) );
        }

        return list;
    }

    @Override
    public List<HotelRequestDTO> entityListToRequestDtoList(List<HotelEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HotelRequestDTO> list = new ArrayList<HotelRequestDTO>( entityList.size() );
        for ( HotelEntity hotelEntity : entityList ) {
            list.add( entityToRequestDto( hotelEntity ) );
        }

        return list;
    }

    @Override
    public List<HotelEntity> dtoListToEntityList(List<HotelDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<HotelEntity> list = new ArrayList<HotelEntity>( dtoList.size() );
        for ( HotelDTO hotelDTO : dtoList ) {
            list.add( dtoToEntity( hotelDTO ) );
        }

        return list;
    }

    @Override
    public List<HotelDTO> entityListToDtoList(List<HotelEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HotelDTO> list = new ArrayList<HotelDTO>( entityList.size() );
        for ( HotelEntity hotelEntity : entityList ) {
            list.add( entityToDto( hotelEntity ) );
        }

        return list;
    }

    @Override
    public HotelEntity requestDtoToExistEntity(HotelRequestDTO requestDTO, HotelEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setId( requestDTO.getId() );
        entity.setUuid( requestDTO.getUuid() );
        entity.setCreationDate( requestDTO.getCreationDate() );
        entity.setUpdatedDate( requestDTO.getUpdatedDate() );
        entity.setName( requestDTO.getName() );
        entity.setCapacity( requestDTO.getCapacity() );
        entity.setCity( requestDTO.getCity() );

        return entity;
    }

    @Override
    public PageDTO<HotelDTO> pageEntityToPageDTO(Page<HotelEntity> entityPage) {
        if ( entityPage == null ) {
            return null;
        }

        PageDTO<HotelDTO> pageDTO = new PageDTO<HotelDTO>();

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
