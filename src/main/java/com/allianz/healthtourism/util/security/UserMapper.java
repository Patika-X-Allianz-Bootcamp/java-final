package com.allianz.healthtourism.util.security;

import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity, UserResponseDTO, UserRequestDTO> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Override
//    @Mapping(source = "appId", target = "app.id")
//    UserEntity requestDtoToEntity(UserRequestDTO requestDTO);
}
