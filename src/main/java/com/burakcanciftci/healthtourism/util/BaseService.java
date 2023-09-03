package com.burakcanciftci.healthtourism.util;

import com.burakcanciftci.healthtourism.model.PageDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.BaseFilterRequestDTO;
import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import com.burakcanciftci.healthtourism.util.dbutil.BaseSpecification;
import com.burakcanciftci.healthtourism.util.dbutil.IBaseRepository;
import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public abstract class BaseService<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseDTO> {

    protected abstract BaseMapper<DTO, Entity, RequestDTO> getMapper();

    protected abstract IBaseRepository<Entity> getRepository();

    protected abstract BaseSpecification<Entity> getSpecification();

    @Transactional
    public DTO save(RequestDTO requestDTO) {
        Entity entity = getMapper().requestDTOToEntity(requestDTO);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }

    public PageDTO<DTO> getAll(BaseFilterRequestDTO baseFilterRequestDTO) {
        Pageable pageable;
        if (baseFilterRequestDTO.getSortDTO() != null) {
            if (baseFilterRequestDTO.getSortDTO().getDirectionEnum() == Sort.Direction.ASC) {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).ascending());
            } else {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).descending());
            }
        } else {
            pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),baseFilterRequestDTO.getPageSize(),
                    Sort.by("id").ascending());
        }

        getSpecification().setCriteriaList(baseFilterRequestDTO.getFilters());

        Page<Entity> entityPage = getRepository().findAll(getSpecification(),pageable);
        return getMapper().pageEntityToPageDTO(entityPage);
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