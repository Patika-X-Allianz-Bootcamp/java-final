package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "hospitals")
public class HospitalEntity extends BaseEntity {

    @Column
    private String name;

    @ManyToOne
    private CityEntity city;

    @OneToMany(mappedBy = "hospital")
    private List<DoctorEntity> doctorList;
}
