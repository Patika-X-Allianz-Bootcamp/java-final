package com.healthtourism.healthtourism.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthtourism.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class FlightInfoEntity extends BaseEntity {
    @Column
    private String airlineCompany;
    @Column
    private String flightNumber;
    @Column
    private String departureCity;
    @Column
    private String arrivalCity;
    @Column
    private LocalDateTime arrivalDateTime;
    @Column
    private String reservationStatus;
    @Column
    private boolean confirmed;
    @Column
    private LocalDateTime departureDateTime; // Uçağın kalkış zamanı
    @Column
    private LocalDateTime currentDateTime= LocalDateTime.now();   // Anlık zaman
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id") // Burada flight_id sütununu kullanabilirsiniz
    private List<PatientEntity> patients = new ArrayList<>();


    public List<PatientEntity> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientEntity> patients) {
        this.patients = patients;
    }



    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
