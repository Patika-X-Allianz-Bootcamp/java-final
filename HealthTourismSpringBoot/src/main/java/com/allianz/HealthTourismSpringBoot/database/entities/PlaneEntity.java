package com.allianz.HealthTourismSpringBoot.database.entities;

import com.allianz.HealthTourismSpringBoot.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class PlaneEntity extends BaseEntity {

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int totalSeats;

    @Column(nullable = false)
    private int availableSeats;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "airline_id",nullable = false)
    private AirlineEntity airline;
}
