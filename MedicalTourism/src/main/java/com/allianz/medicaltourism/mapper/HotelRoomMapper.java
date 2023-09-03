package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.HotelRoomEntity;
import com.allianz.medicaltourism.model.DTO.HotelRoomDTO;
import com.allianz.medicaltourism.model.requestDTO.HotelRoomRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HotelMapper.class, PatientMapper.class})
public interface HotelRoomMapper extends IBaseMapper<HotelRoomDTO, HotelRoomEntity, HotelRoomRequestDTO> {
	@Override
	HotelRoomDTO entityToDTO(HotelRoomEntity entity);

	@Override
	HotelRoomEntity dtoToEntity(HotelRoomDTO dto);

	@Override
	List<HotelRoomDTO> entityListToDTOList(List<HotelRoomEntity> hotelRoomEntities);

	@Override
	List<HotelRoomEntity> dtoListTOEntityList(List<HotelRoomDTO> hotelRoomDTOS);

	@Override
	HotelRoomEntity requestDTOToEntity(HotelRoomRequestDTO dto);

	@Override
	List<HotelRoomEntity> requestDtoListTOEntityList(List<HotelRoomRequestDTO> hotelRoomRequestDTOS);

	@Override
	HotelRoomEntity requestDtoToExistEntity(@MappingTarget HotelRoomEntity entity, HotelRoomRequestDTO hotelRoomRequestDTO);

	@Override
	PageRequestDTO<HotelRoomDTO> pageEntityToPageDTO(Page<HotelRoomEntity> hotelRoomEntities);
}
