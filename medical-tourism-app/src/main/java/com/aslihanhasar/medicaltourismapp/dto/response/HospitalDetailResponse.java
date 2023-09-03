package com.aslihanhasar.medicaltourismapp.dto.response;

import com.aslihanhasar.medicaltourismapp.dto.response.DoctorSaveResponse;
import com.aslihanhasar.medicaltourismapp.dto.response.HospitalSaveResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalDetailResponse {
    private HospitalSaveResponse hospital;
    private List<DoctorSaveResponse> doctors;
}
