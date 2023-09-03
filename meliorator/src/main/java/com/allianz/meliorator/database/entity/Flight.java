package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Data
public class Flight extends BaseEntity {
    @Column
    private String CompanyName;
    @OneToOne
    private City departureFrom;
    @OneToOne
    private City arrivalTo;
    @Column
    private LocalDateTime departureTime;
    @Column
    private LocalDateTime arrivalTime;
    @Column
    private String flightNumber;
    @Column
    private Time flightDuration;




}
