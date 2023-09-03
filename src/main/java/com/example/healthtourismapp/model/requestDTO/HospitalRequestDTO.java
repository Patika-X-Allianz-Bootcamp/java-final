package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.model.BankAccountDTO;
import com.example.healthtourismapp.model.HealthServiceDTO;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.util.List;

@Data
public class HospitalRequestDTO extends BaseDTO {

    private String hospitalName;
    private String city;
    private List<HealthServiceDTO> healthServiceList;
    private BankAccountDTO bankAccount;
}
