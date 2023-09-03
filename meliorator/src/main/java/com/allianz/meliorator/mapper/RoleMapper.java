package com.allianz.meliorator.mapper;

import com.allianz.meliorator.database.entity.Role;
import com.allianz.meliorator.model.dto.RoleDTO;
import com.allianz.meliorator.model.requestDTO.RoleRequestDTO;
import com.allianz.meliorator.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends IBaseMapper<Role, RoleDTO, RoleRequestDTO> {
}
