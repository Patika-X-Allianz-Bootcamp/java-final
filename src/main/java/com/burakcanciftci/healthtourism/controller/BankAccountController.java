package com.burakcanciftci.healthtourism.controller;

import com.burakcanciftci.healthtourism.database.entity.BankAccountEntity;
import com.burakcanciftci.healthtourism.model.requestDTO.BankAccountRequestDTO;
import com.burakcanciftci.healthtourism.model.responseDTO.BankAccountResponseDTO;
import com.burakcanciftci.healthtourism.service.BankAccountService;
import com.burakcanciftci.healthtourism.util.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bank-account")
@AllArgsConstructor
public class BankAccountController extends BaseController<BankAccountEntity, BankAccountResponseDTO, BankAccountRequestDTO> {
    private final BankAccountService bankAccountService;

    @Override
    protected BankAccountService getService() {
        return this.bankAccountService;
    }
}
