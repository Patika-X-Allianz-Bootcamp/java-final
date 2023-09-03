package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Country;
import com.allianz.meliorator.model.dto.CountryDTO;
import com.allianz.meliorator.model.requestDTO.CountryRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper extends IBaseMapper<Country, CountryDTO, CountryRequestDTO> {
}
