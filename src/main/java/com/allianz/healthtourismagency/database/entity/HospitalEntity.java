package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Table(name = "hospitals")
@Data
public class HospitalEntity extends BaseEntity {

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DoctorEntity> doctorList;

}
