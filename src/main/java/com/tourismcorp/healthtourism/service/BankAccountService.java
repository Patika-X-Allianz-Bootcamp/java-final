package com.tourismcorp.healthtourism.service;

import com.tourismcorp.healthtourism.database.entities.BankAccountEntity;
import com.tourismcorp.healthtourism.database.repositories.BankAccountRepository;
import com.tourismcorp.healthtourism.database.specification.BankAccountSpecification;
import com.tourismcorp.healthtourism.mapper.BankAccountMapper;
import com.tourismcorp.healthtourism.model.BankAccountDTO;
import com.tourismcorp.healthtourism.model.requestDTO.BankAccountRequestDTO;
import com.tourismcorp.healthtourism.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BankAccountService extends BaseService<
        BankAccountEntity,
        BankAccountDTO,
        BankAccountRequestDTO,
        BankAccountMapper,
        BankAccountRepository,
        BankAccountSpecification> {

    private final BankAccountRepository bankAccountRepository;

    private final BankAccountMapper bankAccountMapper;

    private final BankAccountSpecification bankAccountSpecification;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper, BankAccountSpecification bankAccountSpecification) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
        this.bankAccountSpecification = bankAccountSpecification;
    }


    @Override
    protected BankAccountMapper getMapper() {
        return this.bankAccountMapper;
    }

    @Override
    protected BankAccountRepository getRepository() {
        return this.bankAccountRepository;
    }

    @Override
    protected BankAccountSpecification getSpecification() {
        return this.bankAccountSpecification;
    }

}
