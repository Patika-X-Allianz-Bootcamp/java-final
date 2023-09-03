package com.example.healthtourismapp.model;

import com.example.healthtourismapp.model.enums.GenderEnum;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.util.List;

@Data
public class PatientDTO extends BaseDTO {

    private String name;
    private String surname;
    private int age;
    private GenderEnum gender;
    private String tc;
    private List<BankAccountDTO> bankAccount;
}
