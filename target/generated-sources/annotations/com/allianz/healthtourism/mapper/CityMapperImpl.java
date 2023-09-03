package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.model.requestDTO.CityRequestDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T12:58:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class CityMapperImpl implements CityMapper {

    @Override
    public CityEntity requestDtoToEntity(CityRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setName( requestDTO.getName() );
        cityEntity.setCountry( requestDTO.getCountry() );

        return cityEntity;
    }

    @Override
    public CityResponseDTO entityToResponseDto(CityEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CityResponseDTO cityResponseDTO = new CityResponseDTO();

        cityResponseDTO.setId( entity.getId() );
        cityResponseDTO.setUuid( entity.getUuid() );
        cityResponseDTO.setCreationDate( entity.getCreationDate() );
        cityResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        cityResponseDTO.setName( entity.getName() );
        cityResponseDTO.setCountry( entity.getCountry() );

        return cityResponseDTO;
    }

    @Override
    public List<CityResponseDTO> entityListToResponseDtoList(List<CityEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CityResponseDTO> list = new ArrayList<CityResponseDTO>( entityList.size() );
        for ( CityEntity cityEntity : entityList ) {
            list.add( entityToResponseDto( cityEntity ) );
        }

        return list;
    }

    @Override
    public CityEntity updateEntityFromRequestDTO(CityRequestDTO requestDTO, CityEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setName( requestDTO.getName() );
        entity.setCountry( requestDTO.getCountry() );

        return entity;
    }
}
