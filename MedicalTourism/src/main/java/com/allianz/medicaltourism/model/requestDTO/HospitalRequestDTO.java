package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalRequestDTO extends BaseDTO {
	private String name;
	private String address;
	private String phone;
	private String email;
	private List<HospitalRoomRequestDTO> hospitalRooms;
	private List<DoctorRequestDTO> doctors;
	private List<DepartmentRequestDTO> departments;
}
