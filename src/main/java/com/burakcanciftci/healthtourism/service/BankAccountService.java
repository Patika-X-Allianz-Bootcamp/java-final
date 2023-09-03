package com.burakcanciftci.healthtourism.service;

import com.burakcanciftci.healthtourism.database.entity.BankAccountEntity;
import com.burakcanciftci.healthtourism.database.repository.BankAccountEntityRepository;
import com.burakcanciftci.healthtourism.database.specification.BankAccountSpecification;
import com.burakcanciftci.healthtourism.mapper.BankAccountMapper;
import com.burakcanciftci.healthtourism.model.requestDTO.BankAccountRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.BankAccountResponseDTO;
import com.burakcanciftci.healthtourism.util.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@Service
public class BankAccountService extends BaseService<BankAccountEntity, BankAccountResponseDTO, BankAccountRequestDTO> {

    private final BankAccountEntityRepository bankAccountEntityRepository;
    private final BankAccountMapper bankAccountMapper;
    private final BankAccountSpecification bankAccountSpecification;

    @Override
    protected BankAccountMapper getMapper() {
        return this.bankAccountMapper;
    }

    @Override
    protected BankAccountEntityRepository getRepository() {
        return this.bankAccountEntityRepository;
    }

    @Override
    protected BankAccountSpecification getSpecification() {
        return bankAccountSpecification;
    }

    public BankAccountResponseDTO addMoneyToBankAccount(Set<BankAccountEntity> bankAccountEntitySet, BigDecimal amount){
        if(bankAccountEntitySet != null && bankAccountEntitySet.size() > 0){
            for(BankAccountEntity bankAccount : bankAccountEntitySet){
                bankAccount.setAmount(bankAccount.getAmount().add(amount));

                bankAccountEntityRepository.save(bankAccount);
               return bankAccountMapper.entityToDTO(bankAccount);
            }
        }

        return null;
    }
}