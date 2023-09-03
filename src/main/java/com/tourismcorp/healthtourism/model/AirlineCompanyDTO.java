package com.tourismcorp.healthtourism.model;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class AirlineCompanyDTO extends BaseDTO {

    private String companyName;

    private String phoneNumber;

    private String email;


    private List<FlightDTO> flight;


    private BankAccountDTO bankAccount;
}
