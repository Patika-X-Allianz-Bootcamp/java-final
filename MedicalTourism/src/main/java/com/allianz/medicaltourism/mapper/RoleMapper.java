package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.RoleEntity;
import com.allianz.medicaltourism.model.DTO.RoleDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.RoleRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RoleMapper extends IBaseMapper<RoleDTO, RoleEntity, RoleRequestDTO> {
	@Override
	RoleDTO entityToDTO(RoleEntity entity);

	@Override
	RoleEntity dtoToEntity(RoleDTO dto);

	@Override
	List<RoleDTO> entityListToDTOList(List<RoleEntity> roleEntities);

	@Override
	List<RoleEntity> dtoListTOEntityList(List<RoleDTO> roleDTOS);

	@Override
	RoleEntity requestDTOToEntity(RoleRequestDTO dto);

	@Override
	List<RoleEntity> requestDtoListTOEntityList(List<RoleRequestDTO> roleRequestDTOS);

	@Override
	RoleEntity requestDtoToExistEntity(@MappingTarget RoleEntity entity, RoleRequestDTO roleRequestDTO);

	@Override
	PageRequestDTO<RoleDTO> pageEntityToPageDTO(Page<RoleEntity> roleEntities);
}
