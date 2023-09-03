package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class FlightEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String flightCode;

    @Column
    private String fromWhere;

    @Column
    private String toWhere;

    @Column
    private Date Date;

    @Column
    private double distance;

    @OneToMany(fetch = FetchType.EAGER)
    private List<FlightSeatEntity> seat;


}
