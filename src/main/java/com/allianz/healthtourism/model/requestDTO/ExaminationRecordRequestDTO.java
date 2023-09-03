package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import lombok.Data;

@Data
public class ExaminationRecordRequestDTO extends BaseRequestDTO {
    private String notes;
    private Long appointmentId;
}
