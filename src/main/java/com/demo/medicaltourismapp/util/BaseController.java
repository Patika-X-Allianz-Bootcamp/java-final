package com.demo.medicaltourismapp.util;

import com.demo.medicaltourismapp.model.PageDTO;
import com.demo.medicaltourismapp.model.requestDTO.BaseFilterRequestDTO;
import com.demo.medicaltourismapp.util.dbutil.BaseEntity;
import com.demo.medicaltourismapp.util.dbutil.BaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class BaseController<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDto extends BaseDTO,
        Mapper extends BaseMapper<Entity, DTO, RequestDto>,
        Repository extends BaseRepository<Entity>,
        Service extends BaseService<Entity, DTO, RequestDto, Mapper, Repository>> {

    protected abstract Service getService();


    @GetMapping("/get-all")
    public ResponseEntity<List<DTO>> getAll() {
        return new ResponseEntity<>(getService().getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<DTO> save(@RequestBody RequestDto requestDTO) {
        return new ResponseEntity<>(getService().save(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/get-all-by-filter")
    public ResponseEntity<PageDTO<DTO>> getAllByPageable(@RequestBody BaseFilterRequestDTO requestDto) {
        return new ResponseEntity<>(getService().getAllByPageable(requestDto), HttpStatus.OK);
    }


    @PutMapping("/{uuid}")
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