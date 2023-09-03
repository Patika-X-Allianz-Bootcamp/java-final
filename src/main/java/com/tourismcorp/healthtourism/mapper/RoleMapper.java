package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.RoleEntity;
import com.tourismcorp.healthtourism.model.RoleDTO;
import com.tourismcorp.healthtourism.model.requestDTO.RoleRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper implements IBaseMapper<RoleEntity, RoleDTO, RoleRequestDTO> {

    @Lazy
    private final UserMapper userMapper;

    @Autowired
    protected RoleMapper(@Lazy UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public RoleDTO entityToDTO(RoleEntity entity) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setUuid(entity.getUuid());
        roleDTO.setCreationDate(entity.getCreationDate());
        roleDTO.setUpdatedDate(entity.getUpdatedDate());
        roleDTO.setId(entity.getId());
        roleDTO.setName(entity.getName());
        roleDTO.setDescription(entity.getDescription());
        roleDTO.setUsers(userMapper.entityListToDTOList(entity.getUsers()));

        return roleDTO;
    }

    @Override
    public RoleEntity dtoToEntity(RoleDTO dto) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setUuid(dto.getUuid());
        roleEntity.setCreationDate(dto.getCreationDate());
        roleEntity.setUpdatedDate(dto.getUpdatedDate());
        roleEntity.setId(dto.getId());
        roleEntity.setName(dto.getName());
        roleEntity.setDescription(dto.getDescription());
        roleEntity.setUsers(userMapper.dtoListToEntityList(dto.getUsers()));

        return roleEntity;
    }

    @Override
    public List<RoleDTO> entityListToDTOList(List<RoleEntity> entityList) {
        List<RoleDTO> roleDTOList = new ArrayList<>();
        for (RoleEntity entity : entityList) {
            RoleDTO dto = entityToDTO(entity);
            roleDTOList.add(dto);
        }
        return roleDTOList;
    }

    @Override
    public List<RoleEntity> dtoListToEntityList(List<RoleDTO> dtoList) {
        List<RoleEntity> roleEntityList = new ArrayList<>();
        if (dtoList == null)
            return roleEntityList;
        for (RoleDTO dto : dtoList) {
            RoleEntity entity = dtoToEntity(dto);
            roleEntityList.add(entity);
        }
        return roleEntityList;
    }

    @Override
    public RoleEntity requestDTOToEntity(RoleRequestDTO requestDTO) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setUuid(requestDTO.getUuid());
        roleEntity.setCreationDate(requestDTO.getCreationDate());
        roleEntity.setUpdatedDate(requestDTO.getUpdatedDate());
        roleEntity.setId(requestDTO.getId());
        roleEntity.setName(requestDTO.getName());
        roleEntity.setDescription(requestDTO.getDescription());
        roleEntity.setUsers(userMapper.requestDTOListToEntityList(requestDTO.getUsers()));

        return roleEntity;
    }

    @Override
    public List<RoleEntity> requestDTOListToEntityList(List<RoleRequestDTO> dtoList) {
        List<RoleEntity> roleEntityList = new ArrayList<>();
        if (dtoList == null)
            return roleEntityList;
        for (RoleRequestDTO dto : dtoList) {
            RoleEntity entity = requestDTOToEntity(dto);
            roleEntityList.add(entity);
        }
        return roleEntityList;
    }

    @Override
    public RoleEntity requestDTOToExistEntity(RoleRequestDTO requestDTO, RoleEntity entity) {
        if (requestDTO.getName() != null)
            entity.setName(requestDTO.getName());
        if (requestDTO.getDescription() != null)
            entity.setDescription(requestDTO.getDescription());
        if (requestDTO.getUsers() != null)
            entity.setUsers(userMapper.requestDTOListToEntityList(requestDTO.getUsers()));

        return entity;
    }

    @Override
    public Page<RoleDTO> pageEntityToPageDTO(Page<RoleEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
