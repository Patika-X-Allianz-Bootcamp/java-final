package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.HealthServiceEntity;
import com.example.healthtourismapp.model.HealthServiceDTO;
import com.example.healthtourismapp.model.requestDTO.HealthServiceRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class HealthServiceMapper implements IBaseMapper<HealthServiceEntity, HealthServiceDTO, HealthServiceRequestDTO> {

    private final DoctorMapper doctorMapper;

    public HealthServiceMapper(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

    @Override
    public HealthServiceDTO entityToDTO(HealthServiceEntity entity) {

        HealthServiceDTO healthServiceDTO = new HealthServiceDTO();
        healthServiceDTO.setServiceName(entity.getServiceName());
        healthServiceDTO.setUuid(entity.getUuid());
        healthServiceDTO.setId(entity.getId());
        healthServiceDTO.setUpdatedDate(entity.getUpdatedDate());
        healthServiceDTO.setCreationDate(entity.getCreationDate());
        healthServiceDTO.setDoctorList(doctorMapper.entityListToDTOList(entity.getDoctorList()));

        return healthServiceDTO;
    }

    @Override
    public HealthServiceEntity dtoToEntity(HealthServiceDTO dto) {

        HealthServiceEntity healthServiceEntity = new HealthServiceEntity();
        healthServiceEntity.setServiceName(dto.getServiceName());
        healthServiceEntity.setDoctorList(doctorMapper.dtoListToEntityList(dto.getDoctorList()));
        healthServiceEntity.setUuid(dto.getUuid());
        healthServiceEntity.setUpdatedDate(dto.getUpdatedDate());
        healthServiceEntity.setId(dto.getId());

        return healthServiceEntity;
    }

    @Override
    public List<HealthServiceDTO> entityListToDTOList(List<HealthServiceEntity> healthServiceEntities) {

        List<HealthServiceDTO> healthServiceDTOS = new ArrayList<>();
        for (HealthServiceEntity entity : healthServiceEntities) {
            healthServiceDTOS.add(entityToDTO(entity));
        }
        return healthServiceDTOS;
    }

    @Override
    public List<HealthServiceEntity> dtoListToEntityList(List<HealthServiceDTO> healthServiceDTOS) {

        List<HealthServiceEntity> healthServiceEntities = new ArrayList<>();
        for (HealthServiceDTO dto : healthServiceDTOS) {
            healthServiceEntities.add(dtoToEntity(dto));
        }
        return healthServiceEntities;
    }

    @Override
    public HealthServiceEntity requestDTOToEntity(HealthServiceRequestDTO healthServiceRequestDTO) {

        HealthServiceEntity healthServiceEntity = new HealthServiceEntity();
        healthServiceEntity.setServiceName(healthServiceRequestDTO.getServiceName());
        healthServiceEntity.setDoctorList(doctorMapper.dtoListToEntityList(healthServiceRequestDTO.getDoctorList()));
        healthServiceEntity.setUuid(healthServiceRequestDTO.getUuid());
        healthServiceEntity.setUpdatedDate(healthServiceRequestDTO.getUpdatedDate());
        healthServiceEntity.setId(healthServiceRequestDTO.getId());

        return healthServiceEntity;
    }

    @Override
    public List<HealthServiceEntity> requestDTOListToEntityList(List<HealthServiceRequestDTO> healthServiceRequestDTOS) {

        List<HealthServiceEntity> healthServiceEntities = new ArrayList<>();
        for (HealthServiceRequestDTO requestDTO : healthServiceRequestDTOS) {
            healthServiceEntities.add(requestDTOToEntity(requestDTO));
        }
        return healthServiceEntities;
    }

    @Override
    public HealthServiceEntity requestDTOToExistEntity(HealthServiceRequestDTO healthServiceRequestDTO, HealthServiceEntity entity) {

        entity.setServiceName(healthServiceRequestDTO.getServiceName());
        entity.setDoctorList(doctorMapper.dtoListToEntityList(healthServiceRequestDTO.getDoctorList()));
        entity.setUuid(healthServiceRequestDTO.getUuid());
        entity.setUpdatedDate(healthServiceRequestDTO.getUpdatedDate());
        entity.setId(healthServiceRequestDTO.getId());

        return entity;
    }

    @Override
    public Page<HealthServiceDTO> pageEntityToPageDTO(Page<HealthServiceEntity> healthServiceEntities) {
        return healthServiceEntities.map(this::entityToDTO);
    }
}
