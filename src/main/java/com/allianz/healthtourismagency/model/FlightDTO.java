package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.model.enums.CountryCodeEnum;
import com.allianz.healthtourismagency.model.enums.CurrencyEnum;
import com.allianz.healthtourismagency.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class FlightDTO extends BaseDTO {

    private String departingCity;
    private String arrivingCity;
    private CountryCodeEnum departingCountry;
    private CountryCodeEnum arrivingCountry;
    private LocalDate departingDate;
    private LocalTime departingTime;
    private LocalTime arrivingTime;
    private BigDecimal price;
    private CurrencyEnum currency;
    private String flightDuration;
    private int capacity;
    @JsonIgnore
    private List<SeatDTO> seatList;
}
