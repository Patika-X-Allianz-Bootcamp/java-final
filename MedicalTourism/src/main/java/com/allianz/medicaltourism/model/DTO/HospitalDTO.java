package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO extends BaseDTO {
	private String name;
	private String address;
	private String phone;
	private String email;
	private List<HospitalRoomDTO> hospitalRooms;
	private List<DoctorDTO> doctors;
	private List<DepartmentDTO> departments;
}
