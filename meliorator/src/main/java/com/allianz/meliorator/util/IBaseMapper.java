package com.allianz.meliorator.util;

import com.allianz.meliorator.model.dto.PageDTO;
import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.MappedSuperclass;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@MappedSuperclass
public interface IBaseMapper<Entity extends BaseEntity,
        DTO extends BaseDTO, RequestDTO extends BaseRequestDTO> {

    public Entity dtoToEntity(DTO dto);

    public DTO entityToDto(Entity entity);

   public Entity requestDtoToEntity(RequestDTO requestDTO);

    public RequestDTO entityToRequestDto(Entity entity);

    public List<Entity> requestDtoListToEntityList(List<RequestDTO> dtoList);

    public List<RequestDTO> entityListToRequestDtoList(List<Entity> entityList);

    public List<Entity> dtoListToEntityList(List<DTO> dtoList);

    public List<DTO> entityListToDtoList(List<Entity> entityList);

    public Entity requestDtoToExistEntity(RequestDTO requestDTO, @MappingTarget Entity entity);

    public PageDTO<DTO> pageEntityToPageDTO(Page<Entity> entityPage);

    public Boolean entityToDTO(Entity entity);

    <DTO extends BaseDTO, Entity extends BaseEntity> List<DTO> entityListToDTOList(List<Entity> entities);

    <Entity extends BaseEntity> Entity requestDTOToExistEntity(RequestDTO requestDTO, Entity entity);

    <Entity extends BaseEntity> Entity requestDTOToEntity(RequestDTO requestDTO);
}
