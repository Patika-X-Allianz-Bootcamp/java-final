package com.allianz.HealthTourismSpringBoot.database.entities;

import com.allianz.HealthTourismSpringBoot.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table
@Data
public class AirlineEntity extends BaseEntity {

    @Column(unique = true,nullable = false)
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "agency_id", nullable = false)
    private AgencyEntity agency;

}
