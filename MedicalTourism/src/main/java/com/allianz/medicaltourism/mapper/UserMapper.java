package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.UserEntity;
import com.allianz.medicaltourism.model.DTO.UserDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.UserRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper extends IBaseMapper<UserDTO, UserEntity, UserRequestDTO> {
	@Override
	UserDTO entityToDTO(UserEntity entity);

	@Override
	UserEntity dtoToEntity(UserDTO dto);

	@Override
	List<UserDTO> entityListToDTOList(List<UserEntity> userEntities);

	@Override
	List<UserEntity> dtoListTOEntityList(List<UserDTO> userDTOS);

	@Override
	UserEntity requestDTOToEntity(UserRequestDTO dto);

	@Override
	List<UserEntity> requestDtoListTOEntityList(List<UserRequestDTO> userRequestDTOS);

	@Override
	UserEntity requestDtoToExistEntity(@MappingTarget UserEntity entity, UserRequestDTO userRequestDTO);

	@Override
	PageRequestDTO<UserDTO> pageEntityToPageDTO(Page<UserEntity> userEntities);
}
