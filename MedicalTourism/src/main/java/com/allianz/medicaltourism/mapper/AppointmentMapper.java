package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.AppointmentEntity;
import com.allianz.medicaltourism.model.DTO.AppointmentDTO;
import com.allianz.medicaltourism.model.requestDTO.AppointmentRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PatientMapper.class, DoctorMapper.class})
public interface AppointmentMapper extends IBaseMapper<AppointmentDTO, AppointmentEntity, AppointmentRequestDTO> {
	@Override
	AppointmentDTO entityToDTO(AppointmentEntity entity);

	@Override
	AppointmentEntity dtoToEntity(AppointmentDTO dto);

	@Override
	List<AppointmentDTO> entityListToDTOList(List<AppointmentEntity> appointmentEntities);

	@Override
	List<AppointmentEntity> dtoListTOEntityList(List<AppointmentDTO> appointmentDTOS);

	@Override
	AppointmentEntity requestDTOToEntity(AppointmentRequestDTO dto);

	@Override
	List<AppointmentEntity> requestDtoListTOEntityList(List<AppointmentRequestDTO> appointmentRequestDTOS);

	@Override
	AppointmentEntity requestDtoToExistEntity(@MappingTarget AppointmentEntity entity, AppointmentRequestDTO appointmentRequestDTO);

	@Override
	PageRequestDTO<AppointmentDTO> pageEntityToPageDTO(Page<AppointmentEntity> appointmentEntities);
}
