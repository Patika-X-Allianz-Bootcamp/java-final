package com.allianz.patienttourism.database.entity;

import com.allianz.patienttourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "doctors")
@Data
public class Doctor extends BaseEntity {

    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
    @Column(name = "age")
    int age;
    @Column(name = "department")
    String department;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    Hospital hospital;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;
}
