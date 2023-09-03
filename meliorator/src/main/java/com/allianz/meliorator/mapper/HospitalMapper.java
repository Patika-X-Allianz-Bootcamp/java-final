package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Hospital;
import com.allianz.meliorator.model.dto.HospitalDTO;
import com.allianz.meliorator.model.requestDTO.HospitalRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HospitalMapper extends IBaseMapper<Hospital, HospitalDTO, HospitalRequestDTO> {
}
