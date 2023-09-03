package com.patika.healthtourism.database.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.patika.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class TravelPlanEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    private FlightEntity flight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime reservationDateTime;
    private Boolean confirmed;
    private Double price;
}
