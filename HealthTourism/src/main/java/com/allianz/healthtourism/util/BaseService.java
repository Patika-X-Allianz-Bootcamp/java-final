package com.allianz.healthtourism.util;


import com.allianz.healthtourism.util.dbUtil.BaseEntity;

import java.util.UUID;


public abstract class BaseService<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseDTO,
        Mapper extends IBaseMapper<DTO, Entity, RequestDTO>,
        Repository extends BaseRepository<Entity>
        > {

    protected abstract Mapper getMapper();

    protected abstract Repository getRepository();



    public DTO save(RequestDTO dto) {
        Entity entity = getMapper().requestDTOToEntity(dto);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }


    public DTO update(UUID uuid, RequestDTO requestDTO) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            entity = getMapper().requestDtoToExistEntity(entity, requestDTO);
            getRepository().save(entity);
            return getMapper().entityToDTO(entity);
        } else {
            return null;
        }
    }

    public DTO getByUUID(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            return getMapper().entityToDTO(entity);
        } else {
            return null;
        }
    }

    public Boolean deleteByUUID(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            getRepository().delete(entity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }


}
