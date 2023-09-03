package com.patika.healthtourism.mapper;

import com.patika.healthtourism.database.entity.ExaminationEntity;
import com.patika.healthtourism.model.ExaminationDTO;
import com.patika.healthtourism.model.requestDTO.ExaminationCreateRequestDTO;
import com.patika.healthtourism.util.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExaminationMapper extends IBaseMapper<ExaminationEntity, ExaminationDTO, ExaminationCreateRequestDTO> {
}
