package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.BookingEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.model.requestDTO.BookingRequestDTO;
import com.allianz.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourism.model.responseDTO.BookingResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HospitalForPatientResponseDTO;
import com.allianz.healthtourism.model.responseDTO.HospitalResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HospitalMapper extends BaseMapper<HospitalEntity, HospitalResponseDTO, HospitalRequestDTO> {
    HospitalMapper INSTANCE = Mappers.getMapper(HospitalMapper.class);

    @Override
    @Mapping(source = "cityId", target = "city.id")
    HospitalEntity requestDtoToEntity(HospitalRequestDTO requestDTO);

    HospitalForPatientResponseDTO entityToPatientResponseDto(HospitalEntity entity);
}
