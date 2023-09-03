package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.HospitalRoomEntity;
import com.allianz.medicaltourism.model.DTO.HospitalRoomDTO;
import com.allianz.medicaltourism.model.requestDTO.HospitalRoomRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HospitalMapper.class, PatientMapper.class})
public interface HospitalRoomMapper extends IBaseMapper<HospitalRoomDTO, HospitalRoomEntity, HospitalRoomRequestDTO> {
	@Override
	HospitalRoomDTO entityToDTO(HospitalRoomEntity entity);

	@Override
	HospitalRoomEntity dtoToEntity(HospitalRoomDTO dto);

	@Override
	List<HospitalRoomDTO> entityListToDTOList(List<HospitalRoomEntity> hospitalRoomEntities);

	@Override
	List<HospitalRoomEntity> dtoListTOEntityList(List<HospitalRoomDTO> hospitalRoomDTOS);

	@Override
	HospitalRoomEntity requestDTOToEntity(HospitalRoomRequestDTO dto);

	@Override
	List<HospitalRoomEntity> requestDtoListTOEntityList(List<HospitalRoomRequestDTO> hospitalRoomRequestDTOS);

	@Override
	HospitalRoomEntity requestDtoToExistEntity(@MappingTarget HospitalRoomEntity entity, HospitalRoomRequestDTO hospitalRoomRequestDTO);

	@Override
	PageRequestDTO<HospitalRoomDTO> pageEntityToPageDTO(Page<HospitalRoomEntity> hospitalRoomEntities);
}
