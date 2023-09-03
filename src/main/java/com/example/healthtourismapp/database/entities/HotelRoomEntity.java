package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.model.enums.RoomTypeEnum;
import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class HotelRoomEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private RoomTypeEnum roomType;
}
