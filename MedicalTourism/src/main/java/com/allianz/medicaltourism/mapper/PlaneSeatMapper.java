package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.PlaneSeatEntity;
import com.allianz.medicaltourism.model.DTO.PlaneSeatDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PlaneSeatRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PatientMapper.class})
public interface PlaneSeatMapper extends IBaseMapper<PlaneSeatDTO, PlaneSeatEntity, PlaneSeatRequestDTO>{
	@Override
	PlaneSeatDTO entityToDTO(PlaneSeatEntity entity);

	@Override
	PlaneSeatEntity dtoToEntity(PlaneSeatDTO dto);

	@Override
	List<PlaneSeatDTO> entityListToDTOList(List<PlaneSeatEntity> planeSeatEntities);

	@Override
	List<PlaneSeatEntity> dtoListTOEntityList(List<PlaneSeatDTO> planeSeatDTOS);

	@Override
	PlaneSeatEntity requestDTOToEntity(PlaneSeatRequestDTO dto);

	@Override
	List<PlaneSeatEntity> requestDtoListTOEntityList(List<PlaneSeatRequestDTO> planeSeatRequestDTOS);

	@Override
	PlaneSeatEntity requestDtoToExistEntity(@MappingTarget PlaneSeatEntity entity, PlaneSeatRequestDTO planeSeatRequestDTO);

	@Override
	PageRequestDTO<PlaneSeatDTO> pageEntityToPageDTO(Page<PlaneSeatEntity> planeSeatEntities);
}
