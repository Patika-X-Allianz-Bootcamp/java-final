package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

@Data
public class ExaminationCardResponseDTO extends BaseDTO {
    String diagnosis;
    String note;
}
