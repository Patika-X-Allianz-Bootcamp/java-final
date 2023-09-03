package com.allianz.medicaltourism.mapper;

import com.allianz.medicaltourism.database.entity.DoctorEntity;
import com.allianz.medicaltourism.model.DTO.DoctorDTO;
import com.allianz.medicaltourism.model.requestDTO.DoctorRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.util.IBaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AppointmentMapper.class, HospitalMapper.class})
public interface DoctorMapper extends IBaseMapper<DoctorDTO, DoctorEntity, DoctorRequestDTO> {
	@Override
	DoctorDTO entityToDTO(DoctorEntity entity);

	@Override
	DoctorEntity dtoToEntity(DoctorDTO dto);

	@Override
	List<DoctorDTO> entityListToDTOList(List<DoctorEntity> doctorEntities);

	@Override
	List<DoctorEntity> dtoListTOEntityList(List<DoctorDTO> doctorDTOS);

	@Override
	DoctorEntity requestDTOToEntity(DoctorRequestDTO dto);

	@Override
	List<DoctorEntity> requestDtoListTOEntityList(List<DoctorRequestDTO> doctorRequestDTOS);

	@Override
	DoctorEntity requestDtoToExistEntity(@MappingTarget DoctorEntity entity, DoctorRequestDTO doctorRequestDTO);

	@Override
	PageRequestDTO<DoctorDTO> pageEntityToPageDTO(Page<DoctorEntity> doctorEntities);
}
