package com.allianz.healthtourism.util;

import com.allianz.healthtourism.model.DTO.PageDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBaseMapper<DTO extends BaseDTO, Entity extends BaseEntity> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    List<Entity> dtoListTOEntityList(List<DTO> dtoList);

    Entity dtoToExistEntity(Entity entity, DTO dto);

    PageDTO<DTO> pageEntityToPageDTO(Page<Entity> entityPage);

}