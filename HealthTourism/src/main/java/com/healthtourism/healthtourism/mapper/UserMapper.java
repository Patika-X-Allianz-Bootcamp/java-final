package com.healthtourism.healthtourism.mapper;

import com.healthtourism.healthtourism.database.entities.UserEntity;
import com.healthtourism.healthtourism.model.RequestDTO.UserRequestDTO;
import com.healthtourism.healthtourism.model.UserDTO;
import com.healthtourism.healthtourism.util.BaseDTO;
import com.healthtourism.healthtourism.util.BaseEntity;
import com.healthtourism.healthtourism.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements IBaseMapper<UserEntity, UserDTO, UserRequestDTO> {

    @Override
    public UserDTO entityToDTO(UserEntity entity) {
        UserDTO userDTO=new UserDTO();
        userDTO.setCreationDate(entity.getCreationDate());
        userDTO.setId(entity.getId());
        userDTO.setUsername(entity.getUsername());
        userDTO.setFirstName(entity.getFirstName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setEmail(entity.getEmail());
        userDTO.setEnable(entity.isEnable());
        userDTO.setPassword(entity.getPassword());
        userDTO.setPhotoLink(entity.getPhotoLink());
        return userDTO;
    }

    @Override
    public UserEntity dtoToEntity(UserDTO dto) {
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(dto.getUsername());
        userEntity.setEmail(dto.getEmail());
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setPhotoLink(dto.getPhotoLink());
        userEntity.setEnable(dto.isEnable());
        userEntity.setUpdatedDate(dto.getUpdatedDate());
        userEntity.setUuid(dto.getUuid());
        userEntity.setPassword(dto.getPassword());
        return userEntity;
    }

    @Override
    public List<UserDTO> entityListToDTOList(List<UserEntity> userEntities) {
        List<UserDTO> userDTOList=new ArrayList<>();
        for(UserEntity userEntity :userEntities){
            userDTOList.add(entityToDTO(userEntity));
        }
        return userDTOList;
    }

    @Override
    public List<UserEntity> dtoListToEntityList(List<UserDTO> userDTOS) {
        List<UserEntity> userEntityList=new ArrayList<>();
        for(UserDTO userDTO: userDTOS){
            userEntityList.add(dtoToEntity(userDTO));
        }
        return userEntityList;
    }

    @Override
    public UserEntity requestDTOToEntity(UserRequestDTO userRequestDTO) {
        UserEntity userEntity=new UserEntity();
        userEntity.setFirstName(userRequestDTO.getFirstName());
        userEntity.setLastName(userRequestDTO.getLastName());
        userEntity.setPassword(userRequestDTO.getPassword());
        userEntity.setUuid(userRequestDTO.getUuid());
        return null;
    }

    @Override
    public List<UserEntity> requestDTOListToEntityList(List<UserRequestDTO> userRequestDTOS) {
        return null;
    }

    @Override
    public UserEntity requestDTOToExistEntity(UserRequestDTO userRequestDTO, UserEntity entity) {
        return null;
    }
}
