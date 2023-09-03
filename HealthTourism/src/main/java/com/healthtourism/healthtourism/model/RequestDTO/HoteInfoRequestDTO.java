package com.healthtourism.healthtourism.model.RequestDTO;

import com.healthtourism.healthtourism.model.PatientDTO;
import com.healthtourism.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class HoteInfoRequestDTO extends BaseDTO {

    private String hotelName;
    private String city;
    private String roomTypesAndPrices;
    private String reservationStatus;
    private PatientDTO patient;
    private UUID patientUuid;

    public UUID getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(UUID patientUuid) {
        this.patientUuid = patientUuid;
    }
}
