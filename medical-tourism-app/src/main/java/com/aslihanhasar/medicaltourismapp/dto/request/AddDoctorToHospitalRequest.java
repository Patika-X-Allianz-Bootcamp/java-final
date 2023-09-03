package com.aslihanhasar.medicaltourismapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddDoctorToHospitalRequest {
    private Long hospitalId;
    private Set<Long> doctorIds;
}
