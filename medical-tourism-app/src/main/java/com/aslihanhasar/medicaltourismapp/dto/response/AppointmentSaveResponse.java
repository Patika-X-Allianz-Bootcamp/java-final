package com.aslihanhasar.medicaltourismapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentSaveResponse {
    private Long appointmentId;
    private DoctorSaveResponse doctor;
    private LocalDateTime appointmentDateTime;
}
