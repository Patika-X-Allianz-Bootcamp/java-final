package com.example.healthtourismapp.util;

import org.springframework.data.domain.Page;
import java.util.List;

public interface IBaseMapper<Entity extends BaseEntity, DTO extends BaseDTO, RequestDTO extends BaseDTO> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    List<Entity> dtoListToEntityList(List<DTO> dtoList);

    Entity requestDTOToEntity(RequestDTO requestDTO);

    List<Entity> requestDTOListToEntityList(List<RequestDTO> requestDTOList);

    Entity requestDTOToExistEntity(RequestDTO requestDTO, Entity entity);

    Page<DTO> pageEntityToPageDTO(Page<Entity> entityPage);
}
