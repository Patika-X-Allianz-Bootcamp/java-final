package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

@Data
public class PatientDTO extends BaseDTO {

	private String name;
	private String surname;
	private String email;
	private String phone;
	private String address;
}
