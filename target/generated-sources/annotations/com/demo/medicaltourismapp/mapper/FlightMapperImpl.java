package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.FlightEntity;
import com.demo.medicaltourismapp.model.FlightDTO;
import com.demo.medicaltourismapp.model.PageDTO;
import com.demo.medicaltourismapp.model.requestDTO.FlightRequestDTO;
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
public class FlightMapperImpl implements FlightMapper {

    @Override
    public FlightEntity dtoToEntity(FlightDTO dto) {
        if ( dto == null ) {
            return null;
        }

        FlightEntity flightEntity = new FlightEntity();

        flightEntity.setId( dto.getId() );
        flightEntity.setUuid( dto.getUuid() );
        flightEntity.setCreationDate( dto.getCreationDate() );
        flightEntity.setUpdatedDate( dto.getUpdatedDate() );
        flightEntity.setFlightNo( dto.getFlightNo() );
        flightEntity.setCapacity( dto.getCapacity() );
        flightEntity.setFromCity( dto.getFromCity() );
        flightEntity.setToCity( dto.getToCity() );

        return flightEntity;
    }

    @Override
    public FlightDTO entityToDto(FlightEntity entity) {
        if ( entity == null ) {
            return null;
        }

        FlightDTO flightDTO = new FlightDTO();

        flightDTO.setId( entity.getId() );
        flightDTO.setUuid( entity.getUuid() );
        flightDTO.setCreationDate( entity.getCreationDate() );
        flightDTO.setUpdatedDate( entity.getUpdatedDate() );
        flightDTO.setFlightNo( entity.getFlightNo() );
        flightDTO.setCapacity( entity.getCapacity() );
        flightDTO.setFromCity( entity.getFromCity() );
        flightDTO.setToCity( entity.getToCity() );

        return flightDTO;
    }

    @Override
    public FlightEntity requestDtoToEntity(FlightRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        FlightEntity flightEntity = new FlightEntity();

        flightEntity.setId( requestDTO.getId() );
        flightEntity.setUuid( requestDTO.getUuid() );
        flightEntity.setCreationDate( requestDTO.getCreationDate() );
        flightEntity.setUpdatedDate( requestDTO.getUpdatedDate() );
        flightEntity.setFlightNo( requestDTO.getFlightNo() );
        flightEntity.setCapacity( requestDTO.getCapacity() );
        flightEntity.setFromCity( requestDTO.getFromCity() );
        flightEntity.setToCity( requestDTO.getToCity() );

        return flightEntity;
    }

    @Override
    public FlightRequestDTO entityToRequestDto(FlightEntity entity) {
        if ( entity == null ) {
            return null;
        }

        FlightRequestDTO flightRequestDTO = new FlightRequestDTO();

        flightRequestDTO.setId( entity.getId() );
        flightRequestDTO.setUuid( entity.getUuid() );
        flightRequestDTO.setCreationDate( entity.getCreationDate() );
        flightRequestDTO.setUpdatedDate( entity.getUpdatedDate() );
        flightRequestDTO.setFlightNo( entity.getFlightNo() );
        flightRequestDTO.setCapacity( entity.getCapacity() );
        flightRequestDTO.setFromCity( entity.getFromCity() );
        flightRequestDTO.setToCity( entity.getToCity() );

        return flightRequestDTO;
    }

    @Override
    public List<FlightEntity> requestDtoListToEntityList(List<FlightRequestDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<FlightEntity> list = new ArrayList<FlightEntity>( dtoList.size() );
        for ( FlightRequestDTO flightRequestDTO : dtoList ) {
            list.add( requestDtoToEntity( flightRequestDTO ) );
        }

        return list;
    }

    @Override
    public List<FlightRequestDTO> entityListToRequestDtoList(List<FlightEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FlightRequestDTO> list = new ArrayList<FlightRequestDTO>( entityList.size() );
        for ( FlightEntity flightEntity : entityList ) {
            list.add( entityToRequestDto( flightEntity ) );
        }

        return list;
    }

    @Override
    public List<FlightEntity> dtoListToEntityList(List<FlightDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<FlightEntity> list = new ArrayList<FlightEntity>( dtoList.size() );
        for ( FlightDTO flightDTO : dtoList ) {
            list.add( dtoToEntity( flightDTO ) );
        }

        return list;
    }

    @Override
    public List<FlightDTO> entityListToDtoList(List<FlightEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FlightDTO> list = new ArrayList<FlightDTO>( entityList.size() );
        for ( FlightEntity flightEntity : entityList ) {
            list.add( entityToDto( flightEntity ) );
        }

        return list;
    }

    @Override
    public FlightEntity requestDtoToExistEntity(FlightRequestDTO requestDTO, FlightEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setId( requestDTO.getId() );
        entity.setUuid( requestDTO.getUuid() );
        entity.setCreationDate( requestDTO.getCreationDate() );
        entity.setUpdatedDate( requestDTO.getUpdatedDate() );
        entity.setFlightNo( requestDTO.getFlightNo() );
        entity.setCapacity( requestDTO.getCapacity() );
        entity.setFromCity( requestDTO.getFromCity() );
        entity.setToCity( requestDTO.getToCity() );

        return entity;
    }

    @Override
    public PageDTO<FlightDTO> pageEntityToPageDTO(Page<FlightEntity> entityPage) {
        if ( entityPage == null ) {
            return null;
        }

        PageDTO<FlightDTO> pageDTO = new PageDTO<FlightDTO>();

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
