package com.allianz.HealthTourismSpringBoot.model.requestDTO;


import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class BookingRequestDTO extends BaseDTO {

    private ClientRequestDTO client;
    private PlaneRequestDTO plane;
    private String planeSeat;
    private String departureLocation;
    private String arrivalLocation;
    private Date flightDate;
    private HotelRequestDTO hotel;
    private int roomNumber;
    private Date checkingDate;
    private Date checkoutDate;
}
