package com.allianz.healthtourismagency.mapper;

import com.allianz.healthtourismagency.database.entity.HospitalEntity;
import com.allianz.healthtourismagency.model.HospitalDTO;
import com.allianz.healthtourismagency.model.requestDTO.HospitalRequestDTO;
import com.allianz.healthtourismagency.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HospitalMapper extends IBaseMapper<HospitalEntity, HospitalDTO, HospitalRequestDTO> {

}
