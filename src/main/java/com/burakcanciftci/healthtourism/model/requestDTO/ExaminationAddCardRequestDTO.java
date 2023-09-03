package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class ExaminationAddCardRequestDTO extends BaseDTO {
    UUID examinationCardUuid;
}
