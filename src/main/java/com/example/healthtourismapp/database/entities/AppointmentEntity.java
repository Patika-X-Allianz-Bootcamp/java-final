package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class AppointmentEntity extends BaseEntity {

    @Column
    private LocalDateTime date;

    @OneToOne
    private PatientEntity patient;

    @OneToOne
    private HotelEntity hotel;

    @OneToOne
    private FlightEntity flight;

    @OneToOne
    private HospitalEntity hospital;

    @Column
    private double totalBill;
}
