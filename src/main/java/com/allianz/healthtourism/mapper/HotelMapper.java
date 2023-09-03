package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.HealthCareServiceEntity;
import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.model.requestDTO.HealthCareServiceRequestDTO;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.model.responseDTO.HealthCareServiceResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HotelForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HotelResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelMapper extends BaseMapper<HotelEntity, HotelResponseDTO, HotelRequestDTO> {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    @Override
    @Mapping(source = "cityId", target = "city.id")
    @Mapping(source = "roomCount", target = "rooms", ignore = true)
    HotelEntity requestDtoToEntity(HotelRequestDTO requestDTO);


    List<HotelForPatientResponseDTO> entityListToResponseDtoListForPatient (List<HotelEntity> entityList);

}
