package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.PatientEntity;
import com.allianz.medicaltourism.model.DTO.FlightScheduleDTO;
import com.allianz.medicaltourism.model.DTO.PatientDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PatientRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FlightScheduleMapper.class, DoctorMapper.class, AppointmentMapper.class})
public interface PatientMapper extends IBaseMapper<PatientDTO, PatientEntity, PatientRequestDTO> {
	@Override
	PatientDTO entityToDTO(PatientEntity entity);

	@Override
	PatientEntity dtoToEntity(PatientDTO dto);

	@Override
	List<PatientDTO> entityListToDTOList(List<PatientEntity> patientEntities);

	@Override
	List<PatientEntity> dtoListTOEntityList(List<PatientDTO> patientDTOS);

	@Override
	PatientEntity requestDTOToEntity(PatientRequestDTO dto);

	@Override
	List<PatientEntity> requestDtoListTOEntityList(List<PatientRequestDTO> patientRequestDTOS);

	@Override
	PatientEntity requestDtoToExistEntity(@MappingTarget PatientEntity entity, PatientRequestDTO patientRequestDTO);

	@Override
	PageRequestDTO<PatientDTO> pageEntityToPageDTO(Page<PatientEntity> patientEntities);
}
