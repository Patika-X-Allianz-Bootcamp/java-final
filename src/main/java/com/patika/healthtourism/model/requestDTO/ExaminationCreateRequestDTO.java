package com.patika.healthtourism.model.requestDTO;

import com.patika.healthtourism.util.BaseDTO;
import com.patika.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ExaminationCreateRequestDTO extends BaseRequestDTO {
    private LocalDateTime examinationDateTime;
    private String notes;
}
