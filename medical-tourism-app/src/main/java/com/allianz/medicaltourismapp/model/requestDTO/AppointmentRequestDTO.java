package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;


@Data
public class AppointmentRequestDTO extends BaseDTO {
        private String date;
        private String time;
        private DoctorRequestDTO doctor;
        private PatientRequestDTO patient;

}
