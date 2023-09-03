package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.MedicalReportEntity;
import com.allianz.healthtourismagency.model.MedicalReportDTO;
import com.allianz.healthtourismagency.model.requestDTO.MedicalReportRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalReportMapper extends IBaseMapper<MedicalReportEntity, MedicalReportDTO, MedicalReportRequestDTO> {

}
