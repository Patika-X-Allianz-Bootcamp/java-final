package com.allianz.patienttourism.model.responseDTO;

import com.allianz.patienttourism.util.BaseResponseDTO;
import lombok.Data;

@Data
public class ExaminationReportResponseDTO extends BaseResponseDTO {

    private Long doctorId;
    private Long patientId;
    private String report;
}
