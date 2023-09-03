package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Address;
import com.allianz.meliorator.model.dto.AddressDTO;
import com.allianz.meliorator.model.requestDTO.AddressRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends IBaseMapper<Address, AddressDTO, AddressRequestDTO> {
}
