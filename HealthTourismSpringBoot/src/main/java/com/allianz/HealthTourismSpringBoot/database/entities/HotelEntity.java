package com.allianz.HealthTourismSpringBoot.database.entities;

import com.allianz.HealthTourismSpringBoot.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class HotelEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int totalRooms;

    @Column(nullable = false)
    private int availableRooms;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "agency_id",nullable = false)
    private AgencyEntity agency;
}
