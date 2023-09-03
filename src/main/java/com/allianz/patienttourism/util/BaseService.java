package com.allianz.patienttourism.util;


import com.allianz.patienttourism.util.mapper.MapperService;
import com.allianz.patienttourism.model.requestDTO.BaseFilterRequestDTO;
import com.allianz.patienttourism.model.responseDTO.PageResponseDTO;
import com.allianz.patienttourism.util.dbutil.BaseEntity;
import com.allianz.patienttourism.util.dbutil.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class BaseService<Entity extends BaseEntity,ResponseDTO extends BaseResponseDTO,
        RequestDTO extends BaseRequestDTO> {

    private final IBaseRepository<Entity> repository;
    private final MapperService mapperService;
    private final BaseSpecification<Entity> specification;

    protected abstract Class<Entity> getEntityClass();
    protected abstract Class<ResponseDTO> getResponseDTOClass();


    public List<ResponseDTO> getAll(){
        List<Entity> entityList = repository.findAll();
        List<ResponseDTO> responseDTOList = entityList.stream().map(entity ->
                mapperService.responseMapper().map(entity,getResponseDTOClass())).toList();
        return responseDTOList;
    }

    @Transactional
    public ResponseDTO save(RequestDTO requestDTO){
        Entity entity = mapperService.requestMapper().map(requestDTO,getEntityClass());
        repository.save(entity);
        return mapperService.responseMapper().map(entity,getResponseDTOClass());
    }

    @Transactional
    public ResponseDTO update(UUID uuid, RequestDTO requestDTO) {
        Entity entity = repository.findByUuid(uuid).orElse(null);
        if (entity != null) {
            Entity updatedEntity = mapperService.requestMapper().map(requestDTO, getEntityClass());
            updatedEntity.setId(entity.getId());
            updatedEntity.setUuid(entity.getUuid());
            updatedEntity.setCreationDate(entity.getCreationDate());
            updatedEntity.setLastModifiedDate(entity.getLastModifiedDate());
            repository.save(updatedEntity);
            return mapperService.responseMapper().map(entity,getResponseDTOClass());
        }else{
            return null;
        }

    }
    @Transactional
    public Boolean deleteByUUID(UUID uuid) {
        Entity entity = repository.findByUuid(uuid).orElse(null);
        if (entity != null) {
            repository.delete(entity);
            return true;
        }
        return false;
    }

    public ResponseDTO getByUUID(UUID uuid) {
        Entity entity = repository.findByUuid(uuid).orElse(null);
        if (entity != null) {
            return mapperService.responseMapper().map(entity,getResponseDTOClass());
        } else {
            return null;
        }
    }

    public ResponseDTO getByID(Long id) {
        Entity entity = repository.findById(id).orElse(null);
        if (entity != null) {
            return mapperService.responseMapper().map(entity,getResponseDTOClass());
        } else {
            return null;
        }
    }

    public PageResponseDTO<ResponseDTO> getAllFilter(BaseFilterRequestDTO baseFilterRequestDTO) {
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

        specification.setCriteriaList(baseFilterRequestDTO.getFilters());

        Page<Entity> entityPage = repository.findAll(specification,pageable);
        PageResponseDTO<ResponseDTO> responseDTO = new PageResponseDTO<>();
        responseDTO.setTotalElements(entityPage.getTotalElements());
        responseDTO.setTotalPages(entityPage.getTotalPages());
        responseDTO.setSize(entityPage.getSize());

        responseDTO.setSort(entityPage.getSort());
        responseDTO.setNumber(entityPage.getNumber());
        responseDTO.setHasContent(entityPage.hasContent());
        List<ResponseDTO> content = entityPage.getContent().stream().
                map(entity -> mapperService.responseMapper().map(entity,getResponseDTOClass())).toList();

        responseDTO.setContent(content);

        return responseDTO;
    }



}
