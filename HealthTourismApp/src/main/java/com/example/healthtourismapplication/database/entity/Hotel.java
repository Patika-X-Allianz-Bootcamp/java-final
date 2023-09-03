package com.example.healthtourismapplication.database.entity;

import com.example.healthtourismapplication.util.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Hotel extends BaseEntity {
    private String name;
    private String location;

    @OneToMany(mappedBy = "hotel")
    private List<HotelReservation> hotelReservations;

}
