package com.patika.healthtourism.mapper;

import com.patika.healthtourism.database.entity.UserEntity;
import com.patika.healthtourism.model.UserDTO;
import com.patika.healthtourism.model.requestDTO.UserRegisterRequestDTO;
import com.patika.healthtourism.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends IBaseMapper<UserEntity, UserDTO, UserRegisterRequestDTO> {
}
