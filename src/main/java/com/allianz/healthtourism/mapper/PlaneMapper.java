package com.allianz.healthtourism.mapper;

import com.allianz.healthtourism.database.entity.PlaneEntity;
import com.allianz.healthtourism.model.requestDTO.PlaneRequestDTO;
import com.allianz.healthtourism.model.responseDTO.PlaneResponseDTO;
import com.allianz.healthtourism.util.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlaneMapper extends BaseMapper<PlaneEntity, PlaneResponseDTO, PlaneRequestDTO> {
    PlaneMapper INSTANCE = Mappers.getMapper(PlaneMapper.class);

    @Override
    @Mapping(source = "cityId", target = "city.id")
    PlaneEntity requestDtoToEntity(PlaneRequestDTO requestDTO);
}
