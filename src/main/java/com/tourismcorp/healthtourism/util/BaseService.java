package com.tourismcorp.healthtourism.util;

import com.tourismcorp.healthtourism.model.requestDTO.BaseFilterRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.UUID;

public abstract class BaseService<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseDTO,
        Mapper extends IBaseMapper<Entity, DTO, RequestDTO>,
        Repository extends IBaseRepository<Entity>,
        Specification extends BaseSpecification<Entity>> {

    protected abstract Mapper getMapper();

    protected abstract Repository getRepository();

    protected abstract Specification getSpecification();

    public DTO save(RequestDTO requestDTO) {
        Entity entity = getMapper().requestDTOToEntity(requestDTO);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }

    @Modifying
    @Transactional
    public DTO update(UUID uuid, RequestDTO requestDTO) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            entity = getMapper().requestDTOToExistEntity(requestDTO, entity);
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

    @Modifying
    @Transactional
    public DTO deleteByUUID(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            getRepository().delete(entity);
            return getMapper().entityToDTO(entity);
        } else {
            return null;
        }
    }

    public List<DTO> getAll() {
        List<Entity> entities = getRepository().findAll();
        return getMapper().entityListToDTOList(entities);
    }

    public Page<DTO> getAllWithFilterAndPagination(BaseFilterRequestDTO baseFilterRequestDTO) {
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
}
