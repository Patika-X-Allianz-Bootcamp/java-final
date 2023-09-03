package com.example.healthtourismapp.mapper;

import com.example.healthtourismapp.database.entities.BankAccountEntity;
import com.example.healthtourismapp.model.BankAccountDTO;
import com.example.healthtourismapp.model.requestDTO.BankAccountRequestDTO;
import com.example.healthtourismapp.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class BankAccountMapper implements IBaseMapper<BankAccountEntity, BankAccountDTO, BankAccountRequestDTO> {
    @Override
    public BankAccountDTO entityToDTO(BankAccountEntity entity) {

        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setId(entity.getId());
        bankAccountDTO.setUuid(entity.getUuid());
        bankAccountDTO.setCreationDate(entity.getCreationDate());
        bankAccountDTO.setName(entity.getName());
        bankAccountDTO.setIBAN(entity.getIBAN());
        bankAccountDTO.setAmount(entity.getAmount());
        bankAccountDTO.setUpdatedDate(entity.getUpdatedDate());

        return bankAccountDTO;
    }

    @Override
    public BankAccountEntity dtoToEntity(BankAccountDTO dto) {

        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setId(dto.getId());
        bankAccountEntity.setUuid(dto.getUuid());
        bankAccountEntity.setCreationDate(dto.getCreationDate());
        bankAccountEntity.setName(dto.getName());
        bankAccountEntity.setIBAN(dto.getIBAN());
        bankAccountEntity.setAmount(dto.getAmount());
        bankAccountEntity.setUpdatedDate(dto.getUpdatedDate());

        return bankAccountEntity;
    }

    @Override
    public List<BankAccountDTO> entityListToDTOList(List<BankAccountEntity> bankAccountEntities) {

        List<BankAccountDTO> bankAccountDTOS = new ArrayList<>();
        for (BankAccountEntity entity : bankAccountEntities) {
            bankAccountDTOS.add(entityToDTO(entity));
        }
        return bankAccountDTOS;
    }

    @Override
    public List<BankAccountEntity> dtoListToEntityList(List<BankAccountDTO> bankAccountDTOS) {

        List<BankAccountEntity> bankAccountEntities = new ArrayList<>();
        for (BankAccountDTO dto : bankAccountDTOS) {
            bankAccountEntities.add(dtoToEntity(dto));
        }
        return bankAccountEntities;
    }

    @Override
    public BankAccountEntity requestDTOToEntity(BankAccountRequestDTO bankAccountRequestDTO) {

        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setId(bankAccountRequestDTO.getId());
        bankAccountEntity.setUuid(bankAccountRequestDTO.getUuid());
        bankAccountEntity.setCreationDate(bankAccountRequestDTO.getCreationDate());
        bankAccountEntity.setName(bankAccountRequestDTO.getName());
        bankAccountEntity.setIBAN(bankAccountRequestDTO.getIBAN());
        bankAccountEntity.setAmount(bankAccountRequestDTO.getAmount());
        bankAccountEntity.setUpdatedDate(bankAccountRequestDTO.getUpdatedDate());

        return bankAccountEntity;
    }

    @Override
    public List<BankAccountEntity> requestDTOListToEntityList(List<BankAccountRequestDTO> bankAccountRequestDTOS) {

        List<BankAccountEntity> bankAccountEntities = new ArrayList<>();
        for (BankAccountRequestDTO requestDTO : bankAccountRequestDTOS) {
            bankAccountEntities.add(requestDTOToEntity(requestDTO));
        }
        return bankAccountEntities;
    }

    @Override
    public BankAccountEntity requestDTOToExistEntity(BankAccountRequestDTO bankAccountRequestDTO, BankAccountEntity entity) {

        entity.setId(bankAccountRequestDTO.getId());
        entity.setUuid(bankAccountRequestDTO.getUuid());
        entity.setCreationDate(bankAccountRequestDTO.getCreationDate());
        entity.setName(bankAccountRequestDTO.getName());
        entity.setIBAN(bankAccountRequestDTO.getIBAN());
        entity.setAmount(bankAccountRequestDTO.getAmount());
        entity.setUpdatedDate(bankAccountRequestDTO.getUpdatedDate());

        return entity;
    }

    @Override
    public Page<BankAccountDTO> pageEntityToPageDTO(Page<BankAccountEntity> bankAccountEntities) {
        return bankAccountEntities.map(this::entityToDTO);
    }
}
