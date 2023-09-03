package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.HealthCareServiceEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.model.requestDTO.HealthCareServiceRequestDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HealthCareServiceResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HospitalPlainResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T12:58:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class HealthCareServiceMapperImpl implements HealthCareServiceMapper {

    @Override
    public HealthCareServiceEntity requestDtoToEntity(HealthCareServiceRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        HealthCareServiceEntity healthCareServiceEntity = new HealthCareServiceEntity();

        healthCareServiceEntity.setName( requestDTO.getName() );
        healthCareServiceEntity.setPrice( requestDTO.getPrice() );

        return healthCareServiceEntity;
    }

    @Override
    public HealthCareServiceResponseDTO entityToResponseDto(HealthCareServiceEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HealthCareServiceResponseDTO healthCareServiceResponseDTO = new HealthCareServiceResponseDTO();

        healthCareServiceResponseDTO.setId( entity.getId() );
        healthCareServiceResponseDTO.setUuid( entity.getUuid() );
        healthCareServiceResponseDTO.setCreationDate( entity.getCreationDate() );
        healthCareServiceResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        healthCareServiceResponseDTO.setName( entity.getName() );
        healthCareServiceResponseDTO.setPrice( entity.getPrice() );
        healthCareServiceResponseDTO.setHospitals( hospitalEntityListToHospitalPlainResponseDTOList( entity.getHospitals() ) );

        return healthCareServiceResponseDTO;
    }

    @Override
    public List<HealthCareServiceResponseDTO> entityListToResponseDtoList(List<HealthCareServiceEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HealthCareServiceResponseDTO> list = new ArrayList<HealthCareServiceResponseDTO>( entityList.size() );
        for ( HealthCareServiceEntity healthCareServiceEntity : entityList ) {
            list.add( entityToResponseDto( healthCareServiceEntity ) );
        }

        return list;
    }

    @Override
    public HealthCareServiceEntity updateEntityFromRequestDTO(HealthCareServiceRequestDTO requestDTO, HealthCareServiceEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setName( requestDTO.getName() );
        entity.setPrice( requestDTO.getPrice() );

        return entity;
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
}
