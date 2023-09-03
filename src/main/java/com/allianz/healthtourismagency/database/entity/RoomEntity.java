package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "rooms")
@Data
public class RoomEntity extends BaseEntity {

    private int roomNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelReservationEntity> reservationList = new ArrayList<>();


}
