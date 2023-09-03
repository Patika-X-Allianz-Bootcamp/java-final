package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

@Data
public class MedicationDTO extends BaseDTO {

    private String name;
    private String dosage;

}
