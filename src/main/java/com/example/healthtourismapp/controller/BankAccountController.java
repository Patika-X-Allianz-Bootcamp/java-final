package com.example.healthtourismapp.controller;

import com.example.healthtourismapp.database.entities.BankAccountEntity;
import com.example.healthtourismapp.database.repositories.BankAccountRepository;
import com.example.healthtourismapp.database.specification.BankAccountSpecification;
import com.example.healthtourismapp.mapper.BankAccountMapper;
import com.example.healthtourismapp.model.BankAccountDTO;
import com.example.healthtourismapp.model.requestDTO.BankAccountRequestDTO;
import com.example.healthtourismapp.service.BankAccountService;
import com.example.healthtourismapp.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController extends BaseController<BankAccountEntity, BankAccountDTO, BankAccountRequestDTO,
        BankAccountMapper, BankAccountRepository, BankAccountSpecification, BankAccountService> {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    protected BankAccountService getService() {
        return bankAccountService;
    }
}
