package com.allianz.HealthTourismSpringBoot.model;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class BookingDTO extends BaseDTO {

    private ClientDTO client;
    private PlaneDTO plane;
    private String planeSeat;
    private String departureLocation;
    private String arrivalLocation;
    private Date flightDate;
    private HotelDTO hotel;
    private int roomNumber;
    private Date checkingDate;
    private Date checkoutDate;
}
