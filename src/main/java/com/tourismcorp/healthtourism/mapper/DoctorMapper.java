package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.DoctorEntity;
import com.tourismcorp.healthtourism.model.DoctorDTO;
import com.tourismcorp.healthtourism.model.requestDTO.DoctorRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper implements IBaseMapper<DoctorEntity, DoctorDTO, DoctorRequestDTO> {

    private final RoleMapper roleMapper;
    private final HospitalMapper hospitalMapper;

    @Autowired
    protected DoctorMapper(RoleMapper roleMapper,@Lazy HospitalMapper hospitalMapper) {
        this.roleMapper = roleMapper;
        this.hospitalMapper = hospitalMapper;
    }
    @Override
    public DoctorDTO entityToDTO(DoctorEntity entity) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setUuid(entity.getUuid());
        doctorDTO.setCreationDate(entity.getCreationDate());
        doctorDTO.setUpdatedDate(entity.getUpdatedDate());
        doctorDTO.setId(entity.getId());
        doctorDTO.setFirstName(entity.getFirstName());
        doctorDTO.setLastName(entity.getLastName());
        doctorDTO.setField(entity.getField());
        doctorDTO.setEmail(entity.getEmail());
        doctorDTO.setPassword(entity.getPassword());
        doctorDTO.setUsername(entity.getUsername());
        doctorDTO.setRoles(roleMapper.entityListToDTOList(entity.getRoles()));

        return doctorDTO;
    }

    @Override
    public DoctorEntity dtoToEntity(DoctorDTO dto) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setUuid(dto.getUuid());
        doctorEntity.setCreationDate(dto.getCreationDate());
        doctorEntity.setUpdatedDate(dto.getUpdatedDate());
        doctorEntity.setId(dto.getId());
        doctorEntity.setFirstName(dto.getFirstName());
        doctorEntity.setLastName(dto.getLastName());
        doctorEntity.setField(dto.getField());
        doctorEntity.setEmail(dto.getEmail());
        doctorEntity.setPassword(dto.getPassword());
        doctorEntity.setUsername(dto.getUsername());
        doctorEntity.setRoles(roleMapper.dtoListToEntityList(dto.getRoles()));

        return doctorEntity;
    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<DoctorEntity> entityList) {
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        for (DoctorEntity entity : entityList) {
            DoctorDTO dto = entityToDTO(entity);
            doctorDTOList.add(dto);
        }
        return doctorDTOList;
    }

    @Override
    public List<DoctorEntity> dtoListToEntityList(List<DoctorDTO> dtoList) {
        List<DoctorEntity> doctorEntityList = new ArrayList<>();
        for (DoctorDTO dto : dtoList) {
            DoctorEntity entity = dtoToEntity(dto);
            doctorEntityList.add(entity);
        }
        return doctorEntityList;
    }

    @Override
    public DoctorEntity requestDTOToEntity(DoctorRequestDTO requestDTO) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setUuid(requestDTO.getUuid());
        doctorEntity.setCreationDate(requestDTO.getCreationDate());
        doctorEntity.setUpdatedDate(requestDTO.getUpdatedDate());
        doctorEntity.setId(requestDTO.getId());
        doctorEntity.setFirstName(requestDTO.getFirstName());
        doctorEntity.setLastName(requestDTO.getLastName());
        doctorEntity.setField(requestDTO.getField());
        doctorEntity.setEmail(requestDTO.getEmail());
        doctorEntity.setPassword(requestDTO.getPassword());
        doctorEntity.setUsername(requestDTO.getUsername());
        doctorEntity.setRoles(roleMapper.dtoListToEntityList(requestDTO.getRoles()));

        return doctorEntity;
    }

    @Override
    public List<DoctorEntity> requestDTOListToEntityList(List<DoctorRequestDTO> dtoList) {
        List<DoctorEntity> doctorEntityList = new ArrayList<>();
        if (dtoList == null)
            return doctorEntityList;
        for (DoctorRequestDTO dto : dtoList) {
            DoctorEntity entity = requestDTOToEntity(dto);
            doctorEntityList.add(entity);
        }
        return doctorEntityList;
    }

    @Override
    public DoctorEntity requestDTOToExistEntity(DoctorRequestDTO requestDTO, DoctorEntity entity) {
        if (requestDTO.getFirstName() != null)
            entity.setFirstName(requestDTO.getFirstName());
        if (requestDTO.getLastName() != null)
            entity.setLastName(requestDTO.getLastName());
        if (requestDTO.getField() != null)
            entity.setField(requestDTO.getField());
        if (requestDTO.getRoles() != null)
            entity.setRoles(roleMapper.dtoListToEntityList(requestDTO.getRoles()));
        if (requestDTO.getEmail() != null)
            entity.setEmail(requestDTO.getEmail());
        if (requestDTO.getPassword() != null)
            entity.setPassword(requestDTO.getPassword());
        if (requestDTO.getUsername() != null)
            entity.setUsername(requestDTO.getUsername());



        return entity;
    }

    public Page<DoctorDTO> pageEntityToPageDTO(Page<DoctorEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
