package com.patika.healthtourism.database.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.patika.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table
@Entity
public class FlightEntity extends BaseEntity {
    @Column
    private String airlineName;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;

    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime departureDateTime;

    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime arrivalDateTime;
    private Double price;
}
