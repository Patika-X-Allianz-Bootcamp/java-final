package patika.fhw.demo.util;

import java.util.List;

import org.springframework.data.domain.Page;

import patika.fhw.demo.model.requestDTO.PageDTO;
import patika.fhw.demo.util.dbutil.BaseDTO;
import patika.fhw.demo.util.dbutil.BaseEntity;

public interface BaseMapper<DTO extends BaseDTO, Entity extends BaseEntity, RequestDTO extends BaseDTO> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    List<Entity> dtoListTOEntityList(List<DTO> dtoList);

    Entity requestDTOToEntity(RequestDTO dto);

    List<Entity> requestDtoListTOEntityList(List<RequestDTO> dtoList);

    Entity requestDtoToExistEntity(Entity entity, RequestDTO requestDTO);

    PageDTO<DTO> pageEntityToPageDTO(Page<Entity> entityPage);

}