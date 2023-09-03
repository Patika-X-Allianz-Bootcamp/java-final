package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.model.enums.FlightClassEnum;
import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class FlightSeatEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private FlightClassEnum flightClass;

    @Column(unique = true, nullable = false)
    private String seatNumber;

}
