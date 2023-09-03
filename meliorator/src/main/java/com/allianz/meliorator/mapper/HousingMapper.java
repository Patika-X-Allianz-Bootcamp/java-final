package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Housing;
import com.allianz.meliorator.model.dto.HousingDTO;
import com.allianz.meliorator.model.requestDTO.HospitalRequestDTO;
import com.allianz.meliorator.model.requestDTO.HousingRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HousingMapper extends IBaseMapper<Housing, HousingDTO, HousingRequestDTO> {
}
