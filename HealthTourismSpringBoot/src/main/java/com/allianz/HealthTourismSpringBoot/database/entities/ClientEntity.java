package com.allianz.HealthTourismSpringBoot.database.entities;

import com.allianz.HealthTourismSpringBoot.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table
@Data
public class ClientEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String healthCare;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "agency_id",nullable = false)
    private AgencyEntity agency;
}
