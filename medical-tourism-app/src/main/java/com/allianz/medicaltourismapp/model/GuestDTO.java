package com.allianz.medicaltourismapp.model;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;

import lombok.Data;

import java.util.List;

@Data
public class GuestDTO extends PersonDTO {
        private List<CreditCardDTO> ccNumbers;
        private List<ReservationDTO> reservationCodes;
}
