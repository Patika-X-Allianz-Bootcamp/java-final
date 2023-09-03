package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class GuestRequestDTO extends BaseDTO {
        private List<CreditCardRequestDTO> creditCards;
        private List<ReservationRequestDTO> reservation;
}
