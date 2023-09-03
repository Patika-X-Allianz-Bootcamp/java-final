package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountRequestDTO extends BaseDTO {
    BigDecimal amount;
    String ibanCode;
}
