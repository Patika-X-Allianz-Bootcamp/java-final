package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table
@Data
public class HotelEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String numberOfStars;

    @OneToMany
    private List<HotelRoomEntity> hotelRoomList;

}
