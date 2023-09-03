package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.model.enums.CountryCodeEnum;
import com.allianz.healthtourismagency.model.enums.CurrencyEnum;
import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "flights")
@Data
public class FlightEntity extends BaseEntity {

    @Column
    private String departingCity;

    @Column
    private String arrivingCity;

    @Enumerated(EnumType.STRING)
    private CountryCodeEnum departingCountry;

    @Enumerated(EnumType.STRING)
    private CountryCodeEnum arrivingCountry;

    @Temporal(TemporalType.DATE)
    private LocalDate departingDate;

    @Temporal(TemporalType.TIME)
    private LocalTime departingTime;

    @Temporal(TemporalType.TIME)
    private LocalTime arrivingTime;

    @Column
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    @Column
    private String flightDuration;

    @Column
    private int capacity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeatEntity> seatList;

}
