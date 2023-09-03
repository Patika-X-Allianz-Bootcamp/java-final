package com.allianz.medicaltourismapp.model;



import lombok.Data;

import java.util.List;

@Data

public class PassengerDTO extends PersonDTO {


    private List<TicketDTO> ticketCode;
    private List<CreditCardDTO> creditCardNumber;

}
