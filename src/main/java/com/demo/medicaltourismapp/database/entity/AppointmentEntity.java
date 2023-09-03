package com.demo.medicaltourismapp.database.entity;

import com.demo.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "appointment_id"
        )
)
public class AppointmentEntity extends BaseEntity {

    // ideally there are two flights for each appointment
    // but if there are transfers we may need more reservations
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_flight")
    private List<FlightEntity> flights;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_hotel")
    private HotelEntity hotel;

    @OneToOne
    @JoinColumn(name = "appointment_doctor")
    private DoctorEntity doctor;

    @OneToOne
    @JoinColumn(name = "appointment_hospital")
    private HospitalEntity hospital;

    @Column(nullable = false)
    private int hotelStayDurationInDays;

    @Column
    private LocalDate reservationStartDay;

    // this will be the notes taken by a doctor during/after an appointment
    @Column(name = "doctor_notes")
    private String doctorsNotes;

}
