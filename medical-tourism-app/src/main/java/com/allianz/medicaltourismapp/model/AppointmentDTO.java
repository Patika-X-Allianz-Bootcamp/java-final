package com.allianz.medicaltourismapp.model;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;

import lombok.Data;


@Data
public class AppointmentDTO extends BaseDTO {
        private String appointmentCode;
        private String date;
        private String time;
        private DoctorDTO doctor;
        private PatientDTO patient;

}
