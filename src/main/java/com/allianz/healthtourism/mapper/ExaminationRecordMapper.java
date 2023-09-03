package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.DoctorEntity;
import com.allianz.healthtourism.database.entity.ExaminationRecordEntity;
import com.allianz.healthtourism.database.entity.HotelEntity;
import com.allianz.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.healthtourism.model.requestDTO.ExaminationRecordRequestDTO;
import com.allianz.healthtourism.model.requestDTO.HotelRequestDTO;
import com.allianz.healthtourism.model.responseDTO.DoctorResponseDTO;
import com.allianz.healthtourism.model.responseDTO.ExaminationRecordResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExaminationRecordMapper extends BaseMapper<ExaminationRecordEntity, ExaminationRecordResponseDTO, ExaminationRecordRequestDTO> {
    ExaminationRecordMapper INSTANCE = Mappers.getMapper(ExaminationRecordMapper.class);
    @Override
    @Mapping(source = "appointmentId", target = "appointment.id")
    ExaminationRecordEntity requestDtoToEntity(ExaminationRecordRequestDTO requestDTO);
}
