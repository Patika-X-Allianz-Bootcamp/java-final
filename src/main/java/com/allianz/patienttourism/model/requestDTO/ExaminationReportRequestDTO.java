package com.allianz.patienttourism.model.requestDTO;

import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

@Data
public class ExaminationReportRequestDTO extends BaseRequestDTO {

    private Long doctorId;
    private Long patientId;
    private String report;
}
