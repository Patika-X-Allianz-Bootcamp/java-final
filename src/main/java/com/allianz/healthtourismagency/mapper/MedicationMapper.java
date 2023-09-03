package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.MedicationEntity;
import com.allianz.healthtourismagency.model.MedicationDTO;
import com.allianz.healthtourismagency.model.requestDTO.MedicationRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicationMapper extends IBaseMapper<MedicationEntity, MedicationDTO, MedicationRequestDTO> {

}
