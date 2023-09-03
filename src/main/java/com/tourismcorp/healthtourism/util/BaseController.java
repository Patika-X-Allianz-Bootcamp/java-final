package com.tourismcorp.healthtourism.util;

import com.tourismcorp.healthtourism.model.requestDTO.BaseFilterRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class BaseController<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseDTO,
        Mapper extends IBaseMapper<Entity, DTO, RequestDTO>,
        Repository extends IBaseRepository<Entity>,
        Specification extends BaseSpecification<Entity>,
        Service extends BaseService<Entity, DTO, RequestDTO, Mapper, Repository, Specification>> {

    protected abstract Service getService();

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(getService().save(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("get-all-filter")
    public ResponseEntity<Page<DTO>> getAllWithFilter(@RequestBody BaseFilterRequestDTO baseFilterRequestDTO) {
        return new ResponseEntity<>(getService().getAllWithFilterAndPagination(baseFilterRequestDTO), HttpStatus.OK);
    }

    @PutMapping("{uuid}")
    public ResponseEntity<DTO> update(@PathVariable UUID uuid, @RequestBody RequestDTO requestDTO) {
        if (getService().update(uuid, requestDTO) != null) {
            return new ResponseEntity<>(getService().update(uuid, requestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<DTO> deleteByUUID(@PathVariable UUID uuid) {
        DTO isDeleted = getService().deleteByUUID(uuid);
        if (isDeleted != null) {
            return new ResponseEntity<>(isDeleted, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

    @GetMapping
    public ResponseEntity<List<DTO>> getAll() {
        List<DTO> dto = getService().getAll();

        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}