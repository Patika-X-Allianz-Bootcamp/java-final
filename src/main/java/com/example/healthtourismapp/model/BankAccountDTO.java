package com.example.healthtourismapp.model;

import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class BankAccountDTO extends BaseDTO {

    private String name;
    private String IBAN;
    private double amount;
}
