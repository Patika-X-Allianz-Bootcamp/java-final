package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.CityEntity;
import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.HospitalEntity;
import com.allianz.healthtourism.model.requestDTO.CityRequestDTO;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorForPatientWithAppointmentResponseDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper extends BaseMapper<DoctorEntity, DoctorResponseDTO, DoctorRequestDTO> {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Override
    @Mapping(source = "hospitalId", target = "hospital.id")
    @Mapping(source = "healthCareServiceId", target = "healthCareService.id")
    DoctorEntity requestDtoToEntity(DoctorRequestDTO requestDTO);

    DoctorForPatientWithAppointmentResponseDTO entityToPatientResponseDto(DoctorEntity entity);
}
