package com.allianz.healthtourism.util;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<
        Entity extends BaseEntity,
        ResponseDTO extends BaseResponseDTO,
        RequestDTO extends BaseRequestDTO> {

    Entity requestDtoToEntity(RequestDTO requestDTO);

    ResponseDTO entityToResponseDto(Entity entity);

    List<ResponseDTO> entityListToResponseDtoList(List<Entity> entityList);

    Entity updateEntityFromRequestDTO(RequestDTO requestDTO, @MappingTarget Entity entity);


}