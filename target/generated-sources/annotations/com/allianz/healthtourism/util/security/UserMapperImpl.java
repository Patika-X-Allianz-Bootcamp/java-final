package com.allianz.healthtourism.util.security;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T12:58:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity requestDtoToEntity(UserRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername( requestDTO.getUsername() );
        userEntity.setFirstName( requestDTO.getFirstName() );
        userEntity.setLastName( requestDTO.getLastName() );
        userEntity.setPassword( requestDTO.getPassword() );
        userEntity.setEmail( requestDTO.getEmail() );
        userEntity.setPhotoLink( requestDTO.getPhotoLink() );

        return userEntity;
    }

    @Override
    public UserResponseDTO entityToResponseDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId( entity.getId() );
        userResponseDTO.setUuid( entity.getUuid() );
        userResponseDTO.setCreationDate( entity.getCreationDate() );
        userResponseDTO.setLastModifiedDate( entity.getLastModifiedDate() );
        userResponseDTO.setUsername( entity.getUsername() );
        userResponseDTO.setEmail( entity.getEmail() );
        userResponseDTO.setFirstName( entity.getFirstName() );
        userResponseDTO.setLastName( entity.getLastName() );
        userResponseDTO.setPassword( entity.getPassword() );
        userResponseDTO.setPhotoLink( entity.getPhotoLink() );
        userResponseDTO.setEnable( entity.isEnable() );
        userResponseDTO.setRoles( roleEntitySetToRoleResponseDTOSet( entity.getRoles() ) );

        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> entityListToResponseDtoList(List<UserEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserResponseDTO> list = new ArrayList<UserResponseDTO>( entityList.size() );
        for ( UserEntity userEntity : entityList ) {
            list.add( entityToResponseDto( userEntity ) );
        }

        return list;
    }

    @Override
    public UserEntity updateEntityFromRequestDTO(UserRequestDTO requestDTO, UserEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setUsername( requestDTO.getUsername() );
        entity.setFirstName( requestDTO.getFirstName() );
        entity.setLastName( requestDTO.getLastName() );
        entity.setPassword( requestDTO.getPassword() );
        entity.setEmail( requestDTO.getEmail() );
        entity.setPhotoLink( requestDTO.getPhotoLink() );

        return entity;
    }

    protected UserResponseWithoutRoleDTO userEntityToUserResponseWithoutRoleDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponseWithoutRoleDTO userResponseWithoutRoleDTO = new UserResponseWithoutRoleDTO();

        userResponseWithoutRoleDTO.setUsername( userEntity.getUsername() );
        userResponseWithoutRoleDTO.setEmail( userEntity.getEmail() );
        userResponseWithoutRoleDTO.setFirstName( userEntity.getFirstName() );
        userResponseWithoutRoleDTO.setLastName( userEntity.getLastName() );
        userResponseWithoutRoleDTO.setPassword( userEntity.getPassword() );
        userResponseWithoutRoleDTO.setPhotoLink( userEntity.getPhotoLink() );
        userResponseWithoutRoleDTO.setEnable( userEntity.isEnable() );

        return userResponseWithoutRoleDTO;
    }

    protected List<UserResponseWithoutRoleDTO> userEntityListToUserResponseWithoutRoleDTOList(List<UserEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<UserResponseWithoutRoleDTO> list1 = new ArrayList<UserResponseWithoutRoleDTO>( list.size() );
        for ( UserEntity userEntity : list ) {
            list1.add( userEntityToUserResponseWithoutRoleDTO( userEntity ) );
        }

        return list1;
    }

    protected RoleResponseDTO roleEntityToRoleResponseDTO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();

        roleResponseDTO.setId( roleEntity.getId() );
        roleResponseDTO.setUuid( roleEntity.getUuid() );
        roleResponseDTO.setCreationDate( roleEntity.getCreationDate() );
        roleResponseDTO.setLastModifiedDate( roleEntity.getLastModifiedDate() );
        roleResponseDTO.setName( roleEntity.getName() );
        roleResponseDTO.setDescription( roleEntity.getDescription() );
        roleResponseDTO.setUsers( userEntityListToUserResponseWithoutRoleDTOList( roleEntity.getUsers() ) );

        return roleResponseDTO;
    }

    protected Set<RoleResponseDTO> roleEntitySetToRoleResponseDTOSet(Set<RoleEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleResponseDTO> set1 = new LinkedHashSet<RoleResponseDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleEntity roleEntity : set ) {
            set1.add( roleEntityToRoleResponseDTO( roleEntity ) );
        }

        return set1;
    }
}
