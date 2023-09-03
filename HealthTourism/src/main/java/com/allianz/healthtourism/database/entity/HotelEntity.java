package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "hotels")
public class HotelEntity extends BaseEntity {

    @Column
    private String name;

    @OneToMany
    private List<RoomEntity> rooms;

    @ManyToOne
    private CityEntity city;

    @OneToMany(mappedBy = "hotel")
    private List<PatientEntity> patientList;
}
