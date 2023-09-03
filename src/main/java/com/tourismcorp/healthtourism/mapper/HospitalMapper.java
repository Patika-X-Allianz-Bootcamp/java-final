package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.HospitalEntity;
import com.tourismcorp.healthtourism.model.HospitalDTO;
import com.tourismcorp.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HospitalMapper implements IBaseMapper<HospitalEntity, HospitalDTO, HospitalRequestDTO> {

    private final DoctorMapper doctorMapper;
    private final BankAccountMapper bankAccountMapper;

    @Autowired
    protected HospitalMapper(@Lazy DoctorMapper doctorMapper, BankAccountMapper bankAccountMapper) {
        this.doctorMapper = doctorMapper;
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public HospitalDTO entityToDTO(HospitalEntity entity) {
        HospitalDTO dto = new HospitalDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setHospitalName(entity.getHospitalName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        dto.setDoctor(doctorMapper.entityListToDTOList(entity.getDoctor()));
        if (entity.getBankAccount() == null)
            dto.setBankAccount(null);
        else
            dto.setBankAccount(bankAccountMapper.entityToDTO(entity.getBankAccount()));

        return dto;
    }

    @Override
    public HospitalEntity dtoToEntity(HospitalDTO dto) {
        HospitalEntity entity = new HospitalEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setHospitalName(dto.getHospitalName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setDoctor(doctorMapper.dtoListToEntityList(dto.getDoctor()));
        if (dto.getBankAccount() == null)
            entity.setBankAccount(null);
        else
            entity.setBankAccount(bankAccountMapper.dtoToEntity(dto.getBankAccount()));

        return entity;
    }

    @Override
    public List<HospitalDTO> entityListToDTOList(List<HospitalEntity> entityList) {
        List<HospitalDTO> dtoList = new ArrayList<>();
        for (HospitalEntity entity : entityList) {
            HospitalDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<HospitalEntity> dtoListToEntityList(List<HospitalDTO> dtoList) {
        List<HospitalEntity> entityList = new ArrayList<>();
        for (HospitalDTO dto : dtoList) {
            HospitalEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public HospitalEntity requestDTOToEntity(HospitalRequestDTO requestDTO) {
        HospitalEntity entity = new HospitalEntity();
        entity.setId(requestDTO.getId());
        entity.setUuid(requestDTO.getUuid());
        entity.setCreationDate(requestDTO.getCreationDate());
        entity.setUpdatedDate(requestDTO.getUpdatedDate());
        entity.setHospitalName(requestDTO.getHospitalName());
        entity.setPhoneNumber(requestDTO.getPhoneNumber());
        entity.setEmail(requestDTO.getEmail());
        entity.setDoctor(doctorMapper.requestDTOListToEntityList(requestDTO.getDoctor()));
        if (requestDTO.getBankAccount() == null)
            entity.setBankAccount(null);
        else
            entity.setBankAccount(bankAccountMapper.requestDTOToEntity(requestDTO.getBankAccount()));

        return entity;
    }

    @Override
    public List<HospitalEntity> requestDTOListToEntityList(List<HospitalRequestDTO> dtoList) {
        List<HospitalEntity> entityList = new ArrayList<>();
        for (HospitalRequestDTO dto : dtoList) {
            HospitalEntity entity = requestDTOToEntity(dto);
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public HospitalEntity requestDTOToExistEntity(HospitalRequestDTO requestDTO, HospitalEntity entity) {
        if (requestDTO.getHospitalName() != null)
            entity.setHospitalName(requestDTO.getHospitalName());
        if (requestDTO.getPhoneNumber() != null)
            entity.setPhoneNumber(requestDTO.getPhoneNumber());
        if (requestDTO.getEmail() != null)
            entity.setEmail(requestDTO.getEmail());
        if (requestDTO.getDoctor() != null)
            entity.setDoctor(doctorMapper.requestDTOListToEntityList(requestDTO.getDoctor()));
        if (requestDTO.getBankAccount() != null)
            entity.setBankAccount(bankAccountMapper.requestDTOToEntity(requestDTO.getBankAccount()));

        return entity;
    }

    @Override
    public Page<HospitalDTO> pageEntityToPageDTO(Page<HospitalEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
