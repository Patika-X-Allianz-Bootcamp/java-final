package com.allianz.medicaltourismapp.model;


import lombok.Data;

import java.util.List;

@Data
public class PatientDTO extends PersonDTO {
    private String prescription;
    private List<AppointmentDTO> appointmentCode;
    private List<CreditCardDTO> ccNumber;


}
