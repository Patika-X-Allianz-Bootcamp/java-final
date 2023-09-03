package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.FlightScheduleEntity;
import com.allianz.medicaltourism.model.DTO.FlightScheduleDTO;
import com.allianz.medicaltourism.model.requestDTO.FlightScheduleRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = PatientMapper.class)
@Lazy
public interface FlightScheduleMapper extends IBaseMapper<FlightScheduleDTO, FlightScheduleEntity, FlightScheduleRequestDTO> {
	@Override
	FlightScheduleDTO entityToDTO(FlightScheduleEntity entity);

	@Override
	FlightScheduleEntity dtoToEntity(FlightScheduleDTO dto);

	@Override
	List<FlightScheduleDTO> entityListToDTOList(List<FlightScheduleEntity> flightScheduleEntities);

	@Override
	List<FlightScheduleEntity> dtoListTOEntityList(List<FlightScheduleDTO> flightScheduleDTOS);

	@Override
	FlightScheduleEntity requestDTOToEntity(FlightScheduleRequestDTO dto);

	@Override
	List<FlightScheduleEntity> requestDtoListTOEntityList(List<FlightScheduleRequestDTO> flightScheduleRequestDTOS);

	@Override
	FlightScheduleEntity requestDtoToExistEntity(@MappingTarget FlightScheduleEntity entity, FlightScheduleRequestDTO flightScheduleRequestDTO);

	@Override
	PageRequestDTO<FlightScheduleDTO> pageEntityToPageDTO(Page<FlightScheduleEntity> flightScheduleEntities);
}
