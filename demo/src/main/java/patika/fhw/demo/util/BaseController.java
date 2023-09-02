package patika.fhw.demo.util;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import patika.fhw.demo.model.requestDTO.BaseFilterRequestDTO;
import patika.fhw.demo.model.requestDTO.PageDTO;
import patika.fhw.demo.util.dbutil.BaseDTO;
import patika.fhw.demo.util.dbutil.BaseEntity;
import patika.fhw.demo.util.dbutil.BaseRepository;

public abstract class BaseController<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDto extends BaseDTO,
        Mapper extends BaseMapper<DTO, Entity, RequestDto>,
        Repository extends BaseRepository<Entity>,
        Specification extends  BaseSpecification<Entity>,
        Service extends BaseService<Entity, DTO, RequestDto, Mapper, Repository, Specification>> {

    protected abstract Service getService();

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody RequestDto requestDTO) {
        return new ResponseEntity<>(getService().save(requestDTO), HttpStatus.CREATED);
    }

    @PostMapping("get-all-filter")
    public ResponseEntity<PageDTO<DTO>> getAll(@RequestBody BaseFilterRequestDTO baseFilterRequestDTO) {
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
    @Secured({"ROLE_USER, ROLE_PATIENT}"})
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
