package com.allianz.medicaltourismapp.util;

import com.allianz.medicaltourismapp.mapper.SeatMapper;
import com.allianz.medicaltourismapp.model.PageDTO;

import com.allianz.medicaltourismapp.util.dbutil.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public abstract class BaseController<E extends BaseEntity, D extends BaseDTO, Mapper extends BaseMapper<D, E>,
         Repo extends BaseRepository<E>, S extends BaseSpecification<E>,
        Service extends BaseService<D, E,  Repo, Mapper, S>> {
    protected abstract Service getService();

    protected abstract Mapper getMapper();
    @PostMapping ("/new/")
    public ResponseEntity<D> create(@RequestBody D dto) {
        return new ResponseEntity<>(getService().save(dto), HttpStatus.CREATED);
    }

    @PostMapping("/filter/{key}")
    public ResponseEntity<PageDTO<D>> getfilter(@PathVariable String key, @RequestBody SearchCriteria searchCriteria) {
        BaseFilterDTO baseFilterDTO = new BaseFilterDTO();
        baseFilterDTO.setPageSize(getService().getall().size());
        baseFilterDTO.setPageNumber(0);
        List<SearchCriteria> searchCriterias = new ArrayList<>();
        searchCriterias.add(searchCriteria);
        baseFilterDTO.setFilters(searchCriterias);
        baseFilterDTO.setSortDTO(null);
        return new ResponseEntity<>(getService().getfilter(baseFilterDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<D> update(@PathVariable UUID uuid, @RequestBody D dto){
        if (getService().update(uuid, dto) != null) {
            return new ResponseEntity<>(getService().update(uuid, dto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<D>> getall() {
        return new ResponseEntity<>(getService().getall(),HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid) {
        Boolean isDeleted = getService().deleteByUuid(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

}
