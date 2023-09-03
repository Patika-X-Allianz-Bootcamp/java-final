package com.allianz.healthtourism.util;

import com.allianz.healthtourism.util.dbUtil.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class BaseController<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseDTO,
        Mapper extends IBaseMapper<DTO, Entity, RequestDTO>,
        Repository extends BaseRepository<Entity>,
        Service extends BaseService<Entity, DTO, RequestDTO, Mapper, Repository>
        > {
    abstract protected Service getService();



    @GetMapping("{uuid}")
    public ResponseEntity<DTO> getByUuid(@PathVariable UUID uuid){
        DTO dto = getService().getByUUID(uuid);

        if (dto != null){
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<DTO> save(@RequestBody RequestDTO dto){
        return new ResponseEntity<>(getService().save(dto), HttpStatus.CREATED);
    }


    @PutMapping("{uuid}")
    public ResponseEntity<DTO> update(@PathVariable UUID uuid, @RequestBody RequestDTO dto){
        if(getService().update(uuid, dto) != null)
        {
            return new ResponseEntity<>(getService().update(uuid, dto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid){
        Boolean isDeleted = getService().deleteByUUID(uuid);
        if(isDeleted){
            return new ResponseEntity<>(isDeleted, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(isDeleted, HttpStatus.NOT_FOUND);
        }
    }
}
