package com.burakcanciftci.healthtourism.util;

import com.burakcanciftci.healthtourism.model.PageDTO;
import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.lang.reflect.Field;
import java.util.*;

public class BaseMapper<DTO extends BaseDTO, Entity extends BaseEntity, RequestDTO extends BaseDTO> {

    private Class<Entity> initialEntityClass;
    private Class<DTO> initialDTOClass;

    protected void init(Class<Entity> entityValue, Class<DTO> dtoValue) {
        this.initialEntityClass = entityValue;
        this.initialDTOClass = dtoValue;
    }

    private void copyProperties(Object source, Object target) throws IllegalAccessException {
        if (source == null) {
            return;
        }

        List<Field> sourceFields = new ArrayList<>(Arrays.stream(source.getClass().getDeclaredFields()).toList());
        List<Field> targetFields = new ArrayList<>(Arrays.stream(target.getClass().getDeclaredFields()).toList());

        // To get all properties
        if (source.getClass().getSuperclass() != null) {
            sourceFields.addAll(Arrays.stream(source.getClass().getSuperclass().getDeclaredFields()).toList());
        }

        if (target.getClass().getSuperclass() != null) {
            targetFields.addAll(Arrays.stream(target.getClass().getSuperclass().getDeclaredFields()).toList());
        }

        for (Field sourceField : sourceFields) {
            String fieldName = sourceField.getName();

            for (Field targetField : targetFields) {
                if (targetField.getName().equals(fieldName)) {
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);

                    // if field is a collection type
                    if (Collection.class.isAssignableFrom(sourceField.getType())) {
                        Collection<?> sourceCollection = (Collection<?>) sourceField.get(source);

                        Collection<Object> targetCollection;
                        if (List.class.isAssignableFrom(targetField.getType())) {
                            targetCollection = new ArrayList<>();
                        } else {
                            targetCollection = new HashSet<>();
                        }

                        if (sourceCollection != null && targetCollection != null) {
                            for (Object item : sourceCollection) {
                                if (item instanceof BaseEntity && targetField.getType().isInstance(item)) {
                                    Object subTarget = null;

                                    try {
                                        subTarget = targetField.getType().newInstance();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    BeanUtils.copyProperties(item, subTarget);
                                    targetCollection.add(subTarget);
                                } else {
                                    targetCollection.add(item);
                                }
                            }

                            targetField.set(target, targetCollection);
                        }

                    } else if (BaseEntity.class.isAssignableFrom(targetField.getType())
                            || BaseDTO.class.isAssignableFrom(targetField.getType())
                            && sourceField.get(source) != null) {

                        try {
                            Object subTarget = targetField.getType().newInstance();
                            copyProperties(sourceField.get(source), subTarget);
                            targetField.set(target, subTarget);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                        targetField.set(target, sourceField.get(source));
                    }

                    break;
                }
            }
        }
    }

    public Entity dtoToEntity(DTO dto) {
        Entity entity = null;
        try {
            entity = initialEntityClass.getDeclaredConstructor().newInstance();
            copyProperties(dto, entity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    public DTO entityToDTO(Entity entity) {
        DTO dto = null;
        try {
            dto = initialDTOClass.getDeclaredConstructor().newInstance();
            copyProperties(entity, dto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dto;
    }

    public List<DTO> entityListToDTOList(List<Entity> personEntities) {
        List<DTO> dtoList = new ArrayList<>();
        for (Entity entity : personEntities) {
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    public List<Entity> dtoListToEntityList(List<DTO> dtoList) {
        List<Entity> entityList = new ArrayList<>();
        for (DTO dto : dtoList) {
            entityList.add(dtoToEntity(dto));
        }

        return entityList;
    }

    public Entity requestDTOToEntity(RequestDTO dto) {
        Entity entity = null;
        try {
            entity = initialEntityClass.getDeclaredConstructor().newInstance();
            copyProperties(dto, entity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    public Entity requestDtoToExistEntity(Entity entity, RequestDTO requestDTO) {
        try {
            copyProperties(requestDTO, entity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    public PageDTO<DTO> pageEntityToPageDTO(Page<Entity> entityPage) {
        PageDTO<DTO> pageDTO = new PageDTO<>();

        try {
            copyProperties(entityPage, pageDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pageDTO;
    }
}