package com.allianz.patienttourism.util;

import com.allianz.patienttourism.model.requestDTO.BaseFilterRequestDTO;
import com.allianz.patienttourism.model.responseDTO.PageResponseDTO;
import com.allianz.patienttourism.util.dbutil.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class BaseController<Entity extends BaseEntity,ResponseDTO extends BaseResponseDTO,
        RequestDTO extends BaseRequestDTO> {

    private final BaseService<Entity,ResponseDTO,RequestDTO> service;

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ResponseDTO> save(@RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(service.save(requestDTO), HttpStatus.CREATED);
    }


    @PutMapping("{uuid}")
    public ResponseEntity<ResponseDTO> update(@PathVariable UUID uuid, @RequestBody RequestDTO requestDTO) {
        if (service.update(uuid, requestDTO) != null) {
            return new ResponseEntity<>(service.update(uuid, requestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<Boolean> deleteByUUID(@PathVariable UUID uuid) {
        Boolean isDeleted = service.deleteByUUID(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{uuid}")
    public ResponseEntity<ResponseDTO> getByUUID(@PathVariable UUID uuid) {
        ResponseDTO dto = service.getByUUID(uuid);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("get-all-filter")
    public ResponseEntity<PageResponseDTO<ResponseDTO>> getAll(@RequestBody BaseFilterRequestDTO baseFilterRequestDTO) {
        return new ResponseEntity<PageResponseDTO<ResponseDTO>>(service.getAllFilter(baseFilterRequestDTO), HttpStatus.OK);
    }


}
