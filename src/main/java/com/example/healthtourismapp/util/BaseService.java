package com.example.healthtourismapp.util;

import com.example.healthtourismapp.model.requestDTO.BaseFilterRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseDTO,
        Mapper extends IBaseMapper<Entity, DTO, RequestDTO>,
        Repository extends IBaseRepository<Entity>,
        Specification extends BaseSpecification<Entity>
        > {

    protected abstract Mapper getMapper();

    public abstract Repository getRepository();

    protected abstract Specification getSpecification();

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

    public DTO save(RequestDTO requestDTO) {
        Entity entity = getMapper().requestDTOToEntity(requestDTO);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }

    public List<DTO> getAAll() {
        return getMapper().entityListToDTOList(getRepository().findAll());
    }


    public DTO getByUuid(UUID uuid) {
        Optional<Entity> entity = getRepository().findByUuid(uuid);
        if (entity.isPresent()) {
            return getMapper().entityToDTO(entity.get());
        } else {
            throw new EntityNotFoundException("UUID not found: " + uuid);
        }
    }

    @Modifying
    @Transactional
    public DTO update(UUID uuid, RequestDTO requestDTO) {
        Optional<Entity> entity = getRepository().findByUuid(uuid);
        if (entity.isPresent()) {
            Entity newEntity = getMapper().requestDTOToExistEntity(requestDTO, entity.get());
            getRepository().save(newEntity);
            return getMapper().entityToDTO(newEntity);
        } else {
            throw new EntityNotFoundException("UUID not found: " + uuid);
        }
    }

    @Modifying
    @Transactional
    public Boolean delete(UUID uuid) {
        Optional<Entity> entity = getRepository().findByUuid(uuid);
        if (entity.isPresent()) {
            getRepository().delete(entity.get());
            return true;
        } else {
            return false;
        }
    }



}
