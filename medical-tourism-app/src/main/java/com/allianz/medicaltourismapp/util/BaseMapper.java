package com.allianz.medicaltourismapp.util;


import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseMapper<D extends BaseDTO, E extends BaseEntity> {

    protected abstract D toDTO(E entity);

    protected abstract E toEntity(D dto);

    public List<E> toEntityList(List<D> dtoList) {
        List<E> entityList = new ArrayList<>();
        for (D dto : dtoList) {
            E entity = toEntity(dto);
            dtoList.add(dto);
        }
        return entityList;
    }

    public List<D> toDTOList(List<E> entityList) {
        List<D> dtoList = new ArrayList<>();
        for (E entity : entityList) {
            D dto = toDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public PageDTO<D> toDTO(Page<E> entities) {
        PageDTO<D> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(entities.getTotalPages());
        pageDTO.setSize(entities.getSize());
        pageDTO.setContent(toDTOList(entities.getContent()));
        pageDTO.setNumber(entities.getNumber());
        pageDTO.setTotalElements(entities.getTotalElements());
        pageDTO.setNumberOfElement(entities.getNumberOfElements());
        pageDTO.setSort(entities.getSort());

        return  pageDTO;
    }

    public E dtoToExistEntity(D dto, E entity) {
        entity = toEntity(dto);
        return entity;
    }
}
