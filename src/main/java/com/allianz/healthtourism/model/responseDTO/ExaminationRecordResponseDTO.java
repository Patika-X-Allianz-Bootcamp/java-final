package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.AppointmentPlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

@Data
public class ExaminationRecordResponseDTO extends BaseResponseDTO {
    private String notes;
    private AppointmentWithPatientResponseDTO appointment;
}
