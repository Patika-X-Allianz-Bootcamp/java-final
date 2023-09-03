package com.tourismcorp.healthtourism.model;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class BankAccountDTO extends BaseDTO {

    private String bankName;
    private String accountNumber;
    private BigDecimal balance;

}
