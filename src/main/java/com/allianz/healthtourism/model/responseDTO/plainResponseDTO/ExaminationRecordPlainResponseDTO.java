package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

@Data
public class ExaminationRecordPlainResponseDTO extends BaseResponseDTO {
    private String notes;
}
