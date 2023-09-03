package com.healthtourism.healthtourism.model.RequestDTO;

import com.healthtourism.healthtourism.database.entities.AppointmentHoursEnum;
import com.healthtourism.healthtourism.model.*;
import com.healthtourism.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AppointmentRequestDTO extends BaseDTO {
    private LocalDateTime dateAndTime;
    private String status;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private LocalDate appointmentDate; // Randevu tarihi
    private String appointmentTime; // Randevu saati // Randevu saati

    private UUID doctorUuid;

    // Getter metotları
    public UUID getDoctorUuid() {
        return doctorUuid;
    }


    private UUID patientUuid;

    public UUID getPatientUuid() {
        return patientUuid;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

}
