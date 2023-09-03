package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.PlanOfFlight;
import com.allianz.meliorator.model.dto.POFDTO;
import com.allianz.meliorator.model.requestDTO.POFReqDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface POFMapper extends IBaseMapper<PlanOfFlight, POFDTO, POFReqDTO> {
}
