package patika.fhw.demo.util;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import patika.fhw.demo.database.entity.Appointment;
import patika.fhw.demo.model.requestDTO.BaseFilterRequestDTO;
import patika.fhw.demo.model.requestDTO.PageDTO;
import patika.fhw.demo.util.dbutil.BaseDTO;
import patika.fhw.demo.util.dbutil.BaseEntity;
import patika.fhw.demo.util.dbutil.BaseRepository;

public abstract class BaseService<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDTO extends BaseDTO,
        Mapper extends BaseMapper<DTO, Entity, RequestDTO>,
        Repository extends BaseRepository<Entity>,
        Specification extends BaseSpecification<Entity>
        > {
    
    protected abstract Mapper getMapper();

    protected abstract Repository getRepository();


    protected abstract Specification getSpecification();

    public DTO save(RequestDTO requestDTO) {
        Entity entity = getMapper().requestDTOToEntity(requestDTO);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }

    public PageDTO<DTO> getAll(BaseFilterRequestDTO baseFilterRequestDTO) {
        Pageable pageable;
        if (baseFilterRequestDTO.getSortDTO() != null) {
            if (baseFilterRequestDTO.getSortDTO().getDirectionEnum() == Sort.Direction.ASC) {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).ascending());
            } else {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).descending());
            }
        } else {
            pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),baseFilterRequestDTO.getPageSize(),
                    Sort.by("id").ascending());
        }

        getSpecification().setCriteriaList(baseFilterRequestDTO.getFilters());

        Page<Entity> entityPage = getRepository().findAll(getSpecification(),pageable);
        return getMapper().pageEntityToPageDTO(entityPage);
    }

    public DTO update(UUID uuid, RequestDTO requestDTO) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            entity = getMapper().requestDtoToExistEntity(entity, requestDTO);
            getRepository().save(entity);
            return getMapper().entityToDTO(entity);
        } else {
            return null;
        }
    }

    public DTO getByUUID(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            return getMapper().entityToDTO(entity);
        } else {
            return null;
        }
    }

    public Boolean deleteByUUID(UUID uuid) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);
        if (entity != null) {
            getRepository().delete(entity);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    } 

    public void invalidateExpiredAppointments() {
    List<Entity> entities = getRepository().findAll();
    
    LocalDateTime currentTime = LocalDateTime.now();
    
    for (Entity entity : entities) {
        if (entity instanceof Appointment) { // Eğer Entity'nin tipi 'Appointment' ise
            Appointment appointment = (Appointment) entity;
            
            LocalDateTime creationTime = appointment.getCreationTimestamp();
            if (creationTime.plusMinutes(10).isBefore(currentTime)) {
                appointment.setValid(false);
                getRepository().save(entity);
            }
        }
    }
}



}