package com.healthtourism.healthtourism.model.RequestDTO;

import com.healthtourism.healthtourism.database.entities.AppointmentHoursEnum;
import com.healthtourism.healthtourism.database.entities.SpecializationEnum;
import com.healthtourism.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class DoctorRequestDTO extends BaseDTO {
    private String firstName;
    private String lastName;
    private String specialization;
}
