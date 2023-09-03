package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.model.BankAccountDTO;
import com.tourismcorp.healthtourism.model.DoctorDTO;
import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;


@Data
public class HospitalRequestDTO extends BaseDTO {
    private String hospitalName;

    private String phoneNumber;

    private String email;

    private List<DoctorRequestDTO> doctor;

    private BankAccountRequestDTO bankAccount;
}
