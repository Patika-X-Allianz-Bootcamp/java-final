package com.example.healthtourismapp.model;

import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.util.List;

@Data
public class HospitalDTO extends BaseDTO {

    private String hospitalName;
    private String city;
    private List<HealthServiceDTO> healthServiceList;
    private BankAccountDTO bankAccount;
}
