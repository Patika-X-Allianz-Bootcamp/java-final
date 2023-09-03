package com.healthtourism.healthtourism.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthtourism.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class HotelInfoEntity extends BaseEntity {

    @Column(nullable = false)
    private String hotelName;
    @Column
    private String city;
    @Column
    private String reservationStatus;
    @ManyToOne
    @JoinColumn(name = "patient_entity_id")
    @JsonIgnore
    private PatientEntity patient;

    private boolean isConfirmed;  // Rezervasyon onay durumu

    private boolean isInvalid;  // Rezervasyon geçerlilik durumu

    private LocalDateTime createdAt = LocalDateTime.now();

}
