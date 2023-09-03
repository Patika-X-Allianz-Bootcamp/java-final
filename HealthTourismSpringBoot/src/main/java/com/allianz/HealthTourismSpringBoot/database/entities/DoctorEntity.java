package com.allianz.HealthTourismSpringBoot.database.entities;

import com.allianz.HealthTourismSpringBoot.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table
@Data
public class DoctorEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String profession;

    @ManyToOne
    @JoinColumn(name = "hospital_id",nullable = false)
    @JsonIgnore
    private HospitalEntity hospital;

}
