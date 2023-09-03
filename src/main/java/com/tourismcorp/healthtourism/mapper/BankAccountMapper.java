package com.tourismcorp.healthtourism.mapper;

import com.tourismcorp.healthtourism.database.entities.BankAccountEntity;
import com.tourismcorp.healthtourism.model.BankAccountDTO;
import com.tourismcorp.healthtourism.model.requestDTO.BankAccountRequestDTO;
import com.tourismcorp.healthtourism.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankAccountMapper implements IBaseMapper<BankAccountEntity, BankAccountDTO, BankAccountRequestDTO> {
    @Override
    public BankAccountDTO entityToDTO(BankAccountEntity entity) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setUuid(entity.getUuid());
        bankAccountDTO.setCreationDate(entity.getCreationDate());
        bankAccountDTO.setUpdatedDate(entity.getUpdatedDate());
        bankAccountDTO.setId(entity.getId());
        bankAccountDTO.setBankName(entity.getBankName());
        bankAccountDTO.setAccountNumber(entity.getAccountNumber());
        bankAccountDTO.setBalance(entity.getBalance());

        return bankAccountDTO;
    }

    @Override
    public BankAccountEntity dtoToEntity(BankAccountDTO dto) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setUuid(dto.getUuid());
        bankAccountEntity.setCreationDate(dto.getCreationDate());
        bankAccountEntity.setUpdatedDate(dto.getUpdatedDate());
        bankAccountEntity.setId(dto.getId());
        bankAccountEntity.setBankName(dto.getBankName());
        bankAccountEntity.setAccountNumber(dto.getAccountNumber());
        bankAccountEntity.setBalance(dto.getBalance());

        return bankAccountEntity;
    }

    @Override
    public List<BankAccountDTO> entityListToDTOList(List<BankAccountEntity> entityList) {
        List<BankAccountDTO> bankAccountDTOList = new ArrayList<>();
        for (BankAccountEntity entity : entityList) {
            BankAccountDTO dto = entityToDTO(entity);
            bankAccountDTOList.add(dto);
        }
        return bankAccountDTOList;
    }

    @Override
    public List<BankAccountEntity> dtoListToEntityList(List<BankAccountDTO> dtoList) {
        List<BankAccountEntity> bankAccountEntityList = new ArrayList<>();
        for (BankAccountDTO dto : dtoList) {
            BankAccountEntity entity = dtoToEntity(dto);
            bankAccountEntityList.add(entity);
        }
        return bankAccountEntityList;
    }

    @Override
    public BankAccountEntity requestDTOToEntity(BankAccountRequestDTO requestDTO) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        if (requestDTO == null)
            return bankAccountEntity;
        bankAccountEntity.setUuid(requestDTO.getUuid());
        bankAccountEntity.setCreationDate(requestDTO.getCreationDate());
        bankAccountEntity.setUpdatedDate(requestDTO.getUpdatedDate());
        bankAccountEntity.setId(requestDTO.getId());
        bankAccountEntity.setBankName(requestDTO.getBankName());
        bankAccountEntity.setAccountNumber(requestDTO.getAccountNumber());
        bankAccountEntity.setBalance(requestDTO.getBalance());

        return bankAccountEntity;
    }

    @Override
    public List<BankAccountEntity> requestDTOListToEntityList(List<BankAccountRequestDTO> dtoList) {
        List<BankAccountEntity> bankAccountEntityList = new ArrayList<>();
        for (BankAccountRequestDTO dto : dtoList) {
            BankAccountEntity entity = requestDTOToEntity(dto);
            bankAccountEntityList.add(entity);
        }
        return bankAccountEntityList;
    }

    @Override
    public BankAccountEntity requestDTOToExistEntity(BankAccountRequestDTO requestDTO, BankAccountEntity entity) {
        if (requestDTO.getBankName() != null)
            entity.setBankName(requestDTO.getBankName());
        if (requestDTO.getAccountNumber() != null)
            entity.setAccountNumber(requestDTO.getAccountNumber());
        if (requestDTO.getBalance() != null)
            entity.setBalance(requestDTO.getBalance());

        return entity;
    }

    @Override
    public Page<BankAccountDTO> pageEntityToPageDTO(Page<BankAccountEntity> entityPage) {
        return entityPage.map(this::entityToDTO);
    }
}
