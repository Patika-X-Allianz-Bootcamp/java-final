package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class BankAccountRequestDTO extends BaseDTO {

    private String name;
    private String IBAN;
    private double amount;
}
