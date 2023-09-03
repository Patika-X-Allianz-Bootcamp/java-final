package com.burakcanciftci.healthtourism.util;

import com.burakcanciftci.healthtourism.model.PageDTO;
import com.burakcanciftci.healthtourism.model.requestDTO.BaseFilterRequestDTO;
import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class BaseController<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseDTO> {

    protected abstract BaseService<Entity, DTO, RequestDTO> getService();

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(getService().save(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("get-all-filter")
    public ResponseEntity<PageDTO<DTO>> getAll(@RequestBody BaseFilterRequestDTO baseFilterRequestDTO) {
        return new ResponseEntity<>(getService().getAll(baseFilterRequestDTO), HttpStatus.OK);
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