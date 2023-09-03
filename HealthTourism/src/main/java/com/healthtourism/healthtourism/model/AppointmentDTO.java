package com.healthtourism.healthtourism.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthtourism.healthtourism.database.entities.*;
import com.healthtourism.healthtourism.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class AppointmentDTO extends BaseDTO {
    private LocalDateTime dateAndTime;
    private String status;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private LocalDate appointmentDate; // Randevu tarihi
    private String appointmentTime; // Randevu saati
}