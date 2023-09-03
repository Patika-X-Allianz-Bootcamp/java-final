package com.allianz.patienttourism.model.responseDTO;

import com.allianz.patienttourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class DoctorResponseDTO extends BaseResponseDTO {


    String name;

    String surname;

    int age;

    String department;

    Long hospitalId;

    List<AppointmentResponseDTO> appointmentList;

}
