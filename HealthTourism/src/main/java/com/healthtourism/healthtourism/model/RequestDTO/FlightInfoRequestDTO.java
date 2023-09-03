package com.healthtourism.healthtourism.model.RequestDTO;

import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.model.PatientDTO;
import com.healthtourism.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class FlightInfoRequestDTO extends BaseDTO {
    private String airlineCompany;
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime arrivalDateTime;
    private String reservationStatus;
    private boolean confirmed;
    private LocalDateTime departureDateTime; // Uçağın kalkış zamanı
    private LocalDateTime currentDateTime;
    private List<PatientDTO> patients;

    private List<UUID> patientUuids;

    // Diğer getter ve setter metotları burada olabilir

    public List<UUID> getPatientUuids() {
        return patientUuids;
    }

    public void setPatientUuids(List<UUID> patientUuids) {
        this.patientUuids = patientUuids;
    }
}
