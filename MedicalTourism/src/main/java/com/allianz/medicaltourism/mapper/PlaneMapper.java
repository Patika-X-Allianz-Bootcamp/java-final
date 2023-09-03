package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.PlaneEntity;
import com.allianz.medicaltourism.model.DTO.PlaneDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PlaneRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlaneSeatMapper.class})
public interface PlaneMapper extends IBaseMapper<PlaneDTO, PlaneEntity, PlaneRequestDTO> {
	@Override
	PlaneDTO entityToDTO(PlaneEntity entity);

	@Override
	PlaneEntity dtoToEntity(PlaneDTO dto);

	@Override
	List<PlaneDTO> entityListToDTOList(List<PlaneEntity> planeEntities);

	@Override
	List<PlaneEntity> dtoListTOEntityList(List<PlaneDTO> planeDTOS);

	@Override
	PlaneEntity requestDTOToEntity(PlaneRequestDTO dto);

	@Override
	List<PlaneEntity> requestDtoListTOEntityList(List<PlaneRequestDTO> planeRequestDTOS);

	@Override
	PlaneEntity requestDtoToExistEntity(@MappingTarget PlaneEntity entity, PlaneRequestDTO planeRequestDTO);

	@Override
	PageRequestDTO<PlaneDTO> pageEntityToPageDTO(Page<PlaneEntity> planeEntities);
}
