package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Users;
import com.allianz.meliorator.model.dto.UsersDTO;
import com.allianz.meliorator.model.requestDTO.UsersRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper extends IBaseMapper<Users, UsersDTO, UsersRequestDTO> {
}
