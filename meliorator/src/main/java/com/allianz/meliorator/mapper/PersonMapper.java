package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Person;
import com.allianz.meliorator.model.dto.PersonDTO;
import com.allianz.meliorator.model.requestDTO.PersonRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends IBaseMapper<Person, PersonDTO, PersonRequestDTO> {
}
