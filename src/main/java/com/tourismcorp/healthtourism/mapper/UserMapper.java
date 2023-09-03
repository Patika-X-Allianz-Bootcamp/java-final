package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.UserEntity;
import com.tourismcorp.healthtourism.model.UserDTO;
import com.tourismcorp.healthtourism.model.requestDTO.UserRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements IBaseMapper<UserEntity, UserDTO, UserRequestDTO> {

    private final RoleMapper roleMapper;
    private final BankAccountMapper bankAccountMapper;

    @Autowired
    protected UserMapper(@Lazy RoleMapper roleMapper, BankAccountMapper bankAccountMapper) {
        this.roleMapper = roleMapper;
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public UserDTO entityToDTO(UserEntity entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUuid(entity.getUuid());
        userDTO.setCreationDate(entity.getCreationDate());
        userDTO.setUpdatedDate(entity.getUpdatedDate());
        userDTO.setId(entity.getId());
        userDTO.setFirstName(entity.getFirstName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setUsername(entity.getUsername());
        userDTO.setPassword(entity.getPassword());
        userDTO.setRoles(roleMapper.entityListToDTOList(entity.getRoles()));
        userDTO.setEmail(entity.getEmail());
        if (entity.getBankAccount() == null)
            userDTO.setBankAccount(null);
        else
            userDTO.setBankAccount(bankAccountMapper.entityToDTO(entity.getBankAccount()));

        return userDTO;
    }

    @Override
    public UserEntity dtoToEntity(UserDTO dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUuid(dto.getUuid());
        userEntity.setCreationDate(dto.getCreationDate());
        userEntity.setUpdatedDate(dto.getUpdatedDate());
        userEntity.setId(dto.getId());
        userEntity.setFirstName(dto.getFirstName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(dto.getPassword());
        userEntity.setRoles(roleMapper.dtoListToEntityList(dto.getRoles()));
        userEntity.setEmail(dto.getEmail());
       if (dto.getBankAccount() == null)
            userEntity.setBankAccount(null);
        else
            userEntity.setBankAccount(bankAccountMapper.dtoToEntity(dto.getBankAccount()));

        return userEntity;
    }

    @Override
    public List<UserDTO> entityListToDTOList(List<UserEntity> entityList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserEntity entity : entityList) {
            UserDTO dto = entityToDTO(entity);
            userDTOList.add(dto);
        }
        return userDTOList;
    }

    @Override
    public List<UserEntity> dtoListToEntityList(List<UserDTO> dtoList) {
        List<UserEntity> userEntityList = new ArrayList<>();
        if (dtoList == null)
            return userEntityList;
        for (UserDTO dto : dtoList) {
            UserEntity entity = dtoToEntity(dto);
            userEntityList.add(entity);
        }
        return userEntityList;
    }

    @Override
    public UserEntity requestDTOToEntity(UserRequestDTO requestDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUuid(requestDTO.getUuid());
        userEntity.setCreationDate(requestDTO.getCreationDate());
        userEntity.setUpdatedDate(requestDTO.getUpdatedDate());
        userEntity.setId(requestDTO.getId());
        userEntity.setFirstName(requestDTO.getFirstName());
        userEntity.setLastName(requestDTO.getLastName());
        userEntity.setUsername(requestDTO.getUsername());
        userEntity.setPassword(requestDTO.getPassword());
        userEntity.setRoles(roleMapper.requestDTOListToEntityList(requestDTO.getRoles()));
        userEntity.setEmail(requestDTO.getEmail());
        if (requestDTO.getBankAccount() == null)
            userEntity.setBankAccount(null);
        else
            userEntity.setBankAccount(bankAccountMapper.requestDTOToEntity(requestDTO.getBankAccount()));

        return userEntity;
    }

    @Override
    public List<UserEntity> requestDTOListToEntityList(List<UserRequestDTO> dtoList) {
        List<UserEntity> userEntityList = new ArrayList<>();
        if (dtoList == null)
            return userEntityList;
        for (UserRequestDTO dto : dtoList) {
            UserEntity entity = requestDTOToEntity(dto);
            userEntityList.add(entity);
        }
        return userEntityList;
    }

    @Override
    public UserEntity requestDTOToExistEntity(UserRequestDTO requestDTO, UserEntity entity) {
        if (requestDTO.getFirstName() != null)
            entity.setFirstName(requestDTO.getFirstName());
        if (requestDTO.getLastName() != null)
            entity.setLastName(requestDTO.getLastName());
        if (requestDTO.getUsername() != null)
            entity.setUsername(requestDTO.getUsername());
        if (requestDTO.getPassword() != null)
            entity.setPassword(requestDTO.getPassword());
        if (requestDTO.getRoles() != null)
            entity.setRoles(roleMapper.requestDTOListToEntityList(requestDTO.getRoles()));
        if (requestDTO.getEmail() != null)
            entity.setEmail(requestDTO.getEmail());
        if (requestDTO.getBankAccount() != null)
            entity.setBankAccount(bankAccountMapper.requestDTOToEntity(requestDTO.getBankAccount()));

        return entity;
    }

    @Override
    public Page<UserDTO> pageEntityToPageDTO(Page<UserEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
