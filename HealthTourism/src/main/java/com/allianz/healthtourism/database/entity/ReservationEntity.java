package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reservations")
public class ReservationEntity extends BaseEntity {
    @ManyToOne
    private RoomEntity room;
    @OneToOne
    private PatientEntity patient;
    @Column
    private LocalDateTime reservationDate;

    @Column
    private boolean isPaid = false;
}
