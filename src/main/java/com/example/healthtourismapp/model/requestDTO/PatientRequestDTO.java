package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.model.BankAccountDTO;
import com.example.healthtourismapp.model.enums.GenderEnum;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.util.List;

@Data
public class PatientRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private int age;
    private GenderEnum gender;
    private String tc;
    private List<BankAccountDTO> bankAccount;
}
