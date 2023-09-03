package com.aslihanhasar.medicaltourismapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketPurchaseRequest {
    @NotBlank
    private String patientNumber;
    @NotNull
    private Long flightId;
    @NotNull
    private int passengerCount;
    @NotBlank
    private String ticketClass;
    @NotBlank
    private String creditCardNumber;
}
