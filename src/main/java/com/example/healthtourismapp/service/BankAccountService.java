package com.example.healthtourismapp.service;

import com.example.healthtourismapp.database.entities.BankAccountEntity;
import com.example.healthtourismapp.database.repositories.BankAccountRepository;
import com.example.healthtourismapp.database.specification.BankAccountSpecification;
import com.example.healthtourismapp.mapper.BankAccountMapper;
import com.example.healthtourismapp.model.BankAccountDTO;
import com.example.healthtourismapp.model.requestDTO.BankAccountRequestDTO;
import com.example.healthtourismapp.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService extends BaseService<
        BankAccountEntity,
        BankAccountDTO,
        BankAccountRequestDTO,
        BankAccountMapper,
        BankAccountRepository, BankAccountSpecification> {

    private final BankAccountMapper bankAccountMapper;
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountSpecification bankAccountSpecification;

    public BankAccountService(BankAccountMapper bankAccountMapper, BankAccountRepository bankAccountRepository, BankAccountSpecification bankAccountSpecification) {
        this.bankAccountMapper = bankAccountMapper;
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountSpecification = bankAccountSpecification;
    }

    @Override
    public BankAccountMapper getMapper() {
        return bankAccountMapper;
    }

    @Override
    public BankAccountRepository getRepository() {
        return bankAccountRepository;
    }

    @Override
    protected BankAccountSpecification getSpecification() {
        return bankAccountSpecification;
    }
}
