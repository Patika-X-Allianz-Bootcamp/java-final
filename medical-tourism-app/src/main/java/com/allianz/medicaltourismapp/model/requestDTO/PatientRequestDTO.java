package com.allianz.medicaltourismapp.model.requestDTO;

import lombok.Data;

import java.util.List;

@Data
public class PatientRequestDTO extends PersonRequestDTO {
    private String prescription;
    private List<AppointmentRequestDTO> appointments;
    private List<CreditCardRequestDTO> creditCards;


}
