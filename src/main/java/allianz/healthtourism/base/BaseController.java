package allianz.healthtourism.base;

import allianz.healthtourism.dto.Request.BaseFilterRequestDTO;
import allianz.healthtourism.dto.Response.PageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public abstract class BaseController<Entity extends BaseEntity, DTO extends BaseDTO, RequestDTO extends BaseRequestDTO,
        Repository extends BaseRepository<Entity>,
        Specification extends  BaseSpecification<Entity>,
        Service extends BaseService<Entity, DTO, RequestDTO, Repository, Specification>> {

    protected abstract Service getService();

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(getService().save(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("get-all-filter")
    public ResponseEntity<PageDTO<DTO>> getAll(@RequestBody BaseFilterRequestDTO baseFilterRequestDTO){
        return new ResponseEntity<>(getService().getAll(baseFilterRequestDTO), HttpStatus.OK);
    }

    @PutMapping("{uuid}")
    public ResponseEntity<DTO> update(@PathVariable UUID uuid, @RequestBody RequestDTO requestDTO){
        return new ResponseEntity<>(getService().update(uuid,requestDTO), HttpStatus.OK);
    }

    @DeleteMapping("{uuid}")
    public void delete(@PathVariable UUID uuid){
        getService().delete(uuid);

    }

    @GetMapping("{uuid}")
    public ResponseEntity<DTO> getByUuid(@PathVariable UUID uuid){
        return new ResponseEntity<>(getService().getByUuid(uuid), HttpStatus.OK);
    }
}
