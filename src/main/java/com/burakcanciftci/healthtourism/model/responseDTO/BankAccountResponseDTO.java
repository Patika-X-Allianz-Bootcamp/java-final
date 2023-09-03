package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountResponseDTO extends BaseDTO {
    BigDecimal amount;
    String ibanCode;
}
