package com.patika.healthtourism.mapper;

import com.patika.healthtourism.database.entity.HospitalEntity;
import com.patika.healthtourism.model.HospitalDTO;
import com.patika.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.patika.healthtourism.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HospitalMapper extends IBaseMapper<HospitalEntity, HospitalDTO, HospitalRequestDTO> {
}
