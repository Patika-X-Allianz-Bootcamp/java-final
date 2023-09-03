package com.demo.medicaltourismapp.util;

import com.demo.medicaltourismapp.model.PageDTO;
import com.demo.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.MappedSuperclass;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@MappedSuperclass
public interface BaseMapper<Entity extends BaseEntity, DTO extends BaseDTO,
        RequestDTO extends BaseDTO> {

    Entity dtoToEntity(DTO dto);

    DTO entityToDto(Entity entity);

    Entity requestDtoToEntity(RequestDTO requestDTO);

    RequestDTO entityToRequestDto(Entity entity);

    List<Entity> requestDtoListToEntityList(List<RequestDTO> dtoList);

    List<RequestDTO> entityListToRequestDtoList(List<Entity> entityList);

    List<Entity> dtoListToEntityList(List<DTO> dtoList);

    List<DTO> entityListToDtoList(List<Entity> entityList);

    Entity requestDtoToExistEntity(RequestDTO requestDTO, @MappingTarget Entity entity);

    PageDTO<DTO> pageEntityToPageDTO(Page<Entity> entityPage);

}
