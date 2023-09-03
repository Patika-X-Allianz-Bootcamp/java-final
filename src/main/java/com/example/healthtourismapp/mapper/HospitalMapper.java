package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.HospitalEntity;
import com.example.healthtourismapp.model.HospitalDTO;
import com.example.healthtourismapp.model.requestDTO.HospitalRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class HospitalMapper implements IBaseMapper<HospitalEntity, HospitalDTO, HospitalRequestDTO> {

    private final BankAccountMapper bankAccountMapper;

    private final HealthServiceMapper healthServiceMapper;

    public HospitalMapper(BankAccountMapper bankAccountMapper, HealthServiceMapper healthServiceMapper) {
        this.bankAccountMapper = bankAccountMapper;
        this.healthServiceMapper = healthServiceMapper;
    }

    @Override
    public HospitalDTO entityToDTO(HospitalEntity entity) {

        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setHospitalName(entity.getHospitalName());
        hospitalDTO.setCity(entity.getCity());
        hospitalDTO.setId(entity.getId());
        hospitalDTO.setBankAccount(bankAccountMapper.entityToDTO(entity.getBankAccount()));
        hospitalDTO.setHealthServiceList(healthServiceMapper.entityListToDTOList(entity.getHealthServiceList()));
        hospitalDTO.setCreationDate(entity.getCreationDate());
        hospitalDTO.setUpdatedDate(entity.getUpdatedDate());
        hospitalDTO.setUuid(entity.getUuid());

        return hospitalDTO;
    }

    @Override
    public HospitalEntity dtoToEntity(HospitalDTO dto) {

        HospitalEntity hospitalEntity = new HospitalEntity();
        hospitalEntity.setHospitalName(dto.getHospitalName());
        hospitalEntity.setCity(dto.getCity());
        hospitalEntity.setId(dto.getId());
        hospitalEntity.setBankAccount(bankAccountMapper.dtoToEntity(dto.getBankAccount()));
        hospitalEntity.setHealthServiceList(healthServiceMapper.dtoListToEntityList(dto.getHealthServiceList()));
        hospitalEntity.setCreationDate(dto.getCreationDate());
        hospitalEntity.setUpdatedDate(dto.getUpdatedDate());
        hospitalEntity.setUuid(dto.getUuid());

        return hospitalEntity;
    }

    @Override
    public List<HospitalDTO> entityListToDTOList(List<HospitalEntity> hospitalEntities) {

        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for (HospitalEntity entity : hospitalEntities) {
            hospitalDTOS.add(entityToDTO(entity));
        }
        return hospitalDTOS;
    }

    @Override
    public List<HospitalEntity> dtoListToEntityList(List<HospitalDTO> hospitalDTOS) {

        List<HospitalEntity> hospitalEntities = new ArrayList<>();
        for (HospitalDTO dto : hospitalDTOS) {
            hospitalEntities.add(dtoToEntity(dto));
        }
        return hospitalEntities;
    }

    @Override
    public HospitalEntity requestDTOToEntity(HospitalRequestDTO hospitalRequestDTO) {

        HospitalEntity hospitalEntity = new HospitalEntity();
        hospitalEntity.setHospitalName(hospitalRequestDTO.getHospitalName());
        hospitalEntity.setCity(hospitalRequestDTO.getCity());
        hospitalEntity.setId(hospitalRequestDTO.getId());
        hospitalEntity.setBankAccount(bankAccountMapper.dtoToEntity(hospitalRequestDTO.getBankAccount()));
        hospitalEntity.setHealthServiceList(healthServiceMapper.dtoListToEntityList(hospitalRequestDTO.getHealthServiceList()));
        hospitalEntity.setCreationDate(hospitalRequestDTO.getCreationDate());
        hospitalEntity.setUpdatedDate(hospitalRequestDTO.getUpdatedDate());
        hospitalEntity.setUuid(hospitalRequestDTO.getUuid());

        return hospitalEntity;
    }

    @Override
    public List<HospitalEntity> requestDTOListToEntityList(List<HospitalRequestDTO> hospitalRequestDTOS) {

        List<HospitalEntity> hospitalEntities = new ArrayList<>();
        for (HospitalRequestDTO requestDTO : hospitalRequestDTOS) {
            hospitalEntities.add(requestDTOToEntity(requestDTO));
        }
        return hospitalEntities;
    }

    @Override
    public HospitalEntity requestDTOToExistEntity(HospitalRequestDTO hospitalRequestDTO, HospitalEntity entity) {

        entity.setHospitalName(hospitalRequestDTO.getHospitalName());
        entity.setCity(hospitalRequestDTO.getCity());
        entity.setId(hospitalRequestDTO.getId());
        entity.setBankAccount(bankAccountMapper.dtoToEntity(hospitalRequestDTO.getBankAccount()));
        entity.setHealthServiceList(healthServiceMapper.dtoListToEntityList(hospitalRequestDTO.getHealthServiceList()));
        entity.setCreationDate(hospitalRequestDTO.getCreationDate());
        entity.setUpdatedDate(hospitalRequestDTO.getUpdatedDate());
        entity.setUuid(hospitalRequestDTO.getUuid());

        return entity;
    }

    @Override
    public Page<HospitalDTO> pageEntityToPageDTO(Page<HospitalEntity> hospitalEntities) {
        return hospitalEntities.map(this::entityToDTO);
    }
}
