package com.allianz.patienttourism.database.entity;

import com.allianz.patienttourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "flights")
@Data
public class Flight extends BaseEntity {

    @Column(name = "company")
    private String company;

    @Column(name = "flightTime")
    private LocalDateTime flightTime;

    @Column(name = "fromCity")
    private String fromCity;

    @Column(name = "toCity")
    private String toCity;

    @OneToMany(mappedBy = "flight")
    private List<Seat> seatList;

}
