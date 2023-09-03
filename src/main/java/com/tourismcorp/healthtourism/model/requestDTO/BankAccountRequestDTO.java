package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;


@Data
public class BankAccountRequestDTO extends BaseDTO {

    private String bankName;
    private String accountNumber;
    private BigDecimal balance;

}
