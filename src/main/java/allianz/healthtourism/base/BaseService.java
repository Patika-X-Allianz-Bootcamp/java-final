package allianz.healthtourism.base;

import allianz.healthtourism.dto.Request.BaseFilterRequestDTO;
import allianz.healthtourism.dto.Response.PageDTO;
import allianz.healthtourism.exception.BusinessException;
import allianz.healthtourism.mapper.ModelMapperManager;
import allianz.healthtourism.mapper.ModelMapperService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class BaseService<Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseRequestDTO,
        Repository extends BaseRepository<Entity>,
        Specification extends BaseSpecification<Entity>> {

    private final ModelMapperManager modelMapperManager;

    public BaseService(ModelMapperManager modelMapperManager) {
        this.modelMapperManager = modelMapperManager;
    }

    protected abstract Class<Entity> getEntity();

    protected abstract Repository getRepository();

    protected abstract Specification getSpecification();

    protected abstract Class<DTO> getDto();

    protected abstract Class<RequestDTO> getRequestDto();


    @Transactional
    public DTO save(RequestDTO requestDTO) {
        Entity entity = modelMapperManager.forRequest().map(requestDTO, getEntity());
        Entity savedEntity = getRepository().save(entity);
        DTO dto = modelMapperManager.forResponse().map(savedEntity, getDto());

        return dto;
    }

    public PageDTO<DTO> getAll(BaseFilterRequestDTO baseFilterRequestDTO) {
        Pageable pageable;
        if (baseFilterRequestDTO.getSortDTO() != null) {
            if (baseFilterRequestDTO.getSortDTO().getDirectionEnum() == Sort.Direction.ASC) {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).ascending());
            } else {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).descending());
            }
        } else {
            pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                    Sort.by("id").ascending());
        }

        getSpecification().setCriteriaList(baseFilterRequestDTO.getFilters());

        Page<Entity> entityPage = getRepository().findAll(getSpecification(), pageable);

        ModelMapper modelMapper = modelMapperManager.forResponse();
        List<DTO> dtoList = new ArrayList<>();
        for (Entity entity : entityPage.getContent()) {
            dtoList.add(modelMapper.map(entity, getDto()));
        }

        PageDTO<DTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(dtoList);  // List olarak atıyoruz
        pageDTO.setTotalPages(entityPage.getTotalPages());
        pageDTO.setTotalElements(entityPage.getTotalElements());
        pageDTO.setNumber(entityPage.getNumber());
        pageDTO.setSize(entityPage.getSize());
        pageDTO.setHasContent(entityPage.hasContent());
        pageDTO.setSort(entityPage.getSort());

        return pageDTO;
    }
    @Transactional
    public DTO update(UUID uuid, RequestDTO requestDTO) {
        Entity existingEntity = getRepository().findByUuid(uuid).orElseThrow(
                () -> new BusinessException("Entity not found with id: " + uuid));

        ModelMapper modelMapperForRequest = modelMapperManager.forRequest();
        modelMapperForRequest.map(requestDTO, existingEntity);
        Entity updatedEntity = getRepository().save(existingEntity);

        ModelMapper modelMapperForResponse = modelMapperManager.forResponse();
        DTO dto = modelMapperForResponse.map(updatedEntity, getDto());

        return dto;
    }

    @Transactional
    public void delete(UUID uuid) {
        Entity existingEntity = getRepository().findByUuid(uuid).orElseThrow(
                () -> new BusinessException("Entity not found with UUID: " + uuid));

        getRepository().delete(existingEntity);
    }
    public DTO getByUuid(UUID uuid) {
        Entity existingEntity = getRepository().findByUuid(uuid).orElseThrow(
                () -> new BusinessException("Entity not found with UUID: " + uuid));

        ModelMapper modelMapper = modelMapperManager.forResponse();
        DTO dto = modelMapper.map(existingEntity, getDto());

        return dto;
    }




}



