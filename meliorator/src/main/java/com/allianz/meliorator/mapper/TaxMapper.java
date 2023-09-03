package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Tax;
import com.allianz.meliorator.model.dto.TaxDTO;
import com.allianz.meliorator.model.requestDTO.TaxRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaxMapper extends IBaseMapper<Tax, TaxDTO, TaxRequestDTO> {
}
