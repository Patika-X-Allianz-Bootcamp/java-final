package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class PlaneTicketEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    private FlightEntity flight;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_id")
    private SeatEntity seat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
}
