package com.aslihanhasar.medicaltourismapp.dto.response;

import com.aslihanhasar.medicaltourismapp.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentPlanResponse {
    private PatientSaveResponse patient;
    private AppointmentSaveResponse appointment;
    private AppointmentStatus appointmentStatus;
}
