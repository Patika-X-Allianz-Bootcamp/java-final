package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.HotelEntity;
import com.allianz.medicaltourism.model.DTO.HotelDTO;
import com.allianz.medicaltourism.model.requestDTO.HotelRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HotelRoomMapper.class})
public interface HotelMapper extends IBaseMapper<HotelDTO, HotelEntity, HotelRequestDTO> {
	@Override
	HotelDTO entityToDTO(HotelEntity entity);

	@Override
	HotelEntity dtoToEntity(HotelDTO dto);

	@Override
	List<HotelDTO> entityListToDTOList(List<HotelEntity> hotelEntities);

	@Override
	List<HotelEntity> dtoListTOEntityList(List<HotelDTO> hotelDTOS);

	@Override
	HotelEntity requestDTOToEntity(HotelRequestDTO dto);

	@Override
	List<HotelEntity> requestDtoListTOEntityList(List<HotelRequestDTO> hotelRequestDTOS);

	@Override
	HotelEntity requestDtoToExistEntity(@MappingTarget HotelEntity entity, HotelRequestDTO hotelRequestDTO);

	@Override
	PageRequestDTO<HotelDTO> pageEntityToPageDTO(Page<HotelEntity> hotelEntities);
}
