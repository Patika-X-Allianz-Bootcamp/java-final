package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.HospitalEntity;
import com.demo.medicaltourismapp.model.HospitalDTO;
import com.demo.medicaltourismapp.model.requestDTO.HospitalRequestDTO;
import com.demo.medicaltourismapp.util.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HospitalMapper extends BaseMapper<HospitalEntity, HospitalDTO, HospitalRequestDTO> {
}
