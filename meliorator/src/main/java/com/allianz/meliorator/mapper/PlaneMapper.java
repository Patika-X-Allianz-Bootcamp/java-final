package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Plane;
import com.allianz.meliorator.model.dto.PlaneDTO;
import com.allianz.meliorator.model.requestDTO.PlaneRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaneMapper extends IBaseMapper<Plane, PlaneDTO, PlaneRequestDTO> {
}
