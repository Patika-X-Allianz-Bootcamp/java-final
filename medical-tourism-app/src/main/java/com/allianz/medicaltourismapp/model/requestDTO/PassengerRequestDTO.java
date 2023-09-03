package com.allianz.medicaltourismapp.model.requestDTO;


import lombok.Data;

import java.util.List;

@Data

public class PassengerRequestDTO extends PersonRequestDTO {


    private List<TicketRequestDTO> ticket;
    private List<CreditCardRequestDTO> creditCards;

}
