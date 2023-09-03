package com.allianz.meliorator.model.requestDTO;

import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class PatientRequestDTO extends PersonRequestDTO {
    private List<POFReqDTO> POFReqDTOList;
    @OneToMany
    private List<HousingRequestDTO> housingRequestDTOList;
    private List<AppointmentRequestDTO> appointmentRequestDTOList;
}
