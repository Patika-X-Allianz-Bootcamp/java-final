package com.allianz.HealthTourismSpringBoot.database.entities;

import com.allianz.HealthTourismSpringBoot.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class BookingEntity extends BaseEntity {

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id",nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "plane_id",nullable = false)
    private PlaneEntity plane;

    @Column(nullable = false,unique = true)
    private String planeSeat;

    @Column(nullable = false)
    private String departureLocation;

    @Column(nullable = false)
    private String arrivalLocation;

    @Column(nullable = false)
    private Date fligthDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "hotel_id",nullable = false)
    private HotelEntity hotel;

    @Column(nullable = false,unique = true)
    private int roomNumber;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date checkinDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date checkoutDate;



}
