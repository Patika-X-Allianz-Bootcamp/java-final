package com.allianz.medicaltourism.util;

import com.allianz.medicaltourism.model.requestDTO.BaseFilterRequestDTO;
import com.allianz.medicaltourism.model.requestDTO.PageRequestDTO;
import com.allianz.medicaltourism.service.BaseService;
import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class BaseController<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDto extends BaseDTO,
        Mapper extends IBaseMapper<DTO, Entity, RequestDto>,
        Repository extends BaseRepository<Entity>,
        Specification extends  BaseSpecification<Entity>,
        Service extends BaseService<Entity, DTO, RequestDto, Mapper, Repository, Specification>> {

    protected abstract Service getService();

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody RequestDto requestDTO) {
        return new ResponseEntity<>(getService().save(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("get-all-filter")
    public ResponseEntity<PageRequestDTO<DTO>> getAll(@RequestBody BaseFilterRequestDTO baseFilterRequestDTO) throws Exception{
        if(baseFilterRequestDTO.getPageSize() <= 0)
            throw new IllegalArgumentException("Page size must be greater than 0");
        return new ResponseEntity<>(getService().getAll(baseFilterRequestDTO), HttpStatus.OK);
    }

    @PutMapping("{uuid}")
    public ResponseEntity<DTO> update(@PathVariable UUID uuid, @RequestBody RequestDto requestDTO) {
        if (getService().update(uuid, requestDTO) != null) {
            return new ResponseEntity<>(getService().update(uuid, requestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<Boolean> deleteByUUID(@PathVariable UUID uuid) {
        Boolean isDeleted = getService().deleteByUUID(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{uuid}")
    public ResponseEntity<DTO> getByUUID(@PathVariable UUID uuid) {
        DTO dto = getService().getByUUID(uuid);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}