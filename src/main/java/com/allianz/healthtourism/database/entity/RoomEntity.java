package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "rooms")
public class RoomEntity extends BaseEntity {
    @Column
    private int capacity;
    @Column
    private LocalDate checkInDate;
    @Column
    private LocalDate checkOutDate;
    @ManyToOne
    private HotelEntity hotel;
    @OneToMany
    private List<ReservationEntity> reservations;
}