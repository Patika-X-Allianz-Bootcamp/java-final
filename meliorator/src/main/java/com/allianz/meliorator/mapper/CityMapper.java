package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.City;
import com.allianz.meliorator.model.dto.CityDTO;
import com.allianz.meliorator.model.requestDTO.CityRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper extends IBaseMapper<City, CityDTO, CityRequestDTO> {
}
