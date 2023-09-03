package com.burakcanciftci.healthtourism.util;

import com.burakcanciftci.healthtourism.database.entity.UserEntity;
import com.burakcanciftci.healthtourism.model.UserRegistrationDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.LoginRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

// MapStruct example
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "roles", ignore = true)
    UserEntity dtoToEntity(UserRegistrationDTO dto);

    LoginRequestDTO entityToLoginDto(UserEntity entity);
}