package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hotels")
@Data
public class HotelEntity extends BaseEntity {

    @Column
    private String city;

    @Column
    private int capacity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomEntity> roomList;

}
