package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.model.DTO.AppointmentDTO;
import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

@Data
public class DoctorRequestDTO extends BaseDTO {
	private String name;
	private String surname;
	private String email;
	private String phone;
	private String Branch;
}
