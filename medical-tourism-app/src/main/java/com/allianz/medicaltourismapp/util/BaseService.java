package com.allianz.medicaltourismapp.util;

import com.allianz.medicaltourismapp.database.entity.AppointmentEntity;
import com.allianz.medicaltourismapp.model.AppointmentDTO;
import com.allianz.medicaltourismapp.model.PageDTO;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import com.allianz.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<
        DTO extends BaseDTO,
        Entity extends BaseEntity,
        Repository extends BaseRepository<Entity>,
        Mapper extends BaseMapper<DTO, Entity>,
        Specification extends BaseSpecification<Entity>
        > {

    protected abstract Mapper getMapper();

    protected abstract Repository getRepository();


    protected abstract Specification getSpecification();

    public DTO save(DTO dto) {
        Entity entity = getMapper().toEntity(dto);
        getRepository().save(entity);
        return getMapper().toDTO(entity);
    }

    public PageDTO<DTO> getfilter(BaseFilterDTO baseFilterRequestDTO) {
        Pageable pageable;
        if (baseFilterRequestDTO.getSortDTO() != null) {
            if (baseFilterRequestDTO.getSortDTO().getDirection() == Sort.Direction.ASC) {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColoumnName()).ascending());
            } else {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColoumnName()).descending());
            }
        } else {
            pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                    Sort.by("id").ascending());
        }

        getSpecification().setCriteriaList(baseFilterRequestDTO.getFilters());

        Page<Entity> entityPage = getRepository().findAll(getSpecification(), pageable);
        return getMapper().toDTO(entityPage);
    }

    public DTO update(UUID uuid, DTO dto) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            entity = getMapper().dtoToExistEntity(dto, entity);
            getRepository().save(entity);
            return getMapper().toDTO(entity);
        } else {
            return null;
        }
    }

    public DTO getByUuid(UUID uuid) {

        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            return getMapper().toDTO(entity);
        } else {
            return null;
        }
    }

    public List<DTO> getall() {

        List<Entity> entities = getRepository().findAll();
        if (entities != null) {
            return getMapper().toDTOList(entities);
        } else {
            return null;
        }
    }

    public Boolean deleteByUuid(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            getRepository().delete(entity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}

