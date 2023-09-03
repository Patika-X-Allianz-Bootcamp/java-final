package com.allianz.patienttourism.database.entity;

import com.allianz.patienttourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "patients")
@Data
public class Patient extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "patient")
    private List<Booking> bookingList;

    @OneToMany(mappedBy = "patient")
    private List<Ticket> ticketList;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointmentList;




}
