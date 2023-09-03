package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.model.enums.CountryCodeEnum;
import com.allianz.healthtourismagency.model.enums.CurrencyEnum;
import com.allianz.healthtourismagency.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class FlightRequestDTO extends BaseDTO {

    private String departingCity;
    private String arrivingCity;
    private CountryCodeEnum departingCountry;
    private CountryCodeEnum arrivingCountry;
    @Schema(type = "string", format = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate departingDate;
    @Schema(example = "00:00:00", format = "HH:mm:ss")
    private LocalTime departingTime;
    @Schema(example = "00:00:00", format = "HH:mm:ss")
    private LocalTime arrivingTime;
    private BigDecimal price;
    private CurrencyEnum currency;
    @JsonIgnore
    private String flightDuration;
    private int capacity;
    @JsonIgnore
    private List<SeatRequestDTO> seatList;


}
