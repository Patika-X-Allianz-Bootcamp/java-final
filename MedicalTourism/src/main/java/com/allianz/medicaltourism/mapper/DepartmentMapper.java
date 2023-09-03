package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.DepartmentEntity;
import com.allianz.medicaltourism.model.DTO.DepartmentDTO;
import com.allianz.medicaltourism.model.requestDTO.DepartmentRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = HospitalMapper.class)
public interface DepartmentMapper extends IBaseMapper<DepartmentDTO, DepartmentEntity, DepartmentRequestDTO> {
	@Override
	DepartmentDTO entityToDTO(DepartmentEntity entity);

	@Override
	DepartmentEntity dtoToEntity(DepartmentDTO dto);

	@Override
	List<DepartmentDTO> entityListToDTOList(List<DepartmentEntity> departmentEntities);

	@Override
	List<DepartmentEntity> dtoListTOEntityList(List<DepartmentDTO> departmentDTOS);

	@Override
	DepartmentEntity requestDTOToEntity(DepartmentRequestDTO dto);

	@Override
	List<DepartmentEntity> requestDtoListTOEntityList(List<DepartmentRequestDTO> departmentRequestDTOS);

	@Override
	DepartmentEntity requestDtoToExistEntity(@MappingTarget DepartmentEntity entity, DepartmentRequestDTO departmentRequestDTO);

	@Override
	PageRequestDTO<DepartmentDTO> pageEntityToPageDTO(Page<DepartmentEntity> departmentEntities);
}
