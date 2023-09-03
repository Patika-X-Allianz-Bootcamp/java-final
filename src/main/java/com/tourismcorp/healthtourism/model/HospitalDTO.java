package com.tourismcorp.healthtourism.model;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;


@Data
public class HospitalDTO extends BaseDTO {
    private String hospitalName;

    private String phoneNumber;

    private String email;

    private List<DoctorDTO> doctor;

    private BankAccountDTO bankAccount;
}
