package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

@Data
public class MedicationRequestDTO extends BaseDTO {

    private String name;
    private String dosage;

}
