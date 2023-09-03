package com.tourismcorp.healthtourism.controller;

import com.tourismcorp.healthtourism.database.entities.BankAccountEntity;
import com.tourismcorp.healthtourism.database.repositories.BankAccountRepository;
import com.tourismcorp.healthtourism.database.specification.BankAccountSpecification;
import com.tourismcorp.healthtourism.mapper.BankAccountMapper;
import com.tourismcorp.healthtourism.model.BankAccountDTO;
import com.tourismcorp.healthtourism.model.requestDTO.BankAccountRequestDTO;
import com.tourismcorp.healthtourism.service.BankAccountService;
import com.tourismcorp.healthtourism.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bank-account")
public class BankAccountController extends BaseController<
        BankAccountEntity,
        BankAccountDTO,
        BankAccountRequestDTO,
        BankAccountMapper,
        BankAccountRepository,
        BankAccountSpecification,
        BankAccountService> {

    @Autowired
    BankAccountService bankAccountService;

    @Override
    protected BankAccountService getService() {
        return this.bankAccountService;
    }
}

