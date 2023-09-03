package com.healthtourism.healthtourism.util;

import java.util.List;

public interface IBaseMapper <Entity extends BaseEntity, DTO extends BaseDTO, RequestDTO extends BaseDTO>{

    public DTO entityToDTO(Entity entity);

    public Entity dtoToEntity(DTO dto);

    public List<DTO> entityListToDTOList(List<Entity> entityList);

    public List<Entity> dtoListToEntityList(List<DTO> dtoList);

    public Entity requestDTOToEntity(RequestDTO requestDTO);

    public List<Entity> requestDTOListToEntityList(List<RequestDTO> dtoList);

    public Entity requestDTOToExistEntity(RequestDTO requestDTO, Entity entity);
}
