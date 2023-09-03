package com.tourismcorp.healthtourism.util;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IBaseMapper<E extends BaseEntity, D extends BaseDTO, R extends BaseDTO> {

    public D entityToDTO(E entity);

    public E dtoToEntity(D dto);

    public List<D> entityListToDTOList(List<E> entityList);

    public List<E> dtoListToEntityList(List<D> dtoList);

    public E requestDTOToEntity(R requestDTO);

    public List<E> requestDTOListToEntityList(List<R> dtoList);

    public E requestDTOToExistEntity(R requestDTO, E entity);

    public Page<D> pageEntityToPageDTO(Page<E> entityPage);
}
