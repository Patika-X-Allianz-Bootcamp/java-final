package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "flights")
public class FlightEntity extends BaseEntity {

    @Column
    private String airline;

    @Column
    private LocalDateTime fligtTime;

    @Column(unique = true)
    private String flightNumber;

    @OneToOne
    private CityEntity departureCity;

    @OneToOne
    private CityEntity destinationCity;

    @OneToMany(mappedBy = "flight")
    private List<PatientEntity> patientList;
}
