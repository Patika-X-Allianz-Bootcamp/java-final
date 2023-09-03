package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.model.requestDTO.PlaneRequestDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T12:58:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class PlaneMapperImpl implements PlaneMapper {

    @Override
    public PlaneResponseDTO entityToResponseDto(PlaneEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PlaneResponseDTO planeResponseDTO = new PlaneResponseDTO();

        planeResponseDTO.setId( entity.getId() );
        planeResponseDTO.setUuid( entity.getUuid() );
        planeResponseDTO.setCreationDate( entity.getCreationDate() );
        planeResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        planeResponseDTO.setName( entity.getName() );
        planeResponseDTO.setSeatCount( entity.getSeatCount() );
        planeResponseDTO.setCity( cityEntityToCityResponseDTO( entity.getCity() ) );

        return planeResponseDTO;
    }

    @Override
    public List<PlaneResponseDTO> entityListToResponseDtoList(List<PlaneEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PlaneResponseDTO> list = new ArrayList<PlaneResponseDTO>( entityList.size() );
        for ( PlaneEntity planeEntity : entityList ) {
            list.add( entityToResponseDto( planeEntity ) );
        }

        return list;
    }

    @Override
    public PlaneEntity updateEntityFromRequestDTO(PlaneRequestDTO requestDTO, PlaneEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setName( requestDTO.getName() );
        entity.setSeatCount( requestDTO.getSeatCount() );

        return entity;
    }

    @Override
    public PlaneEntity requestDtoToEntity(PlaneRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        PlaneEntity planeEntity = new PlaneEntity();

        planeEntity.setCity( planeRequestDTOToCityEntity( requestDTO ) );
        planeEntity.setName( requestDTO.getName() );
        planeEntity.setSeatCount( requestDTO.getSeatCount() );

        return planeEntity;
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

    protected CityEntity planeRequestDTOToCityEntity(PlaneRequestDTO planeRequestDTO) {
        if ( planeRequestDTO == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setId( planeRequestDTO.getCityId() );

        return cityEntity;
    }
}
