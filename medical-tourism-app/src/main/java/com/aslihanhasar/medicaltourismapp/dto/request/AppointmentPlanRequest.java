package com.aslihanhasar.medicaltourismapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentPlanRequest {
    @NotBlank
    private String patientNumber;
    @NotBlank
    private Long appointmentId;
}
