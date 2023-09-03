package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import com.allianz.healthtourism.util.security.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class PatientEntity extends PersonEntity {
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<ExaminationRecordEntity> examinationRecords;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient")
    private List<BookingEntity> bookings;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "patient")
    private List<AppointmentEntity> appointments;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "patient")
    private List<PlaneTicketEntity> planeTickets;


}
