package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.HospitalEntity;
import com.allianz.medicaltourism.model.DTO.HospitalDTO;
import com.allianz.medicaltourism.model.requestDTO.HospitalRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, DepartmentMapper.class, HospitalRoomMapper.class})
public interface HospitalMapper extends IBaseMapper<HospitalDTO, HospitalEntity, HospitalRequestDTO> {
	@Override
	HospitalDTO entityToDTO(HospitalEntity entity);

	@Override
	HospitalEntity dtoToEntity(HospitalDTO dto);

	@Override
	List<HospitalDTO> entityListToDTOList(List<HospitalEntity> hospitalEntities);

	@Override
	List<HospitalEntity> dtoListTOEntityList(List<HospitalDTO> hospitalDTOS);

	@Override
	HospitalEntity requestDTOToEntity(HospitalRequestDTO dto);

	@Override
	List<HospitalEntity> requestDtoListTOEntityList(List<HospitalRequestDTO> hospitalRequestDTOS);

	@Override
	HospitalEntity requestDtoToExistEntity(@MappingTarget HospitalEntity entity, HospitalRequestDTO hospitalRequestDTO);

	@Override
	PageRequestDTO<HospitalDTO> pageEntityToPageDTO(Page<HospitalEntity> hospitalEntities);
}
